package ar.com.cablevision.common.kafka.messages.raw;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

public abstract class IPRaw implements Serializable{

    public static final String DATE_FORMAT_PATTERN = "yyyyy-MM-dd:HH:mm:ss";

    protected String ipAddress;
    protected String macAddress;
    protected String hostname;
    protected Date fecha;
    protected String macRelay;
    protected Long idLease;
    protected String docsisSupport;
    protected Long idCliente;
    protected Long idCMTS;
    protected Date fechaReboot;
    protected Integer tipoPedido;
    protected Long idDSP;
    protected Long idLeaseIW;
    protected String src;

    public IPRaw(){
    }

    @JsonCreator
    public IPRaw(@JsonProperty("IPADDRESS") String ipAddress,
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
                 @JsonProperty("SRC") String src) {
        this.ipAddress = ipAddress;
        this.macAddress = macAddress;
        this.hostname = hostname;
        this.fecha = fecha;
        this.macRelay = macRelay;
        this.idLease = idLease;
        this.docsisSupport = docsisSupport;
        this.idCliente = idCliente;
        this.idCMTS = idCMTS;
        this.fechaReboot = fechaReboot;
        this.tipoPedido = tipoPedido;
        this.idDSP = idDSP;
        this.idLeaseIW = idLeaseIW;
        this.src = src;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMacRelay() {
        return macRelay;
    }

    public void setMacRelay(String macRelay) {
        this.macRelay = macRelay;
    }

    public Long getIdLease() {
        return idLease;
    }

    public void setIdLease(Long idLease) {
        this.idLease = idLease;
    }

    public String getDocsisSupport() {
        return docsisSupport;
    }

    public void setDocsisSupport(String docsisSupport) {
        this.docsisSupport = docsisSupport;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdCMTS() {
        return idCMTS;
    }

    public void setIdCMTS(Long idCMTS) {
        this.idCMTS = idCMTS;
    }

    public Date getFechaReboot() {
        return fechaReboot;
    }

    public void setFechaReboot(Date fechaReboot) {
        this.fechaReboot = fechaReboot;
    }

    public Integer getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(Integer tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public Long getIdDSP() {
        return idDSP;
    }

    public void setIdDSP(Long idDSP) {
        this.idDSP = idDSP;
    }

    public Long getIdLeaseIW() {
        return idLeaseIW;
    }

    public void setIdLeaseIW(Long idLeaseIW) {
        this.idLeaseIW = idLeaseIW;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    @Override
    public String toString() {
        return "IPRaw{" +
                "ipAddress='" + ipAddress + '\'' +
                ", macAddress='" + macAddress + '\'' +
                ", hostname='" + hostname + '\'' +
                ", date=" + fecha +
                ", macRelay='" + macRelay + '\'' +
                ", leaseId=" + idLease +
                ", docsisSupport='" + docsisSupport + '\'' +
                ", clientId=" + idCliente +
                ", idCMTS=" + idCMTS +
                ", rebootDate=" + fechaReboot +
                ", requestType=" + tipoPedido +
                ", idDSP=" + idDSP +
                ", idLeaseIW=" + idLeaseIW +
                ", src='" + src + '\'' +
                '}';
    }
}
