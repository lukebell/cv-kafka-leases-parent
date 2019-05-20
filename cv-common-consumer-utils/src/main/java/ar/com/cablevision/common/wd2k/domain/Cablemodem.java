package ar.com.cablevision.common.wd2k.domain;

import java.sql.Date;

public class Cablemodem implements BaseEntity {

    private static final long serialVersionUID = 1L;

    protected Long idCablemodem;
    protected Long idEmpresa;
    protected Long idCliente;
    protected Long idProducto;
    protected Long idServicio;
    protected Long idServicioPadre;
    protected Long idProductoPadre;
    protected Long idVenta;
    protected Long idPromotor;
    protected String macAddress;
    protected Long ipFija;
    protected String ip;
    protected String policy;
    protected Integer cantPcs;
    protected String hub;
    protected Integer nodo;
    protected Long idCmts;
    protected Integer downstream;
    protected Integer upstream;
    protected String macPc;
    protected Date fechaAlta;
    protected Date fechaActivacion;
    protected String tagProveedor;
    protected Date vencimiento;
    protected Integer disabled;
    protected String calidad;
    protected Long idFabricante;
    protected Long idVersion;
    protected Date fechaModif;
    protected String ipcm;
    protected Date fechaBloqueoVelocidad;
    protected Long idMensaje;
    protected Date fechaVencimiento;
    protected Long idCalleas;
    protected Long numero;
    protected Integer nroManzana;
    protected String zona;
    protected Long idVentaPadre;
    protected Long idProducto2;
    protected Long idProductoPadre2;
    protected Integer passwordCheck;
    protected Integer cantExtPrivadas;
    protected Long idTipoCm;
    protected Long idCuenta;
    protected Integer red;
    protected String mgt;
    protected String nodo4;
    protected Long idCompania;
    protected Integer cantLineas;
    protected String modo;
    protected Integer smPackageId;
    protected String net;
    protected Integer motivoDesactivacion;
    protected String vlan;
    protected Long idTipoIp;
    protected String secondSsid;

    public Cablemodem(){}

    public Cablemodem(Long idCablemodem, Long idEmpresa, Long idCliente, Long idProducto, Long idServicio, Long idServicioPadre, Long idProductoPadre, Long idVenta, Long idPromotor, String macAddress, Long ipFija, String ip, String policy, Integer cantPcs, String hub, Integer nodo, Long idCmts, Integer downstream, Integer upstream, String macPc, Date fechaAlta, Date fechaActivacion, String tagProveedor, Date vencimiento, Integer disabled, String calidad, Long idFabricante, Long idVersion, Date fechaModif, String ipcm, Date fechaBloqueoVelocidad, Long idMensaje, Date fechaVencimiento, Long idCalleas, Long numero, Integer nroManzana, String zona, Long idVentaPadre, Long idProducto2, Long idProductoPadre2, Integer passwordCheck, Integer cantExtPrivadas, Long idTipocm, Long idCuenta, Integer red, String mgt, String nodo4, Long idCompania, Integer cantLineas, String modo1, Integer smPackageId, String net, Integer motivoDesactivacion, String vlan, Long idTipoIp, String secondSsid) {
        this.idCablemodem = idCablemodem;
        this.idEmpresa = idEmpresa;
        this.idCliente = idCliente;
        this.idProducto = idProducto;
        this.idServicio = idServicio;
        this.idServicioPadre = idServicioPadre;
        this.idProductoPadre = idProductoPadre;
        this.idVenta = idVenta;
        this.idPromotor = idPromotor;
        this.macAddress = macAddress;
        this.ipFija = ipFija;
        this.ip = ip;
        this.policy = policy;
        this.cantPcs = cantPcs;
        this.hub = hub;
        this.nodo = nodo;
        this.idCmts = idCmts;
        this.downstream = downstream;
        this.upstream = upstream;
        this.macPc = macPc;
        this.fechaAlta = fechaAlta;
        this.fechaActivacion = fechaActivacion;
        this.tagProveedor = tagProveedor;
        this.vencimiento = vencimiento;
        this.disabled = disabled;
        this.calidad = calidad;
        this.idFabricante = idFabricante;
        this.idVersion = idVersion;
        this.fechaModif = fechaModif;
        this.ipcm = ipcm;
        this.fechaBloqueoVelocidad = fechaBloqueoVelocidad;
        this.idMensaje = idMensaje;
        this.fechaVencimiento = fechaVencimiento;
        this.idCalleas = idCalleas;
        this.numero = numero;
        this.nroManzana = nroManzana;
        this.zona = zona;
        this.idVentaPadre = idVentaPadre;
        this.idProducto2 = idProducto2;
        this.idProductoPadre2 = idProductoPadre2;
        this.passwordCheck = passwordCheck;
        this.cantExtPrivadas = cantExtPrivadas;
        this.idTipoCm = idTipocm;
        this.idCuenta = idCuenta;
        this.red = red;
        this.mgt = mgt;
        this.nodo4 = nodo4;
        this.idCompania = idCompania;
        this.cantLineas = cantLineas;
        this.modo = modo1;
        this.smPackageId = smPackageId;
        this.net = net;
        this.motivoDesactivacion = motivoDesactivacion;
        this.vlan = vlan;
        this.idTipoIp = idTipoIp;
        this.secondSsid = secondSsid;
    }

