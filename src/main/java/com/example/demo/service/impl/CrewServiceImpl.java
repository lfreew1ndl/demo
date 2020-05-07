package com.example.demo.service.impl;

import com.example.demo.controller.exception.ResourceNotFoundException;
import com.example.demo.entity.Crew;
import com.example.demo.repository.CrewRepository;
import com.example.demo.service.CrewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CrewServiceImpl implements CrewService {

    final
    CrewRepository crewRepository;

    @Autowired
    public CrewServiceImpl(CrewRepository CrewRepository) {
        this.crewRepository = CrewRepository;
    }

    @Override
    public Crew save(Crew Crew) {
        return crewRepository.save(Crew);
    }

    @Override
    public void deleteById(Long id) {
        if (!crewRepository.existsById(id)) throw new ResourceNotFoundException();
        crewRepository.deleteById(id);
    }

    @Override
    public Crew findById(Long id) {
        return crewRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<Crew> findAll() {
        return crewRepository.findAll();
    }
}
