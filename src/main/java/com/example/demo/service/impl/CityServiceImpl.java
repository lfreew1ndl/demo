package com.example.demo.service.impl;

import com.example.demo.controller.exception.ResourceNotFoundException;
import com.example.demo.entity.City;
import com.example.demo.repository.CityRepository;
import com.example.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CityServiceImpl implements CityService {

    final
    CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository CityRepository) {
        this.cityRepository = CityRepository;
    }

    @Override
    public City save(City City) {
        return cityRepository.save(City);
    }

    @Override
    public void deleteById(Long id) {
        if (!cityRepository.existsById(id)) throw new ResourceNotFoundException();
        cityRepository.deleteById(id);
    }

    @Override
    public City findById(Long id) {
        return cityRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }
}
