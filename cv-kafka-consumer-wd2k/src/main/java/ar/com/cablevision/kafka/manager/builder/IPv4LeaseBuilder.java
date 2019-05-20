package ar.com.cablevision.kafka.manager.builder;

import ar.com.cablevision.common.kafka.messages.enriched.IPv4;
import ar.com.cablevision.common.wd2k.domain.IPv4Lease;

public class IPv4LeaseBuilder extends LeaseBuilder<IPv4> {

    @Override
    public IPv4Lease build(IPv4 ip){
        IPv4Lease lease = new IPv4Lease();
        setBaseLease(lease, ip);
        return lease;
    }
}
