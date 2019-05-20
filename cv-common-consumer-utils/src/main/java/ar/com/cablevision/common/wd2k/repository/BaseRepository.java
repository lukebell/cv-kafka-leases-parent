package ar.com.cablevision.common.wd2k.repository;

import ar.com.cablevision.common.wd2k.domain.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.List;

@Repository
public abstract class BaseRepository<T extends BaseEntity> {

    public BaseRepository() {
    }

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    @Autowired
    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Transactional(readOnly = true)
    public abstract List<T> findAll() throws Exception;

    @Transactional(readOnly = true)
    public abstract T findById(Long id) throws Exception;

    @Transactional
    public abstract T update(final T t) throws Exception;

    @Transactional
    public abstract T updateById(Long id) throws Exception;

    @Transactional
    public abstract T create(final T t) throws Exception;

    @Transactional
    public abstract void delete(final T t) throws Exception;

    @Transactional
    public abstract void deleteById(final Long id);

    public void setValue(PreparedStatement ps, int index, String value) throws SQLException {
        ps.setString(index, value);
    }

    public void setValue(PreparedStatement ps, int index, Date value) throws SQLException {
        if(value == null) {
            ps.setNull(index, Types.DATE);
        } else {
            ps.setTimestamp(index, new Timestamp(value.getTime()));
        }
    }

    public void setValue(PreparedStatement ps, int index, Integer value) throws SQLException {
        if(value == null) {
            ps.setNull(index, Types.INTEGER);
        } else {
            ps.setInt(index, value);
        }
    }

    public void setValue(PreparedStatement ps, int index, Double value) throws SQLException {
        if(value == null) {
            ps.setNull(index, Types.DOUBLE);
        } else {
            ps.setDouble(index, value);
        }
    }

    public void setValue(PreparedStatement ps, int index, Long value) throws SQLException {
        if(value == null) {
            ps.setNull(index, Types.BIGINT);
        } else {
            ps.setLong(index, value);
        }
    }
}