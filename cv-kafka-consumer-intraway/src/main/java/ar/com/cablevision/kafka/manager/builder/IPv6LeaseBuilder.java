package ar.com.cablevision.kafka.manager.builder;

import ar.com.cablevision.common.kafka.messages.raw.IPv6Raw;
import ar.com.cablevision.common.kafka.messages.enriched.IPv6;


public class IPv6LeaseBuilder extends LeaseBuilder<IPv6Raw> {

    private final static String MAC_ADDRESS_PREFIX = "01:06:";

    @Override
    public IPv6 build(IPv6Raw ip) {
        IPv6 lease = new IPv6();
        setBaseLease(lease, ip);
        lease.setMacAddress(MAC_ADDRESS_PREFIX + ip.getMacRelay());
        lease.setDuId(ip.getDuId());
        lease.setIaId(ip.getIaId());
        lease.setIaType(ip.getIaType());
        lease.setPrefixLength(ip.getPrefixLength());

        return lease;
    }
}
