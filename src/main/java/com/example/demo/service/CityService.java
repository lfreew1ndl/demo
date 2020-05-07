package com.example.demo.service;

import com.example.demo.entity.City;

import java.util.List;

public interface CityService {
    City save(City city);

    void deleteById(Long id);

    City findById(Long id);

    List<City> findAll();
}
