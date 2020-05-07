package com.example.demo.service;

import com.example.demo.entity.Cadre;

import java.util.List;

public interface CadreService {
    Cadre save(Cadre cadre);

    void deleteById(Long id);

    Cadre findById(Long id);

    List<Cadre> findAll();
}
