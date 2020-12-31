package com.aaron.persistence.dao;


import com.aaron.persistence.entities.Officer;
import com.aaron.persistence.entities.Rank;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
class JdbcOfficerDAOTest {

    @Autowired
    @Qualifier("jdbcOfficerDAO")
    private OfficerDAO officerDAO;

    @Test
    void save() {
        Officer officer = officerDAO.save(new Officer(Rank.ENSIGN,"Pavel","Chekov"));
        assertNotNull(officer.getId());
    }

    @Test
    void findByIdThatExists() {
        Optional<Officer> officerOptional = officerDAO.findById(1);
        assertTrue(officerOptional.isPresent());
        assertEquals(1,officerOptional.get().getId().intValue());
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
        IntStream.rangeClosed(1,2)
                .forEach(id -> {
                    Optional<Officer> officer = officerDAO.findById(id);
                    assertTrue(officer.isPresent());
                    officerDAO.delete(officer.get());
                });
        assertEquals(0,officerDAO.count());
    }

    @Test
    void existsById() {
        IntStream.rangeClosed(1,2)
                .forEach(id -> {
                    assertTrue(officerDAO.existsById(id));
                });
    }
}