    public Long getIdCablemodem() {
        return idCablemodem;
    }

    public void setIdCablemodem(Long idCablemodem) {
        this.idCablemodem = idCablemodem;
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public Long getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Long idServicio) {
        this.idServicio = idServicio;
    }

    public Long getIdServicioPadre() {
        return idServicioPadre;
    }

    public void setIdServicioPadre(Long idServicioPadre) {
        this.idServicioPadre = idServicioPadre;
    }

    public Long getIdProductoPadre() {
        return idProductoPadre;
    }

    public void setIdProductoPadre(Long idProductoPadre) {
        this.idProductoPadre = idProductoPadre;
    }

    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public Long getIdPromotor() {
        return idPromotor;
    }

    public void setIdPromotor(Long idPromotor) {
        this.idPromotor = idPromotor;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public Long getIpFija() {
        return ipFija;
    }

    public void setIpFija(Long ipFija) {
        this.ipFija = ipFija;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public Integer getCantPcs() {
        return cantPcs;
    }

    public void setCantPcs(Integer cantPcs) {
        this.cantPcs = cantPcs;
    }

    public String getHub() {
        return hub;
    }

    public void setHub(String hub) {
        this.hub = hub;
    }

    public Integer getNodo() {
        return nodo;
    }

    public void setNodo(Integer nodo) {
        this.nodo = nodo;
    }

    public Integer getSmPackageId() {
        return smPackageId;
    }

    public void setSmPackageId(Integer smPackageId) {
        this.smPackageId = smPackageId;
    }

    public String getNet() {
        return net;
    }

    public void setNet(String net) {
        this.net = net;
    }

    public Integer getMotivoDesactivacion() {
        return motivoDesactivacion;
    }

    public void setMotivoDesactivacion(Integer motivoDesactivacion) {
        this.motivoDesactivacion = motivoDesactivacion;
    }

    public String getVlan() {
        return vlan;
    }

    public void setVlan(String vlan) {
        this.vlan = vlan;
    }

    public Long getIdTipoIp() {
        return idTipoIp;
    }

    public void setIdTipoIp(Long idTipoIp) {
        this.idTipoIp = idTipoIp;
    }

    public String getSecondSsid() {
        return secondSsid;
    }

    public void setSecondSsid(String secondSsid) {
        this.secondSsid = secondSsid;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public Long getIdCmts() {
        return idCmts;
    }

    public void setIdCmts(Long idCmts) {
        this.idCmts = idCmts;
    }

    public Integer getDownstream() {
        return downstream;
    }

    public void setDownstream(Integer downstream) {
        this.downstream = downstream;
    }

    public Integer getUpstream() {
        return upstream;
    }

    public void setUpstream(Integer upstream) {
        this.upstream = upstream;
    }

    public String getMacPc() {
        return macPc;
    }

    public void setMacPc(String macPc) {
        this.macPc = macPc;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaActivacion() {
        return fechaActivacion;
    }

    public void setFechaActivacion(Date fechaActivacion) {
        this.fechaActivacion = fechaActivacion;
    }

    public String getTagProveedor() {
        return tagProveedor;
    }

    public void setTagProveedor(String tagProveedor) {
        this.tagProveedor = tagProveedor;
    }

    public Date getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(Date vencimiento) {
        this.vencimiento = vencimiento;
    }

    public Integer getDisabled() {
        return disabled;
    }

    public void setDisabled(Integer disabled) {
        this.disabled = disabled;
    }

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    public Long getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(Long idFabricante) {
        this.idFabricante = idFabricante;
    }

    public Long getIdVersion() {
        return idVersion;
    }

    public void setIdVersion(Long idVersion) {
        this.idVersion = idVersion;
    }

    public Date getFechaModif() {
        return fechaModif;
    }

    public void setFechaModif(Date fechaModif) {
        this.fechaModif = fechaModif;
    }

    public String getIpcm() {
        return ipcm;
    }

    public void setIpcm(String ipcm) {
        this.ipcm = ipcm;
    }

    public Date getFechaBloqueoVelocidad() {
        return fechaBloqueoVelocidad;
    }

    public void setFechaBloqueoVelocidad(Date fechaBloqueoVelocidad) {
        this.fechaBloqueoVelocidad = fechaBloqueoVelocidad;
    }

    public Long getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(Long idMensaje) {
        this.idMensaje = idMensaje;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Long getIdCalleas() {
        return idCalleas;
    }

    public void setIdCalleas(Long idCalleas) {
        this.idCalleas = idCalleas;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Integer getNroManzana() {
        return nroManzana;
    }

    public void setNroManzana(Integer nroManzana) {
        this.nroManzana = nroManzana;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public Long getIdVentaPadre() {
        return idVentaPadre;
    }

    public void setIdVentaPadre(Long idVentaPadre) {
        this.idVentaPadre = idVentaPadre;
    }

    public Long getIdProducto2() {
        return idProducto2;
    }

    public void setIdProducto2(Long idProducto2) {
        this.idProducto2 = idProducto2;
    }

    public Long getIdProductoPadre2() {
        return idProductoPadre2;
    }

    public void setIdProductoPadre2(Long idProductoPadre2) {
        this.idProductoPadre2 = idProductoPadre2;
    }

    public Integer getPasswordCheck() {
        return passwordCheck;
    }

    public void setPasswordCheck(Integer passwordCheck) {
        this.passwordCheck = passwordCheck;
    }

    public Integer getCantExtPrivadas() {
        return cantExtPrivadas;
    }

    public void setCantExtPrivadas(Integer cantExtPrivadas) {
        this.cantExtPrivadas = cantExtPrivadas;
    }

    public Long getIdTipoCm() {
        return idTipoCm;
    }

    public void setIdTipoCm(Long idTipoCm) {
        this.idTipoCm = idTipoCm;
    }

    public Long getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Long idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Integer getRed() {
        return red;
    }

    public void setRed(Integer red) {
        this.red = red;
    }

    public String getMgt() {
        return mgt;
    }

    public void setMgt(String mgt) {
        this.mgt = mgt;
    }

    public String getNodo4() {
        return nodo4;
    }

    public void setNodo4(String nodo4) {
        this.nodo4 = nodo4;
    }

    public Long getIdCompania() {
        return idCompania;
    }

    public void setIdCompania(Long idCompania) {
        this.idCompania = idCompania;
    }

    public Integer getCantLineas() {
        return cantLineas;
    }

    public void setCantLineas(Integer cantLineas) {
        this.cantLineas = cantLineas;
    }

    @Override
    public String toString() {
        return "Cablemodem{" +
                "idCablemodem=" + idCablemodem +
                ", idEmpresa=" + idEmpresa +
                ", clientId=" + idCliente +
                ", idProducto=" + idProducto +
                ", idServicio=" + idServicio +
                ", idServicioPadre=" + idServicioPadre +
                ", idProductoPadre=" + idProductoPadre +
                ", idVenta=" + idVenta +
                ", idPromotor=" + idPromotor +
                ", macAddress='" + macAddress + '\'' +
                ", ipFija=" + ipFija +
                ", ip='" + ip + '\'' +
                ", policy='" + policy + '\'' +
                ", cantPcs=" + cantPcs +
                ", hub='" + hub + '\'' +
                ", nodo=" + nodo +
                ", cmtsId=" + idCmts +
                ", downstream=" + downstream +
                ", upstream=" + upstream +
                ", macPc='" + macPc + '\'' +
                ", fechaAlta=" + fechaAlta +
                ", fechaActivacion=" + fechaActivacion +
                ", tagProveedor='" + tagProveedor + '\'' +
                ", vencimiento=" + vencimiento +
                ", disabled=" + disabled +
                ", calidad='" + calidad + '\'' +
                ", idFabricante=" + idFabricante +
                ", idVersion=" + idVersion +
                ", fechaModif=" + fechaModif +
                ", ipcm='" + ipcm + '\'' +
                ", fechaBloqueoVelocidad=" + fechaBloqueoVelocidad +
                ", idMensaje=" + idMensaje +
                ", fechaVencimiento=" + fechaVencimiento +
                ", idCalleas=" + idCalleas +
                ", numero=" + numero +
                ", nroManzana=" + nroManzana +
                ", zona='" + zona + '\'' +
                ", idVentaPadre=" + idVentaPadre +
                ", idProducto2=" + idProducto2 +
                ", idProductoPadre2=" + idProductoPadre2 +
                ", passwordCheck=" + passwordCheck +
                ", cantExtPrivadas=" + cantExtPrivadas +
                ", idTipoCm=" + idTipoCm +
                ", idCuenta=" + idCuenta +
                ", red=" + red +
                ", mgt='" + mgt + '\'' +
                ", nodo4='" + nodo4 + '\'' +
                ", idCompania=" + idCompania +
                ", cantLineas=" + cantLineas +
                ", modo='" + modo + '\'' +
                ", smPackageId=" + smPackageId +
                ", net='" + net + '\'' +
                ", motivoDesactivacion=" + motivoDesactivacion +
                ", vlan='" + vlan + '\'' +
                ", idTipoIp=" + idTipoIp +
                ", secondSsid='" + secondSsid + '\'' +
                '}';
    }
}
