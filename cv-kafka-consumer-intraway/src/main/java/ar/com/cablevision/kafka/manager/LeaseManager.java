package ar.com.cablevision.kafka.manager;

import ar.com.cablevision.common.wd2k.domain.Cablemodem;
import ar.com.cablevision.common.wd2k.repository.CablemodemRepository;
import ar.com.cablevision.common.kafka.messages.raw.IPRaw;
import ar.com.cablevision.common.kafka.messages.raw.RawLease;
import ar.com.cablevision.kafka.manager.factory.LeaseFactoryManager;
import ar.com.cablevision.kafka.producer.LeaseProducer;
import ar.com.cablevision.common.kafka.messages.enriched.KafkaLeaseMessage;
import ar.com.cablevision.common.kafka.messages.enriched.Lease;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class LeaseManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(LeaseManager.class);

    private static final Integer MAC_ADDRESSES_MAX = 10;

    private static final String PRODUCER_TOPICS = "enrichedLeases";

    @Autowired
    private CablemodemRepository cablemodemRepository;

    @Autowired
    private LeaseProducer producer;

    private Map<String, List<Lease>> macLeases;

    private ObjectMapper mapper;

    /**
     * Default constructor
     */
    public LeaseManager() {
        this.macLeases = new ConcurrentHashMap<>();
        this.mapper = new ObjectMapper();
        this.mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    /**
     * Process the record to an enriched lease kafka message
     *
     * @param record The record received
     */
    public synchronized void processLease(RawLease<IPRaw> record) throws Exception {

        // Sets IPv4Raw/IPv6Raw BaseLease
        setLease(record);

        if (macLeases.keySet().size() == MAC_ADDRESSES_MAX) {

            LOGGER.debug("Getting Client ID's from mac addresses");

            // Gets client id
            List<Cablemodem> cablemodems = cablemodemRepository.findIdClienteByMacAddress(macLeases.keySet());

            // Sets client id
            for (Cablemodem cablemodem : cablemodems) {
                for (Lease lease : macLeases.get(cablemodem.getMacAddress())) {
                    lease.setClientId(cablemodem.getIdCliente());
                }
            }

            // Writes messages
            for (Map.Entry<String, List<Lease>> macLease : macLeases.entrySet()) {
                for (Lease lease : macLease.getValue()) {
                    writeMessage(lease);
                }
            }

            this.macLeases = new ConcurrentHashMap<>();
        }
    }

    /**
     * Writes Kakfa message
     *
     * @param l The lease to write
     * @throws JsonProcessingException Exception
     */
    private void writeMessage(Lease l) throws Exception {
        KafkaLeaseMessage<Lease> kl = new KafkaLeaseMessage<>(l.getClass().getSimpleName(), l);
        producer.sendMessage(PRODUCER_TOPICS, mapper.writeValueAsString(kl));
    }

    /**
     * Sets an IPv4Raw/IPv6Raw BaseLease
     *
     * @param record The record received
     */
    private void setLease(RawLease<IPRaw> record) throws Exception {

        //LOGGER.debug("Setting BaseLease = '{}'", record.getAfter().toString());

        Lease lease = LeaseFactoryManager.createLease(record);
        String macAddress = lease.getMacAddress();
        if (macLeases.containsKey(macAddress)) {
            macLeases.get(macAddress).add(lease);
        } else {
            List<Lease> leases = new ArrayList<>();
            leases.add(lease);
            macLeases.put(macAddress, leases);
        }
    }
}
