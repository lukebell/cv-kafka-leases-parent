package ar.com.cablevision.common.kafka.messages.enriched;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class IPv6 extends Lease {

    private static final long serialVersionUID = 8799656478674716639L;

    private String duId;
    private String iaId;
    private Integer iaType;
    private String prefixLength;

    public IPv6(){
    }

    public IPv6(@JsonProperty("ipAddress") String ipAddress,
                @JsonProperty("macAddress") String macAddress,
                @JsonProperty("hostname") String hostname,
                @JsonProperty("date") Date date,
                @JsonProperty("macRelay") String macRelay,
                @JsonProperty("leaseId") Long leaseId,
                @JsonProperty("docsisSupport") String docsisSupport,
                @JsonProperty("clientId") Long clientId,
                @JsonProperty("idcmts") String idcmts,
                @JsonProperty("rebootDate") Date rebootDate,
                @JsonProperty("requestType") Integer requestType,
                @JsonProperty("iddsp") Long iddsp,
                @JsonProperty("duId") String duId,
                @JsonProperty("iaId") String iaId,
                @JsonProperty("iaType") Integer iaType,
                @JsonProperty("prefixLength") String prefixLength) {
        super(ipAddress, macAddress, hostname, date, macRelay, leaseId, docsisSupport, clientId, idcmts, rebootDate, requestType, iddsp);
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
        return "IPv6Raw{" +
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
                ", duId='" + duId + '\'' +
                ", iaId='" + iaId + '\'' +
                ", iaType=" + iaType + '\'' +
                ", prefixLength='" + prefixLength + '\'' +
                ", dspId=" + dspId +
                '}';
    }

}
