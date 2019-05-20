package ar.com.cablevision.kafka.manager;

import ar.com.cablevision.common.kafka.messages.enriched.KafkaLeaseMessage;
import ar.com.cablevision.common.kafka.messages.enriched.Lease;
import ar.com.cablevision.common.mongodb.domain.MacAddressLease;
import ar.com.cablevision.common.mongodb.repository.lease.LeaseRepository;
import ar.com.cablevision.common.wd2k.domain.IPv4Lease;
import ar.com.cablevision.common.wd2k.domain.IPv6Lease;
import ar.com.cablevision.common.wd2k.domain.BaseLease;
import ar.com.cablevision.kafka.manager.factory.LeaseFactory;
import ar.com.cablevision.kafka.manager.factory.LeaseFactoryManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LeaseManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(LeaseManager.class);

    @Autowired
    private LeaseRepository leaseRepository;

    /**
     * Default constructor
     */
    public LeaseManager() {
    }

    /**
     * Process the record to an enriched lease kafka message
     *
     * @param record The record received
     */
    public void processLease(KafkaLeaseMessage<Lease> record) throws Exception {

        // Sets IPv4/IPv6 BaseLease
        MacAddressLease lease = setLease(record);
        // Saves or Updates Lease
        leaseRepository.upsertCustom(lease);
    }

    /**
     * Sets an IPv4/IPv6 BaseLease
     *
     * @return MacAddressLease
     * @throws Exception e
     */
    private MacAddressLease setLease(KafkaLeaseMessage<Lease> record) throws Exception{

        //LOGGER.debug("Setting BaseLease = '{}'", record.getLease().toString());
        return LeaseFactoryManager.createMacAddressLease(record);
    }
}
