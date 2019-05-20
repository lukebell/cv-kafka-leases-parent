package ar.com.cablevision.kafka.manager.builder;

import ar.com.cablevision.common.kafka.messages.enriched.Lease;
import ar.com.cablevision.common.mongodb.domain.BaseLease;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;

public abstract class LeaseBuilder<K extends Lease> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LeaseBuilder.class);

    protected void setBaseLease(BaseLease lease, K ip){
        lease.setLeaseId(ip.getLeaseId());
        lease.setIpAddress(ip.getIpAddress());
        lease.setClientId(ip.getClientId());
        lease.setHostname(ip.getHostname());
        if (ip.getDate() != null) {
            lease.setDate(new Date(ip.getDate().getTime()));
        }

        lease.setMacRelay(ip.getMacRelay());
        lease.setDocsisSupport(ip.getDocsisSupport());
        lease.setCmtsId(String.valueOf(ip.getCmtsId()));
        if (ip.getRebootDate() != null) {
            lease.setRebootDate(new Date(ip.getRebootDate().getTime()));
        }
        lease.setRequestType(ip.getRequestType());
        lease.setDspId(ip.getDspId());
    }

    /**
     * Builds a lease object
     *
     * @param k IPRaw message
     * @return BaseLease object
     */
    public abstract BaseLease build(K k);
}