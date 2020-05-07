package com.example.demo.controller;

import com.example.demo.service.CadreService;
import com.example.demo.controller.dto.CadreDTO;
import com.example.demo.controller.mapper.CadreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cadre/")
public class CadreController {

    final
    CadreService cadreService;

    @Autowired
    public CadreController(CadreService cadreService) {
        this.cadreService = cadreService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public List<CadreDTO> findAll() {
        return CadreMapper.INSTANCE.toDto(cadreService.findAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public CadreDTO findById(@PathVariable Long id) {
        return CadreMapper.INSTANCE.toDto(cadreService.findById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/", produces = "application/json")
    public CadreDTO create(@RequestBody CadreDTO cadre) {
        if (cadre.getId() != null) throw new IllegalArgumentException();
        return CadreMapper.INSTANCE.toDto(cadreService.save(CadreMapper.INSTANCE.toEntity(cadre)));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public CadreDTO update(@RequestBody CadreDTO cadre, @PathVariable Long id) {
        cadre.setId(id);
        return CadreMapper.INSTANCE.toDto(cadreService.save(CadreMapper.INSTANCE.toEntity(cadre)));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        cadreService.deleteById(id);
    }
}
