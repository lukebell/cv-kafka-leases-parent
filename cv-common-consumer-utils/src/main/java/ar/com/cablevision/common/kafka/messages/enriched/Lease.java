package ar.com.cablevision.common.kafka.messages.enriched;

import ar.com.cablevision.common.wd2k.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;


public abstract class Lease implements BaseEntity {

    protected final static String MACRELAY_PREFIX = "01:06:";

    protected String ipAddress;
    protected String macAddress;
    protected String hostname;
    protected Date date;
    protected String macRelay;
    protected Long leaseId;
    protected String docsisSupport;
    protected Long clientId;
    protected String cmtsId;
    protected Date rebootDate;
    protected Integer requestType;
    protected Long dspId;

    public Lease() {
    }

    public Lease(@JsonProperty("ipAddress") String ipAddress,
                 @JsonProperty("macAddress") String macAddress,
                 @JsonProperty("hostname") String hostname,
                 @JsonProperty("date") Date date,
                 @JsonProperty("macRelay") String macRelay,
                 @JsonProperty("leaseId") Long idLease,
                 @JsonProperty("docsisSupport") String docsisSupport,
                 @JsonProperty("clientId") Long clientId,
                 @JsonProperty("cmtsId") String cmtsId,
                 @JsonProperty("rebootDate") Date rebootDate,
                 @JsonProperty("requestType") Integer requestType,
                 @JsonProperty("dspId") Long dspId) {
        this.ipAddress = ipAddress;
        this.macAddress = macAddress;
        this.hostname = hostname;
        this.date = date;
        this.macRelay = macRelay;
        this.leaseId = idLease;
        this.docsisSupport = docsisSupport;
        this.clientId = clientId;
        this.cmtsId = cmtsId;
        this.rebootDate = rebootDate;
        this.requestType = requestType;
        this.dspId = dspId;
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

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
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

    public void setRequestType(Integer orderType) {
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
                ", macAddress='" + macAddress + '\'' +
                ", hostname='" + hostname + '\'' +
                ", date=" + date +
                ", macRelay='" + macRelay + '\'' +
                ", leaseId=" + leaseId +
                ", docsisSupport='" + docsisSupport + '\'' +
                ", clientId=" + clientId +
                ", cmtsId='" + cmtsId + '\'' +
                ", rebootDate=" + rebootDate +
                ", requestType=" + requestType +
                ", dspId=" + dspId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lease lease = (Lease) o;

        if (ipAddress != null ? !ipAddress.equals(lease.ipAddress) : lease.ipAddress != null) return false;
        if (macAddress != null ? !macAddress.equals(lease.macAddress) : lease.macAddress != null) return false;
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
        result = 31 * result + (macAddress != null ? macAddress.hashCode() : 0);
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
