package ar.com.cablevision.common.wd2k.domain;

import java.sql.Date;

public class IPv6Lease extends BaseLease {

    private static final long serialVersionUID = 8799656478674716639L;

    private String duId;
    private String iaId;
    private Integer iaType;
    private String prefixLength;

    public IPv6Lease(){
    }

    public IPv6Lease(String ipAddress,
                     String macAddress,
                     String hostname,
                     Date fecha,
                     String macRelay,
                     Long idLease,
                     String docsisSupport,
                     Long idCliente,
                     String idcmts,
                     Date fechaReboot,
                     Integer tipoPedido,
                     Long iddsp,
                     String duId,
                     String iaId,
                     Integer iaType,
                     String prefixLength) {
        super(ipAddress, macAddress, hostname, fecha, macRelay, idLease, docsisSupport, idCliente, idcmts, fechaReboot, tipoPedido, iddsp);
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
                ", macAddress='" + macAddress + '\'' +
                ", hostname='" + hostname + '\'' +
                ", date=" + fecha +
                ", macRelay='" + macRelay + '\'' +
                ", leaseId=" + idLease +
                ", docsisSupport='" + docsisSupport + '\'' +
                ", clientId=" + idCliente +
                ", cmtsId='" + idCmts + '\'' +
                ", rebootDate=" + fechaReboot +
                ", orderType=" + tipoPedido +
                ", duId='" + duId + '\'' +
                ", iaId='" + iaId + '\'' +
                ", iaType=" + iaType + '\'' +
                ", prefixLength='" + prefixLength + '\'' +
                ", dspId=" + idDsp +
                '}';
    }

}
