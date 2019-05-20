package ar.com.cablevision.kafka.manager.builder;

import ar.com.cablevision.common.kafka.messages.enriched.IPv6;
import ar.com.cablevision.common.mongodb.domain.IPv6Lease;

public class IPv6LeaseBuilder extends LeaseBuilder<IPv6> {

    @Override
    public IPv6Lease build(IPv6 ip) {
        IPv6Lease lease = new IPv6Lease();
        setBaseLease(lease, ip);
        lease.setDuId(ip.getDuId());
        lease.setIaId(ip.getIaId());
        lease.setIaType(ip.getIaType());
        lease.setPrefixLength(ip.getPrefixLength());

        return lease;
    }
}
