package ar.com.cablevision.kafka.manager.factory;

import ar.com.cablevision.common.kafka.messages.enriched.IPv4;
import ar.com.cablevision.common.kafka.messages.enriched.IPv6;
import ar.com.cablevision.common.kafka.messages.enriched.Lease;
import ar.com.cablevision.common.wd2k.domain.IPv4Lease;
import ar.com.cablevision.common.wd2k.domain.IPv6Lease;
import ar.com.cablevision.common.wd2k.domain.BaseLease;
import ar.com.cablevision.kafka.manager.builder.IPv4LeaseBuilder;
import ar.com.cablevision.kafka.manager.builder.IPv6LeaseBuilder;


public enum LeaseFactory {

    IPv4("IPv4") {
        @Override
        public IPv4Lease build(Lease ip) {
            IPv4 iPv4 = (IPv4) ip;
            return iPv4LeaseBuilder.build(iPv4);
        }
    },
    IPv6("IPv6") {
        @Override
        public IPv6Lease build(Lease ip) {
            IPv6 iPv6 = (IPv6) ip;
            return iPv6LeaseBuilder.build(iPv6);
        }
    };

    private LeaseFactory(String key) {
        this.key = key;
    }

    private static final IPv4LeaseBuilder iPv4LeaseBuilder = new IPv4LeaseBuilder();

    private static final IPv6LeaseBuilder iPv6LeaseBuilder = new IPv6LeaseBuilder();

    private String key;

    public String getKey() {
        return key;
    }

    public abstract BaseLease build(Lease lease);

    @Override
    public String toString() {
        return "IP key -> " + key;
    }

}
