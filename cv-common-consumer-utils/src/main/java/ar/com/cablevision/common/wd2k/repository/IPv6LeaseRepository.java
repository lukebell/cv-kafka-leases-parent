package ar.com.cablevision.common.wd2k.repository;

import ar.com.cablevision.common.wd2k.domain.IPv6Lease;
import ar.com.cablevision.common.wd2k.utils.mapper.IPv6LeaseRowMapper;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import static ar.com.cablevision.common.wd2k.constant.IPv6LeaseConstants.*;

@Repository
public class IPv6LeaseRepository extends BaseRepository<IPv6Lease> {

    public IPv6LeaseRepository() {
        super();
    }

    @Override
    public List<IPv6Lease> findAll() throws Exception {
        return jdbcTemplate.query(FIND_ALL_QUERY.getValue(), new IPv6LeaseRowMapper());
    }

    @Override
    public IPv6Lease findById(Long id) throws Exception {
        return jdbcTemplate.queryForObject(FIND_BY_ID_QUERY.getValue(), new Object[]{id}, new IPv6LeaseRowMapper());
    }

    @Transactional(readOnly = true)
    public List<Long> existsLeases(Map<Long, IPv6Lease> leases) throws Exception {

        Set<Date> fechas = new HashSet<>();

        for (Iterator<IPv6Lease> iterator = leases.values().iterator(); iterator.hasNext(); ) {
            IPv6Lease iPv6Lease = iterator.next();
            if(iPv6Lease.getFecha() != null) {
                fechas.add(Date.valueOf(iPv6Lease.getFecha().toLocalDate().toString()));
            }
        }
        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put(MINFECHA_NAMED_PARAMETER.getValue(), new Timestamp ((Collections.min(fechas)).getTime()));
        namedParameters.put(MAXFECHA_NAMED_PARAMETER.getValue(), new Timestamp ((Collections.max(fechas)).getTime()));
        namedParameters.put(IDLEASES_NAMED_PARAMETER.getValue(), leases.keySet());

        return namedParameterJdbcTemplate.queryForList(EXISTS_IDLEASE_QUERY.getValue(), namedParameters, Long.class);
    }

    @Override
    public IPv6Lease create(final IPv6Lease lease) throws Exception {
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
                PreparedStatement ps = connection.prepareStatement(INSERT_QUERY.getValue(), Statement.RETURN_GENERATED_KEYS);
                setValue(ps, 1, lease.getIpAddress());
                setValue(ps, 2, lease.getMacAddress());
                setValue(ps, 3, lease.getHostname());
                setValue(ps, 4, lease.getFecha());
                setValue(ps, 5, lease.getMacRelay());
                setValue(ps, 6, lease.getIdLease());
                setValue(ps, 7, lease.getDocsisSupport());
                setValue(ps, 8, lease.getIdCliente());
                setValue(ps, 9, lease.getIdCmts());
                setValue(ps, 10, lease.getFechaReboot());
                setValue(ps, 11, lease.getTipoPedido());
                setValue(ps, 12, lease.getIdDsp());
                setValue(ps, 13, lease.getDuId());
                setValue(ps, 14, lease.getIaId());
                setValue(ps, 15, lease.getIaType());
                setValue(ps, 16, lease.getPrefixLength());
                return ps;
            }
        }, holder);

        lease.setIdLease(holder.getKey().longValue());
        return lease;
    }

    @Transactional
    public void createBatch(final List<IPv6Lease> leases) throws Exception {

        jdbcTemplate.batchUpdate(INSERT_QUERY.getValue(), new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                IPv6Lease lease = leases.get(i);
                setValue(ps, 1, lease.getIpAddress());
                setValue(ps, 2, lease.getMacAddress());
                setValue(ps, 3, lease.getHostname());
                setValue(ps, 4, lease.getFecha());
                setValue(ps, 5, lease.getMacRelay());
                setValue(ps, 6, lease.getIdLease());
                setValue(ps, 7, lease.getDocsisSupport());
                setValue(ps, 8, lease.getIdCliente());
                setValue(ps, 9, lease.getIdCmts());
                setValue(ps, 10, lease.getFechaReboot());
                setValue(ps, 11, lease.getTipoPedido());
                setValue(ps, 12, lease.getIdDsp());
                setValue(ps, 13, lease.getDuId());
                setValue(ps, 14, lease.getIaId());
                setValue(ps, 15, lease.getIaType());
                setValue(ps, 16, lease.getPrefixLength());
            }

            @Override
            public int getBatchSize() {
                return leases.size();
            }
        });
    }

    @Override
    public IPv6Lease update(IPv6Lease ipv4Lease) {
        throw new UnsupportedOperationException();
    }

    @Override
    public IPv6Lease updateById(Long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(IPv6Lease ipv4Lease) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException();
    }
}
