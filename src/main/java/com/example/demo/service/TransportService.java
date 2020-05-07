package com.example.demo.service;

import com.example.demo.entity.Transport;

import java.util.List;

public interface TransportService {
    Transport save(Transport transport);

    void deleteById(Long id);

    Transport findById(Long id);

    List<Transport> findAll();
}
