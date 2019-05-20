package ar.com.cablevision.kafka.manager.factory;

import ar.com.cablevision.common.kafka.messages.enriched.KafkaLeaseMessage;
import ar.com.cablevision.common.kafka.messages.enriched.Lease;
import ar.com.cablevision.common.mongodb.domain.BaseLease;
import ar.com.cablevision.common.mongodb.domain.MacAddressLease;
import ar.com.cablevision.common.mongodb.domain.IPv4Lease;
import ar.com.cablevision.common.mongodb.domain.IPv6Lease;
import org.apache.commons.collections4.CollectionUtils;
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

    @SuppressWarnings("unchecked")
    public static MacAddressLease createMacAddressLease(KafkaLeaseMessage<Lease> message)
            throws Exception {

        try {
            MacAddressLease macAddressLease = new MacAddressLease<>();
            macAddressLease.setMacAddress(message.getLease().getMacAddress());
            BaseLease lease = ipTables.get(message.getType()).build(message.getLease());
            if (message.getType().equalsIgnoreCase(LeaseFactory.IPv4.getKey())) {
                IPv4Lease iPv4Lease = (IPv4Lease) lease;
                macAddressLease.setIpv4(iPv4Lease);
                CollectionUtils.addIgnoreNull(macAddressLease.getHistory(), iPv4Lease);
            } else {
                IPv6Lease iPv6Lease = (IPv6Lease) lease;
                macAddressLease.setIpv6(iPv6Lease);
                CollectionUtils.addIgnoreNull(macAddressLease.getHistory(), iPv6Lease);
            }
            return macAddressLease;
        } catch (NullPointerException e) {
            throw new Exception("No such type found: " + message.getType());
        }
    }
}