package com.aaron.persistence.dao;


import com.aaron.persistence.entities.Officer;
import com.aaron.persistence.entities.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OfficerRepository extends JpaRepository<Officer, Integer> {

    List<Officer> findByLast(String last);
    List<Officer> findAllByRankAndLastLike(Rank rank, String last);
}
