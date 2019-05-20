package ar.com.cablevision.common.kafka.messages.raw;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class IPv6Raw extends IPRaw {

    protected String duId;
    protected String iaId;
    protected Integer iaType;
    protected String prefixLength;

    public IPv6Raw(){
    }

    @JsonCreator
    public IPv6Raw(@JsonProperty("IPADDRESS") String ipAddress,
                   @JsonProperty("MACADDRESS") String macAddress,
                   @JsonProperty("HOSTNAME") String hostname,
                   @JsonProperty("FECHA") @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT_PATTERN, timezone="America/Argentina/Buenos_Aires") Date fecha,
                   @JsonProperty("MACRELAY") String macRelay,
                   @JsonProperty("IDLEASE") Long idLease,
                   @JsonProperty("DOCSIS_SUPPORT") String docsisSupport,
                   @JsonProperty("IDCLIENTE") Long idCliente,
                   @JsonProperty("IDCMTS") Long idCMTS,
                   @JsonProperty("FECHA_REBOOT") @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT_PATTERN, timezone="America/Argentina/Buenos_Aires") Date fechaReboot,
                   @JsonProperty("TIPO_PEDIDO") Integer tipoPedido,
                   @JsonProperty("IDDSP") Long idDSP,
                   @JsonProperty("IDLEASEIW") Long idLeaseIW,
                   @JsonProperty("SRC") String src,
                   @JsonProperty("DUID") String duId,
                   @JsonProperty("IAID") String iaId,
                   @JsonProperty("IATYPE") Integer iaType,
                   @JsonProperty("PREFIX_LENGTH") String prefixLength) {
        super(ipAddress, macAddress, hostname, fecha, macRelay, idLease, docsisSupport, idCliente, idCMTS, fechaReboot, tipoPedido, idDSP, idLeaseIW, src);
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
                ", date='" + fecha + '\'' +
                ", macRelay='" + macRelay + '\'' +
                ", leaseId=" + idLease +
                ", docsisSupport='" + docsisSupport + '\'' +
                ", clientId=" + idCliente +
                ", idCMTS=" + idCMTS +
                ", rebootDate='" + fechaReboot + '\'' +
                ", orderType='" + tipoPedido + '\'' +
                ", idDSP='" + idDSP + '\'' +
                ", idLeaseIW=" + idLeaseIW + '\'' +
                ", src='" + src + '\'' +
                ", duId='" + duId + '\'' +
                ", iaId='" + iaId + '\'' +
                ", iaType=" + iaType + '\'' +
                ", prefixLength='" + prefixLength + '\'' +
                '}';
    }
}
