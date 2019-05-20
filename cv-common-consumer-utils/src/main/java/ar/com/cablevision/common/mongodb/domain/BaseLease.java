package ar.com.cablevision.common.mongodb.domain;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public abstract class BaseLease implements BaseEntity {

    protected final static String MACRELAY_PREFIX = "01:06:";

    @Field
    protected Long leaseId;

    @Field
    @Indexed
    protected String ipAddress;

    @Field
    protected String hostname;

    @Field
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    protected Date date;

    @Field
    @Indexed
    protected String macRelay;

    @Field
    protected String docsisSupport;

    @Field
    protected Long clientId;

    @Field
    protected String cmtsId;

    @Field
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    protected Date rebootDate;

    @Field
    protected Integer requestType;

    @Field
    protected Long dspId;

    public BaseLease() {
    }

    public BaseLease(String ipAddress,
                     String hostname,
                     Date fecha,
                     String macRelay,
                     Long idLease,
                     String docsisSupport,
                     Long idCliente,
                     String idcmts,
                     Date fechaReboot,
                     Integer tipoPedido,
                     Long iddsp) {
        this.ipAddress = ipAddress;
        this.hostname = hostname;
        this.date = fecha;
        this.macRelay = macRelay;
        this.leaseId = idLease;
        this.docsisSupport = docsisSupport;
        this.clientId = idCliente;
        this.cmtsId = idcmts;
        this.rebootDate = fechaReboot;
        this.requestType = tipoPedido;
        this.dspId = iddsp;
    }

    public String getMacAddressOpen(String macAddress){
        return MACRELAY_PREFIX + macAddress;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMacRelay() {
        return macRelay;
    }

    public void setMacRelay(String macRelay) {
        this.macRelay = macRelay;
    }

    public Long getLeaseId() {
        return leaseId;
    }

    public void setLeaseId(Long leaseId) {
        this.leaseId = leaseId;
    }

    public String getDocsisSupport() {
        return docsisSupport;
    }

    public void setDocsisSupport(String docsisSupport) {
        this.docsisSupport = docsisSupport;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getCmtsId() {
        return cmtsId;
    }

    public void setCmtsId(String cmtsId) {
        this.cmtsId = cmtsId;
    }

    public Date getRebootDate() {
        return rebootDate;
    }

    public void setRebootDate(Date rebootDate) {
        this.rebootDate = rebootDate;
    }

    public Integer getRequestType() {
        return requestType;
    }

    public void setRequestType(Integer requestType) {
        this.requestType = requestType;
    }

    public Long getDspId() {
        return dspId;
    }

    public void setDspId(Long dspId) {
        this.dspId = dspId;
    }

    @Override
    public String toString() {
        return "BaseLease{" +
                "ipAddress='" + ipAddress + '\'' +
                ", hostname='" + hostname + '\'' +
                ", date=" + date +
                ", macRelay='" + macRelay + '\'' +
                ", leaseId=" + leaseId +
                ", docsisSupport='" + docsisSupport + '\'' +
                ", clientId=" + clientId +
                ", cmtsId='" + cmtsId + '\'' +
                ", rebootDate=" + rebootDate +
                ", orderType=" + requestType +
                ", dspId=" + dspId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseLease lease = (BaseLease) o;

        if (ipAddress != null ? !ipAddress.equals(lease.ipAddress) : lease.ipAddress != null) return false;
        if (hostname != null ? !hostname.equals(lease.hostname) : lease.hostname != null) return false;
        if (date != null ? !date.equals(lease.date) : lease.date != null) return false;
        if (macRelay != null ? !macRelay.equals(lease.macRelay) : lease.macRelay != null) return false;
        if (leaseId != null ? !leaseId.equals(lease.leaseId) : lease.leaseId != null) return false;
        if (docsisSupport != null ? !docsisSupport.equals(lease.docsisSupport) : lease.docsisSupport != null)
            return false;
        if (clientId != null ? !clientId.equals(lease.clientId) : lease.clientId != null) return false;
        if (cmtsId != null ? !cmtsId.equals(lease.cmtsId) : lease.cmtsId != null) return false;
        if (rebootDate != null ? !rebootDate.equals(lease.rebootDate) : lease.rebootDate != null) return false;
        if (requestType != null ? !requestType.equals(lease.requestType) : lease.requestType != null) return false;
        return dspId != null ? dspId.equals(lease.dspId) : lease.dspId == null;

    }

    @Override
    public int hashCode() {
        int result = ipAddress != null ? ipAddress.hashCode() : 0;
        result = 31 * result + (hostname != null ? hostname.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (macRelay != null ? macRelay.hashCode() : 0);
        result = 31 * result + (leaseId != null ? leaseId.hashCode() : 0);
        result = 31 * result + (docsisSupport != null ? docsisSupport.hashCode() : 0);
        result = 31 * result + (clientId != null ? clientId.hashCode() : 0);
        result = 31 * result + (cmtsId != null ? cmtsId.hashCode() : 0);
        result = 31 * result + (rebootDate != null ? rebootDate.hashCode() : 0);
        result = 31 * result + (requestType != null ? requestType.hashCode() : 0);
        result = 31 * result + (dspId != null ? dspId.hashCode() : 0);
        return result;
    }

}
