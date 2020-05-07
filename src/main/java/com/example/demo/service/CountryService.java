package com.example.demo.service;

import com.example.demo.entity.Country;

import java.util.List;

public interface CountryService {
    Country save(Country country);

    void deleteById(Long id);

    Country findById(Long id);

    List<Country> findAll();
}
