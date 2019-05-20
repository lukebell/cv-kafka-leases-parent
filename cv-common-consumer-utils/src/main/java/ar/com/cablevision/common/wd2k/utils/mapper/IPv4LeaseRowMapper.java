package ar.com.cablevision.common.wd2k.utils.mapper;

import ar.com.cablevision.common.wd2k.domain.IPv4Lease;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static ar.com.cablevision.common.wd2k.constant.IPv4LeaseConstants.*;

/**
 * IPv4 BaseLease RowMapper implementation
 */
public class IPv4LeaseRowMapper implements RowMapper<IPv4Lease> {
    @Override
    public IPv4Lease mapRow(ResultSet rs, int rowNum) throws SQLException {
        IPv4Lease lease = new IPv4Lease();

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

        return lease;
    }

}