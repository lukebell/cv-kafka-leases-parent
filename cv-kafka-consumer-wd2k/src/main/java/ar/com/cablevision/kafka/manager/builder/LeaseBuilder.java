package ar.com.cablevision.kafka.manager.builder;

import ar.com.cablevision.common.kafka.messages.enriched.Lease;
import ar.com.cablevision.common.wd2k.domain.BaseLease;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;

public abstract class LeaseBuilder<K extends Lease> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LeaseBuilder.class);

    protected void setBaseLease(BaseLease lease, K ip){
        lease.setIdLease(ip.getLeaseId());
        lease.setIpAddress(ip.getIpAddress());
        lease.setMacAddress(ip.getMacAddress());
        lease.setIdCliente(ip.getClientId());
        lease.setHostname(ip.getHostname());
        if (ip.getDate() != null) {
            lease.setFecha(new Date(ip.getDate().getTime()));
        }

        lease.setMacRelay(ip.getMacRelay());
        // Truncate value because table column size
        lease.setDocsisSupport(ip.getDocsisSupport() != null && ip.getDocsisSupport().length() > 5
                ? ip.getDocsisSupport().substring(0, 5) : ip.getDocsisSupport());
        lease.setIdCmts(String.valueOf(ip.getCmtsId()));
        if (ip.getRebootDate() != null) {
            lease.setFechaReboot(new Date(ip.getRebootDate().getTime()));
        }
        lease.setTipoPedido(ip.getRequestType());
        lease.setIdDsp(ip.getDspId());
    }

    /**
     * Builds a lease object
     *
     * @param k IPRaw message
     * @return BaseLease object
     */
    public abstract BaseLease build(K k);
}