package ar.com.cablevision.kafka.manager.builder;

import ar.com.cablevision.common.kafka.messages.raw.IPv4Raw;
import ar.com.cablevision.common.kafka.messages.enriched.IPv4;

public class IPv4LeaseBuilder extends LeaseBuilder<IPv4Raw> {

    @Override
    public IPv4 build(IPv4Raw ip){
        IPv4 lease = new IPv4();
        setBaseLease(lease, ip);
        return lease;
    }
}
