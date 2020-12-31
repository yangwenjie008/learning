package com.aaron.persistence.dao;

import com.aaron.persistence.entities.Officer;
import com.aaron.persistence.entities.Rank;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
class JpaOfficerDAOTest {

    @Autowired
    @Qualifier("jpaOfficerDAO")
    private OfficerDAO officerDAO;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Integer> idMapper = (rs, num) -> rs.getInt("id");

    @Test
    void save() {
        Officer officer = officerDAO.save(new Officer(Rank.ENSIGN,"Pavel","Chekov"));
        assertNotNull(officer.getId());
    }

    @Test
    void findByIdThatExists() {
        jdbcTemplate.query("select id from officers",idMapper).forEach(id -> {
            Optional<Officer> officer = officerDAO.findById(id);
            assertTrue(officer.isPresent());
            assertEquals(id,officer.get().getId());
        });
    }

    @Test
    void findByIdThatDoesNotExist() {
        Optional<Officer> officerOptional = officerDAO.findById(-1);
        assertFalse(officerOptional.isPresent());
    }

    @Test
    void findAll() {
        List<String> dbNames =  officerDAO.findAll().stream().map(Officer::getLast).collect(Collectors.toList());
        assertThat(dbNames,containsInAnyOrder("Archer","Kirk"));
    }

    @Test
    void count() {
        assertEquals(2,officerDAO.count());
    }

    @Test
    void delete() {
        jdbcTemplate.query("select id from officers",idMapper).forEach(id ->{
            Optional<Officer> officer = officerDAO.findById(id);
            assertTrue(officer.isPresent());
            officerDAO.delete(officer.get());
        });

        assertEquals(0,officerDAO.count());
    }

    @Test
    void existsById() {
        jdbcTemplate.query("select id from officers",idMapper).forEach(id ->{
            assertTrue(officerDAO.existsById(id));
        });
    }

    @Test
    void doesNotExistsById() {
        List<Integer> ids = jdbcTemplate.query("select id from officers",idMapper);
        assertThat(ids,not(contains(999)));
        assertFalse(officerDAO.existsById(999));
    }

}