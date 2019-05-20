package ar.com.cablevision.common.wd2k.repository;

import ar.com.cablevision.common.wd2k.domain.Cablemodem;
import ar.com.cablevision.common.wd2k.utils.mapper.CableModemMinRowMapper;
import ar.com.cablevision.common.wd2k.utils.mapper.CableModemRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static ar.com.cablevision.common.wd2k.constant.CableModemConstants.*;

@Repository
public class CablemodemRepository extends BaseRepository<Cablemodem> {

    public CablemodemRepository() {
        super();
    }

    @Override
    public List<Cablemodem> findAll() throws Exception {
        return jdbcTemplate.query(FIND_ALL_QUERY.getValue(), new CableModemRowMapper());
    }

    @Override
    public Cablemodem findById(Long id) throws Exception {
        return jdbcTemplate.queryForObject(FIND_BY_ID_QUERY.getValue(), new Object[]{id}, new CableModemRowMapper());
    }

    @Transactional(readOnly = true)
    public List<Cablemodem> findIdClienteByMacAddress(final Set<String> macAddresses) throws Exception {
        Map<String, Set<String>> namedParameters = new ConcurrentHashMap<String, Set<String>>(){{put(MACADRESSES_NAMED_PARAMETER.getValue(), macAddresses);}};
        return namedParameterJdbcTemplate.query(FIND_IDCLIENTS_BY_MACADDRESS_QUERY.getValue(), namedParameters, new CableModemMinRowMapper());
    }

    @Override
    public Cablemodem create(final Cablemodem cablemodem) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Cablemodem update(Cablemodem cablemodem) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Cablemodem updateById(Long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Cablemodem cablemodem) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException();
    }
}
