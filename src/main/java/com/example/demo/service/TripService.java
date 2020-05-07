package com.example.demo.service;

import com.example.demo.entity.Trip;

import java.util.List;

public interface TripService {
    Trip save(Trip trip);

    void deleteById(Long id);

    Trip findById(Long id);

    List<Trip> findAll();
}
