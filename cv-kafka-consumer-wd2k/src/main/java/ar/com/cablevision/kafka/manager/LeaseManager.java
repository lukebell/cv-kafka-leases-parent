package ar.com.cablevision.kafka.manager;

import ar.com.cablevision.common.kafka.messages.enriched.KafkaLeaseMessage;
import ar.com.cablevision.common.kafka.messages.enriched.Lease;
import ar.com.cablevision.common.wd2k.domain.IPv4Lease;
import ar.com.cablevision.common.wd2k.domain.IPv6Lease;
import ar.com.cablevision.common.wd2k.domain.BaseLease;
import ar.com.cablevision.kafka.manager.factory.LeaseFactory;
import ar.com.cablevision.kafka.manager.factory.LeaseFactoryManager;
import ar.com.cablevision.kafka.manager.strategy.IPv4LeaseStrategy;
import ar.com.cablevision.kafka.manager.strategy.IPv6LeaseStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LeaseManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(LeaseManager.class);

    private static final Integer MAX_RECORD_SIZE = 50;

    @Autowired
    private IPv4LeaseStrategy iPv4LeaseStrategy;

    @Autowired
    private IPv6LeaseStrategy iPv6LeaseStrategy;

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

        // Sets IPv4Raw/IPv6Raw BaseLease
        setLease(record);

        if (iPv4LeaseStrategy.getLeases().size() == MAX_RECORD_SIZE || iPv6LeaseStrategy.getLeases().size() == MAX_RECORD_SIZE) {
            // Writing leases
            if (!iPv4LeaseStrategy.getLeases().isEmpty()) {
                iPv4LeaseStrategy.writeLeases(iPv4LeaseStrategy.getLeases());
            }
            if (!iPv6LeaseStrategy.getLeases().isEmpty()) {
                iPv6LeaseStrategy.writeLeases(iPv6LeaseStrategy.getLeases());
            }
        }
    }

    /**
     * Sets an IPv4/IPv6 BaseLease
     *
     * @param record The record received
     */
    private void setLease(KafkaLeaseMessage<Lease> record) throws Exception{

        //LOGGER.debug("Setting BaseLease = '{}'", record.getLease().toString());

        BaseLease lease = LeaseFactoryManager.createLease(record);

        if (record.getType().equalsIgnoreCase(LeaseFactory.IPv4.getKey())) {
            iPv4LeaseStrategy.getLeases().put(lease.getIdLease(), (IPv4Lease) lease);
        } else {
            iPv6LeaseStrategy.getLeases().put(lease.getIdLease(), (IPv6Lease) lease);
        }
    }
}
