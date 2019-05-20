package ar.com.cablevision.kafka.manager.factory;

import ar.com.cablevision.common.kafka.messages.raw.IPRaw;
import ar.com.cablevision.common.kafka.messages.raw.IPv4Raw;
import ar.com.cablevision.common.kafka.messages.raw.IPv6Raw;
import ar.com.cablevision.kafka.manager.builder.IPv4LeaseBuilder;
import ar.com.cablevision.kafka.manager.builder.IPv6LeaseBuilder;
import ar.com.cablevision.common.kafka.messages.enriched.Lease;

public enum LeaseFactory {

    CV_EXP_ESTB_LEASES_IPV4("CV.EXP_ESTB_LEASES_IPV4") {
        @Override
        public Lease build(IPRaw ip) {
            IPv4Raw iPv4 = (IPv4Raw) ip;
            return iPv4LeaseBuilder.build(iPv4);
        }
    },
    CV_EXP_CM_LEASES_IPV4("CV.EXP_CM_LEASES_IPV4") {
        @Override
        public Lease build(IPRaw ip) {
            IPv4Raw iPv4 = (IPv4Raw) ip;
            return iPv4LeaseBuilder.build(iPv4);
        }
    },
    CV_EXP_PKT_LEASES_IPV4("CV.EXP_PKT_LEASES_IPV4") {
        @Override
        public Lease build(IPRaw ip) {
            IPv4Raw iPv4 = (IPv4Raw) ip;
            return iPv4LeaseBuilder.build(iPv4);
        }
    },
    CV_EXP_CPE_LEASES_IPV6("CV.EXP_CPE_LEASES_IPV6") {
        @Override
        public Lease build(IPRaw ip) {
            IPv6Raw iPv6 = (IPv6Raw) ip;
            return iPv6LeaseBuilder.build(iPv6);
        }
    };

    private LeaseFactory(String table) {
        this.table = table;
    }

    private static final IPv4LeaseBuilder iPv4LeaseBuilder = new IPv4LeaseBuilder();

    private static final IPv6LeaseBuilder iPv6LeaseBuilder = new IPv6LeaseBuilder();

    private String table;

    public String getTable() {
        return table;
    }

    public abstract Lease build(IPRaw ip);

    @Override
    public String toString() {
        return "IPRaw Table -> " + table;
    }

}
