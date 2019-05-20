package ar.com.cablevision.common.wd2k.utils.mapper;

import ar.com.cablevision.common.wd2k.domain.Cablemodem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static ar.com.cablevision.common.wd2k.constant.CableModemConstants.*;
import static ar.com.cablevision.common.wd2k.constant.CableModemConstants.IDCLIENTE_COLUMN;

/**
 * Cablemodem RowMapper implementation
 */
public class CableModemRowMapper implements RowMapper<Cablemodem> {

    @Override
    public Cablemodem mapRow(ResultSet rs, int rowNum) throws SQLException {
        Cablemodem cablemodem = new Cablemodem();

        cablemodem.setIdCablemodem(rs.getLong(IDCABLEMODEM_COLUMN.getValue()));
        cablemodem.setIdEmpresa(rs.getLong(IDEMPRESA_COLUMN.getValue()));
        cablemodem.setIdCliente(rs.getLong(IDCLIENTE_COLUMN.getValue()));
        cablemodem.setIdProducto(rs.getLong(IDPRODUCTO_COLUMN.getValue()));
        cablemodem.setIdServicio(rs.getLong(IDSERVICIO_COLUMN.getValue()));
        cablemodem.setIdServicioPadre(rs.getLong(IDSERVICIOPADRE_COLUMN.getValue()));
        cablemodem.setIdProductoPadre(rs.getLong(IDPRODUCTOPADRE_COLUMN.getValue()));
        cablemodem.setIdCliente(rs.getLong(IDCLIENTE_COLUMN.getValue()));
        cablemodem.setIdVenta(rs.getLong(IDVENTA_COLUMN.getValue()));
        cablemodem.setIdPromotor(rs.getLong(IDPROMOTOR_COLUMN.getValue()));
        cablemodem.setMacAddress(rs.getString(MACADDRESS_COLUMN.getValue()));
        cablemodem.setIpFija(rs.getLong(IPFIJA_COLUMN.getValue()));
        cablemodem.setIp(rs.getString(IP_COLUMN.getValue()));
        cablemodem.setPolicy(rs.getString(POLICY_COLUMN.getValue()));
        cablemodem.setCantPcs(rs.getInt(CANTPCS_COLUMN.getValue()));
        cablemodem.setHub(rs.getString(HUB_COLUMN.getValue()));
        cablemodem.setNodo(rs.getInt(NODO_COLUMN.getValue()));
        cablemodem.setIdCmts(rs.getLong(IDCMTS_COLUMN.getValue()));
        cablemodem.setUpstream(rs.getInt(UPSTREAM_COLUMN.getValue()));
        cablemodem.setDownstream(rs.getInt(DOWNSTREAM_COLUMN.getValue()));
        cablemodem.setMacPc(rs.getString(MACPC_COLUMN.getValue()));
        cablemodem.setFechaAlta(rs.getDate(FECHAALTA_COLUMN.getValue()));
        cablemodem.setFechaActivacion(rs.getDate(FECHAACTIVACION_COLUMN.getValue()));
        cablemodem.setTagProveedor(rs.getString(TAGPROVEEDOR_COLUMN.getValue()));
        cablemodem.setDisabled(rs.getInt(DISABLED_COLUMN.getValue()));
        cablemodem.setVencimiento(rs.getDate(VENCIMIENTO_COLUMN.getValue()));
        cablemodem.setCalidad(rs.getString(CALIDAD_COLUMN.getValue()));
        cablemodem.setIdFabricante(rs.getLong(IDFABRICANTE_COLUMN.getValue()));
        cablemodem.setIdVersion(rs.getLong(IDVERSION_COLUMN.getValue()));
        cablemodem.setFechaModif(rs.getDate(FECHAMODIF_COLUMN.getValue()));
        cablemodem.setIpcm(rs.getString(IPCM_COLUMN.getValue()));
        cablemodem.setFechaBloqueoVelocidad(rs.getDate(FECHABLOQUEOVELOCIDAD_COLUMN.getValue()));
        cablemodem.setIdMensaje(rs.getLong(IDMENSAJE_COLUMN.getValue()));
        cablemodem.setFechaVencimiento(rs.getDate(FECHAVENCIMIENTO_COLUMN.getValue()));
        cablemodem.setIdCalleas(rs.getLong(IDCALLEAS_COLUMN.getValue()));
        cablemodem.setNumero(rs.getLong(NUMERO_COLUMN.getValue()));
        cablemodem.setNroManzana(rs.getInt(NROMANZANA_COLUMN.getValue()));
        cablemodem.setZona(rs.getString(ZONA_COLUMN.getValue()));
        cablemodem.setIdVentaPadre(rs.getLong(IDPRODUCTOPADRE_COLUMN.getValue()));
        cablemodem.setIdProducto2(rs.getLong(IDPRODUCTO2_COLUMN.getValue()));
        cablemodem.setIdProductoPadre2(rs.getLong(IDPRODUCTOPADRE2_COLUMN.getValue()));
        cablemodem.setPasswordCheck(rs.getInt(PASSWORDCHECK_COLUMN.getValue()));
        cablemodem.setCantExtPrivadas(rs.getInt(CANTEXTPRIVADAS_COLUMN.getValue()));
        cablemodem.setIdTipoCm(rs.getLong(IDTIPOCM_COLUMN.getValue()));
        cablemodem.setIdCuenta(rs.getLong(IDCUENTA_COLUMN.getValue()));
        cablemodem.setRed(rs.getInt(RED_COLUMN.getValue()));
        cablemodem.setMgt(rs.getString(MGT_COLUMN.getValue()));
        cablemodem.setNodo4(rs.getString(NODO_4_COLUMN.getValue()));
        cablemodem.setIdCompania(rs.getLong(IDCOMPANIA_COLUMN.getValue()));
        cablemodem.setCantLineas(rs.getInt(CANTLINEAS_COLUMN.getValue()));
        cablemodem.setModo(rs.getString(MODO_COLUMN.getValue()));
        cablemodem.setSmPackageId(rs.getInt(SM_PACKAGEID_COLUMN.getValue()));
        cablemodem.setNet(rs.getString(NET_COLUMN.getValue()));
        cablemodem.setMotivoDesactivacion(rs.getInt(MOTIVODESACTIVACION_COLUMN.getValue()));
        cablemodem.setVlan(rs.getString(VLAN_COLUMN.getValue()));
        cablemodem.setIdTipoIp(rs.getLong(IDTIPOIP_COLUMN.getValue()));
        cablemodem.setSecondSsid(rs.getString(SECONDSSID_COLUMN.getValue()));

        return cablemodem;
    }
}
