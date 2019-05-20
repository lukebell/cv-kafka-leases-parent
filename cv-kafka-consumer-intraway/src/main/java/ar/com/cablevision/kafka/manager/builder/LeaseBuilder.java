package ar.com.cablevision.kafka.manager.builder;


import ar.com.cablevision.common.kafka.messages.raw.IPRaw;
import ar.com.cablevision.common.kafka.messages.enriched.Lease;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class LeaseBuilder<K extends IPRaw> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LeaseBuilder.class);

    protected void setBaseLease(Lease lease, K ip){
        lease.setLeaseId(ip.getIdLease());
        lease.setIpAddress(ip.getIpAddress());
        lease.setMacAddress(ip.getMacAddress());
        lease.setHostname(ip.getHostname());
        lease.setDate(ip.getFecha());
        lease.setMacRelay(ip.getMacRelay());
        lease.setDocsisSupport(ip.getDocsisSupport());
        lease.setCmtsId(String.valueOf(ip.getIdCMTS()));
        lease.setRebootDate(ip.getFechaReboot());
        lease.setRequestType(ip.getTipoPedido());
        lease.setDspId(ip.getIdDSP());
    }

    /**
     * Builds a lease object
     *
     * @param k IPRaw message
     * @return BaseLease object
     */
    public abstract Lease build(K k);
}