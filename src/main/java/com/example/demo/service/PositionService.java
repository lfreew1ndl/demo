package com.example.demo.service;

import com.example.demo.entity.Position;

import java.util.List;

public interface PositionService {
    Position save(Position position);

    void deleteById(Long id);

    Position findById(Long id);

    List<Position> findAll();
}
