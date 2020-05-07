package com.example.demo.service.impl;

import com.example.demo.controller.exception.ResourceNotFoundException;
import com.example.demo.entity.Transport;
import com.example.demo.repository.TransportRepository;
import com.example.demo.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TransportServiceImpl implements TransportService {

    final
    TransportRepository transportRepository;

    @Autowired
    public TransportServiceImpl(TransportRepository TransportRepository) {
        this.transportRepository = TransportRepository;
    }

    @Override
    public Transport save(Transport Transport) {
        return transportRepository.save(Transport);
    }

    @Override
    public void deleteById(Long id) {
        if (!transportRepository.existsById(id)) throw new ResourceNotFoundException();
        transportRepository.deleteById(id);
    }

    @Override
    public Transport findById(Long id) {
        return transportRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<Transport> findAll() {
        return transportRepository.findAll();
    }
}
