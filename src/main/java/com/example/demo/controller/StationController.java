package com.example.demo.controller;

import com.example.demo.service.StationService;
import com.example.demo.controller.dto.StationDTO;
import com.example.demo.controller.mapper.StationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/station/")
public class StationController {

    final
    StationService stationService;

    @Autowired
    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public List<StationDTO> findAll() {
        return StationMapper.INSTANCE.toDto(stationService.findAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public StationDTO findById(@PathVariable Long id) {
        return StationMapper.INSTANCE.toDto(stationService.findById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/", produces = "application/json")
    public StationDTO create(@RequestBody StationDTO station) {
        if (station.getId() != null) throw new IllegalArgumentException();
        return StationMapper.INSTANCE.toDto(stationService.save(StationMapper.INSTANCE.toEntity(station)));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public StationDTO update(@RequestBody StationDTO station, @PathVariable Long id) {
        station.setId(id);
        return StationMapper.INSTANCE.toDto(stationService.save(StationMapper.INSTANCE.toEntity(station)));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        stationService.deleteById(id);
    }
}
