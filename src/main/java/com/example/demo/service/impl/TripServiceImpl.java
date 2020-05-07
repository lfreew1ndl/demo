package com.example.demo.service.impl;

import com.example.demo.controller.exception.ResourceNotFoundException;
import com.example.demo.entity.Trip;
import com.example.demo.repository.TripRepository;
import com.example.demo.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TripServiceImpl implements TripService {

    final
    TripRepository tripRepository;

    @Autowired
    public TripServiceImpl(TripRepository TripRepository) {
        this.tripRepository = TripRepository;
    }

    @Override
    public Trip save(Trip Trip) {
        return tripRepository.save(Trip);
    }


    @Override
    public void deleteById(Long id) {
        if (!tripRepository.existsById(id)) throw new ResourceNotFoundException();
        tripRepository.deleteById(id);
    }

    @Override
    public Trip findById(Long id) {
        return tripRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<Trip> findAll() {
        return tripRepository.findAll();
    }
}
