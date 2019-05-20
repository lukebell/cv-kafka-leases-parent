package ar.com.cablevision.common.wd2k.domain;

import java.sql.Date;

public abstract class BaseLease implements BaseEntity {

    protected final static String MACRELAY_PREFIX = "01:06:";

    protected String ipAddress;
    protected String macAddress;
    protected String hostname;
    protected Date fecha;
    protected String macRelay;
    protected Long idLease;
    protected String docsisSupport;
    protected Long idCliente;
    protected String idCmts;
    protected Date fechaReboot;
    protected Integer tipoPedido;
    protected Long idDsp;

    public BaseLease() {
    }

    public BaseLease(String ipAddress,
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
                     Long iddsp) {
        this.ipAddress = ipAddress;
        this.macAddress = macAddress;
        this.hostname = hostname;
        this.fecha = fecha;
        this.macRelay = macRelay;
        this.idLease = idLease;
        this.docsisSupport = docsisSupport;
        this.idCliente = idCliente;
        this.idCmts = idcmts;
        this.fechaReboot = fechaReboot;
        this.tipoPedido = tipoPedido;
        this.idDsp = iddsp;
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

    public String getIdCmts() {
        return idCmts;
    }

    public void setIdCmts(String idCmts) {
        this.idCmts = idCmts;
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

    public Long getIdDsp() {
        return idDsp;
    }

    public void setIdDsp(Long idDsp) {
        this.idDsp = idDsp;
    }

    @Override
    public String toString() {
        return "BaseLease{" +
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
                ", dspId=" + idDsp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseLease lease = (BaseLease) o;

        if (ipAddress != null ? !ipAddress.equals(lease.ipAddress) : lease.ipAddress != null) return false;
        if (macAddress != null ? !macAddress.equals(lease.macAddress) : lease.macAddress != null) return false;
        if (hostname != null ? !hostname.equals(lease.hostname) : lease.hostname != null) return false;
        if (fecha != null ? !fecha.equals(lease.fecha) : lease.fecha != null) return false;
        if (macRelay != null ? !macRelay.equals(lease.macRelay) : lease.macRelay != null) return false;
        if (idLease != null ? !idLease.equals(lease.idLease) : lease.idLease != null) return false;
        if (docsisSupport != null ? !docsisSupport.equals(lease.docsisSupport) : lease.docsisSupport != null)
            return false;
        if (idCliente != null ? !idCliente.equals(lease.idCliente) : lease.idCliente != null) return false;
        if (idCmts != null ? !idCmts.equals(lease.idCmts) : lease.idCmts != null) return false;
        if (fechaReboot != null ? !fechaReboot.equals(lease.fechaReboot) : lease.fechaReboot != null) return false;
        if (tipoPedido != null ? !tipoPedido.equals(lease.tipoPedido) : lease.tipoPedido != null) return false;
        return idDsp != null ? idDsp.equals(lease.idDsp) : lease.idDsp == null;

    }

    @Override
    public int hashCode() {
        int result = ipAddress != null ? ipAddress.hashCode() : 0;
        result = 31 * result + (macAddress != null ? macAddress.hashCode() : 0);
        result = 31 * result + (hostname != null ? hostname.hashCode() : 0);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (macRelay != null ? macRelay.hashCode() : 0);
        result = 31 * result + (idLease != null ? idLease.hashCode() : 0);
        result = 31 * result + (docsisSupport != null ? docsisSupport.hashCode() : 0);
        result = 31 * result + (idCliente != null ? idCliente.hashCode() : 0);
        result = 31 * result + (idCmts != null ? idCmts.hashCode() : 0);
        result = 31 * result + (fechaReboot != null ? fechaReboot.hashCode() : 0);
        result = 31 * result + (tipoPedido != null ? tipoPedido.hashCode() : 0);
        result = 31 * result + (idDsp != null ? idDsp.hashCode() : 0);
        return result;
    }

}
