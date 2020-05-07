package com.example.demo.controller;

import com.example.demo.service.TripService;
import com.example.demo.controller.dto.TripDTO;
import com.example.demo.controller.mapper.TripMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trip/")
public class TripController {

    final
    TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public List<TripDTO> findAll() {
        return TripMapper.INSTANCE.toDto(tripService.findAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public TripDTO findById(@PathVariable Long id) {
        return TripMapper.INSTANCE.toDto(tripService.findById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/", produces = "application/json")
    public TripDTO create(@RequestBody TripDTO trip) {
        if (trip.getId() != null) throw new IllegalArgumentException();
        return TripMapper.INSTANCE.toDto(tripService.save(TripMapper.INSTANCE.toEntity(trip)));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public TripDTO update(@RequestBody TripDTO trip, @PathVariable Long id) {
        trip.setId(id);
        return TripMapper.INSTANCE.toDto(tripService.save(TripMapper.INSTANCE.toEntity(trip)));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        tripService.deleteById(id);
    }
}
