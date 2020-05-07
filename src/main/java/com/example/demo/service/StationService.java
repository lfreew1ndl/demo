package com.example.demo.service;

import com.example.demo.entity.Station;

import java.util.List;

public interface StationService {
    Station save(Station station);

    void deleteById(Long id);

    Station findById(Long id);

    List<Station> findAll();
}
