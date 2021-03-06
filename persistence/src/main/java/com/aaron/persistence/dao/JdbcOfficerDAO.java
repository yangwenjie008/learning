package com.aaron.persistence.dao;

import com.aaron.persistence.entities.Officer;
import com.aaron.persistence.entities.Rank;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class JdbcOfficerDAO implements OfficerDAO {
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert insertOfficer;


    public JdbcOfficerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.insertOfficer = new SimpleJdbcInsert(jdbcTemplate).withTableName("officers").usingGeneratedKeyColumns("id");
    }

    @Override
    public Officer save(Officer officer) {
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("rank",officer.getRank());
        parameters.put("first_name",officer.getFirst());
        parameters.put("last_name",officer.getLast());
        Integer newId = (Integer) insertOfficer.executeAndReturnKey(parameters);
        officer.setId(newId);
        return officer;
    }

    @Override
    public Optional<Officer> findById(Integer id) {
        if(!existsById(id)) return Optional.empty();

        return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT * FROM officers WHERE id=?",
                (rs,rowNum)->new Officer(rs.getInt("id"),
                Rank.valueOf(rs.getString("rank")),
                        rs.getString("first_name"),
                        rs.getString("last_name")),
                id));
    }

    @Override
    public List<Officer> findAll() {
        return jdbcTemplate.query("SELECT * FROM officers",
                (rs,rowNum)->new Officer(rs.getInt("id"),
                        Rank.valueOf(rs.getString("rank")),
                        rs.getString("first_name"),
                        rs.getString("last_name")));
    }

    @Override
    public long count() {
        return jdbcTemplate.queryForObject("select count(*) from officers",Long.class);
    }

    @Override
    public void delete(Officer officer) {
        jdbcTemplate.update("DELETE FROM officers WHERE id=?",officer.getId());
    }

    @Override
    public boolean existsById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT EXISTS(SELECT 1 FROM officers where id=?)",Boolean.class,id);
    }
}
