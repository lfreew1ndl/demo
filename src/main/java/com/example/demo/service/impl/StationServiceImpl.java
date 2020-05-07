package com.example.demo.service.impl;

import com.example.demo.controller.exception.ResourceNotFoundException;
import com.example.demo.entity.Station;
import com.example.demo.repository.StationRepository;
import com.example.demo.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StationServiceImpl implements StationService {

    final
    StationRepository stationRepository;

    @Autowired
    public StationServiceImpl(StationRepository StationRepository) {
        this.stationRepository = StationRepository;
    }

    @Override
    public Station save(Station Station) {
        return stationRepository.save(Station);
    }

    @Override
    public void deleteById(Long id) {
        if (!stationRepository.existsById(id)) throw new ResourceNotFoundException();
        stationRepository.deleteById(id);
    }

    @Override
    public Station findById(Long id) {
        return stationRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<Station> findAll() {
        return stationRepository.findAll();
    }
}
