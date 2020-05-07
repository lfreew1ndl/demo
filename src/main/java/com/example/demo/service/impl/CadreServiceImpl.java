package com.example.demo.service.impl;

import com.example.demo.controller.exception.ResourceNotFoundException;
import com.example.demo.entity.Cadre;
import com.example.demo.repository.CadreRepository;
import com.example.demo.service.CadreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CadreServiceImpl implements CadreService {

    final
    CadreRepository cadreRepository;

    @Autowired
    public CadreServiceImpl(CadreRepository cadreRepository) {
        this.cadreRepository = cadreRepository;
    }

    @Override
    public Cadre save(Cadre cadre) {
        return cadreRepository.save(cadre);
    }

    @Override
    public void deleteById(Long id) {
        if (!cadreRepository.existsById(id)) throw new ResourceNotFoundException();
        cadreRepository.deleteById(id);
    }

    @Override
    public Cadre findById(Long id) {
        return cadreRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<Cadre> findAll() {
        return cadreRepository.findAll();
    }
}
