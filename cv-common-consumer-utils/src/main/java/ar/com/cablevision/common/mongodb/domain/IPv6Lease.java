package ar.com.cablevision.common.mongodb.domain;

import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

public class IPv6Lease extends BaseLease {

    private static final long serialVersionUID = 8799656478674716639L;

    @Field
    private String duId;

    @Field
    private String iaId;

    @Field
    private Integer iaType;

    @Field
    private String prefixLength;

    public IPv6Lease(){
    }

    public IPv6Lease(String ipAddress,
                     String hostname,
                     Date date,
                     String macRelay,
                     Long leaseId,
                     String docsisSupport,
                     Long clientId,
                     String cmtsId,
                     Date rebootDate,
                     Integer requestType,
                     Long dspId,
                     String duId,
                     String iaId,
                     Integer iaType,
                     String prefixLength) {
        super(ipAddress, hostname, date, macRelay, leaseId, docsisSupport, clientId, cmtsId, rebootDate, requestType, dspId);
        this.duId = duId;
        this.iaId = iaId;
        this.iaType = iaType;
        this.prefixLength = prefixLength;
    }

    public String getDuId() {
        return duId;
    }

    public void setDuId(String duId) {
        this.duId = duId;
    }

    public String getIaId() {
        return iaId;
    }

    public void setIaId(String iaId) {
        this.iaId = iaId;
    }

    public Integer getIaType() {
        return iaType;
    }

    public void setIaType(Integer iaType) {
        this.iaType = iaType;
    }

    public String getPrefixLength() {
        return prefixLength;
    }

    public void setPrefixLength(String prefixLength) {
        this.prefixLength = prefixLength;
    }

    @Override
    public String toString() {
        return "IPv6{" +
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
                ", duId='" + duId + '\'' +
                ", iaId='" + iaId + '\'' +
                ", iaType=" + iaType + '\'' +
                ", prefixLength='" + prefixLength + '\'' +
                ", dspId=" + dspId +
                '}';
    }

}
