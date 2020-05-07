package com.example.demo.controller;

import com.example.demo.service.PositionService;
import com.example.demo.controller.dto.PositionDTO;
import com.example.demo.controller.mapper.PositionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/position/")
public class PositionController {

    final
    PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public List<PositionDTO> findAll() {
        return PositionMapper.INSTANCE.toDto(positionService.findAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public PositionDTO findById(@PathVariable Long id) {
        return PositionMapper.INSTANCE.toDto(positionService.findById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/", produces = "application/json")
    public PositionDTO create(@RequestBody PositionDTO position) {
        if (position.getId() != null) throw new IllegalArgumentException();
        return PositionMapper.INSTANCE.toDto(positionService.save(PositionMapper.INSTANCE.toEntity(position)));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public PositionDTO update(@RequestBody PositionDTO position, @PathVariable Long id) {
        position.setId(id);
        return PositionMapper.INSTANCE.toDto(positionService.save(PositionMapper.INSTANCE.toEntity(position)));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        positionService.deleteById(id);
    }
}
