package com.example.demo.controller;

import com.example.demo.service.CrewService;
import com.example.demo.controller.dto.CrewDTO;
import com.example.demo.controller.mapper.CrewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crew/")
public class CrewController {

    final
    CrewService crewService;

    @Autowired
    public CrewController(CrewService crewService) {
        this.crewService = crewService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public List<CrewDTO> findAll() {
        return CrewMapper.INSTANCE.toDto(crewService.findAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public CrewDTO findById(@PathVariable Long id) {
        return CrewMapper.INSTANCE.toDto(crewService.findById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/", produces = "application/json")
    public CrewDTO create(@RequestBody CrewDTO crew) {
        if (crew.getId() != null) throw new IllegalArgumentException();
        return CrewMapper.INSTANCE.toDto(crewService.save(CrewMapper.INSTANCE.toEntity(crew)));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public CrewDTO update(@RequestBody CrewDTO crew, @PathVariable Long id) {
        crew.setId(id);
        return CrewMapper.INSTANCE.toDto(crewService.save(CrewMapper.INSTANCE.toEntity(crew)));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        crewService.deleteById(id);
    }
}
