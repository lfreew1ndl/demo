package com.example.demo.service;

import com.example.demo.entity.Journey;
import com.example.demo.entity.Trip;
import com.example.demo.service.search.JourneySearch;

import java.util.List;

public interface JourneyService {
    List<Journey> search(JourneySearch journeySearch);

    Journey save(Journey journey, List<Trip> trips);

    void deleteById(Long id);

    Journey findById(Long id);

    List<Journey> findAll();
}
