package com.example.demo.repository;

import com.example.demo.entity.Journey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JourneyRepository extends JpaRepository<Journey, Long> {

    @Query("select j from Journey j where exists (select 1 from Trip t where t.from.id = ?1 and t.journey.id = j.id) " +
            "and exists (select 1 from Trip t where t.to.id = ?2 and t.journey.id = j.id)")
    List<Journey> findJourneyByFromAndToStations(Long stationIdFrom, Long stationIdTo);
}
