package ar.com.cablevision.common.wd2k.utils.mapper;

import ar.com.cablevision.common.wd2k.domain.Cablemodem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static ar.com.cablevision.common.wd2k.constant.CableModemConstants.IDCLIENTE_COLUMN;
import static ar.com.cablevision.common.wd2k.constant.CableModemConstants.MACADDRESS_COLUMN;

/**
 * Cablemodem minimum RowMapper implementation
 */
public class CableModemMinRowMapper implements RowMapper<Cablemodem> {
    @Override
    public Cablemodem mapRow(ResultSet rs, int rowNum) throws SQLException {
        Cablemodem cablemodem = new Cablemodem();

        cablemodem.setMacAddress(rs.getString(MACADDRESS_COLUMN.getValue()));
        cablemodem.setIdCliente(rs.getLong(IDCLIENTE_COLUMN.getValue()));

        return cablemodem;
    }
}
