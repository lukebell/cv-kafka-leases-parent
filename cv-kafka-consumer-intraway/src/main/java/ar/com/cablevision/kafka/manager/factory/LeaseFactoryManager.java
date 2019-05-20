package ar.com.cablevision.kafka.manager.factory;

import ar.com.cablevision.common.kafka.messages.enriched.Lease;
import ar.com.cablevision.common.kafka.messages.raw.RawLease;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class LeaseFactoryManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(LeaseFactoryManager.class);

    static Map<String, LeaseFactory> ipTables = new HashMap<>();

    static {
        ipTables.put(LeaseFactory.CV_EXP_CM_LEASES_IPV4.getTable(), LeaseFactory.CV_EXP_CM_LEASES_IPV4);
        ipTables.put(LeaseFactory.CV_EXP_ESTB_LEASES_IPV4.getTable(), LeaseFactory.CV_EXP_ESTB_LEASES_IPV4);
        ipTables.put(LeaseFactory.CV_EXP_PKT_LEASES_IPV4.getTable(), LeaseFactory.CV_EXP_PKT_LEASES_IPV4);
        ipTables.put(LeaseFactory.CV_EXP_CPE_LEASES_IPV6.getTable(), LeaseFactory.CV_EXP_CPE_LEASES_IPV6);
    }

    public static Lease createLease(RawLease message) throws Exception {

        try {
            return ipTables.get(message.getTable()).build(message.getAfter());
        } catch (NullPointerException e) {
            throw new Exception("No such table found: " + message.getTable());
        }
    }
}