package ar.com.cablevision.kafka.manager.factory;

import ar.com.cablevision.common.kafka.messages.enriched.KafkaLeaseMessage;
import ar.com.cablevision.common.kafka.messages.enriched.Lease;
import ar.com.cablevision.common.wd2k.domain.BaseLease;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class LeaseFactoryManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(LeaseFactoryManager.class);

    static Map<String, LeaseFactory> ipTables = new HashMap<>();

    static {
        ipTables.put(LeaseFactory.IPv4.getKey(), LeaseFactory.IPv4);
        ipTables.put(LeaseFactory.IPv6.getKey(), LeaseFactory.IPv6);
    }

    public static BaseLease createLease(KafkaLeaseMessage<Lease> message) throws Exception {

        try {
            return ipTables.get(message.getType()).build(message.getLease());
        } catch (NullPointerException e) {
            throw new Exception("No such type found: " + message.getType());
        }
    }
}