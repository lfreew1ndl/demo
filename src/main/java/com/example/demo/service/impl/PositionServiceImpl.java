package com.example.demo.service.impl;

import com.example.demo.controller.exception.ResourceNotFoundException;
import com.example.demo.entity.Position;
import com.example.demo.repository.PositionRepository;
import com.example.demo.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PositionServiceImpl implements PositionService {

    final
    PositionRepository positionRepository;

    @Autowired
    public PositionServiceImpl(PositionRepository PositionRepository) {
        this.positionRepository = PositionRepository;
    }

    @Override
    public Position save(Position Position) {
        return positionRepository.save(Position);
    }

    @Override
    public void deleteById(Long id) {
        if (!positionRepository.existsById(id)) throw new ResourceNotFoundException();
        positionRepository.deleteById(id);
    }

    @Override
    public Position findById(Long id) {
        return positionRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
