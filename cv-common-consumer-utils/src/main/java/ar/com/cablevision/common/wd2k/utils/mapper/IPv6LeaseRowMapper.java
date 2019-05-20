package ar.com.cablevision.common.wd2k.utils.mapper;

import ar.com.cablevision.common.wd2k.domain.IPv6Lease;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static ar.com.cablevision.common.wd2k.constant.IPv6LeaseConstants.*;

/**
 * IPv6 BaseLease RowMapper implementation
 */
public class IPv6LeaseRowMapper implements RowMapper<IPv6Lease> {
    @Override
    public IPv6Lease mapRow(ResultSet rs, int rowNum) throws SQLException {
        IPv6Lease lease = new IPv6Lease();

        lease.setIpAddress(rs.getString(IPADDRESS_COLUMN.getValue()));
        lease.setMacAddress(rs.getString(MACADDRESS_COLUMN.getValue()));
        lease.setHostname(rs.getString(HOSTNAME_COLUMN.getValue()));
        lease.setFecha(rs.getDate(FECHA_COLUMN.getValue()));
        lease.setMacRelay(rs.getString(MACRELAY_COLUMN.getValue()));
        lease.setIdLease(rs.getLong(IDLEASE_COLUMN.getValue()));
        lease.setDocsisSupport(rs.getString(DOCSIS_SUPPORT_COLUMN.getValue()));
        lease.setIdCliente(rs.getLong(IDCLIENTE_COLUMN.getValue()));
        lease.setIdCmts(rs.getString(IDCMTS_COLUMN.getValue()));
        lease.setFechaReboot(rs.getDate(FECHA_REBOOT_COLUMN.getValue()));
        lease.setTipoPedido(rs.getInt(TIPO_PEDIDO_COLUMN.getValue()));
        lease.setIdDsp(rs.getLong(IDDSP_COLUMN.getValue()));
        lease.setDuId(rs.getString(DUID_COLUMN.getValue()));
        lease.setIaId(rs.getString(IAID_COLUMN.getValue()));
        lease.setIaType(rs.getInt(IATYPE_COLUMN.getValue()));
        lease.setPrefixLength(rs.getString(PREFIX_LENGTH_COLUMN.getValue()));

        return lease;
    }

}