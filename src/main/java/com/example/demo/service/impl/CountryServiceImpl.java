package com.example.demo.service.impl;

import com.example.demo.controller.exception.ResourceNotFoundException;
import com.example.demo.entity.Country;
import com.example.demo.repository.CountryRepository;
import com.example.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {

    final
    CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository CountryRepository) {
        this.countryRepository = CountryRepository;
    }

    @Override
    public Country save(Country Country) {
        return countryRepository.save(Country);
    }

    @Override
    public void deleteById(Long id) {
        if (!countryRepository.existsById(id)) throw new ResourceNotFoundException();
        countryRepository.deleteById(id);
    }

    @Override
    public Country findById(Long id) {
        return countryRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }
}
