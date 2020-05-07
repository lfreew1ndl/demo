package com.example.demo.service;

import com.example.demo.entity.Crew;

import java.util.List;

public interface CrewService {
    Crew save(Crew crew);

    void deleteById(Long id);

    Crew findById(Long id);

    List<Crew> findAll();
}
