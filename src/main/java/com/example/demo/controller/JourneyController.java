package com.example.demo.controller;

import com.example.demo.controller.mapper.TripMapper;
import com.example.demo.entity.Journey;
import com.example.demo.entity.Trip;
import com.example.demo.service.JourneyService;
import com.example.demo.controller.dto.JourneyDTO;
import com.example.demo.controller.mapper.JourneyMapper;
import com.example.demo.service.search.JourneySearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/journey/")
public class JourneyController {

    final
    JourneyService journeyService;

    @Autowired
    public JourneyController(JourneyService journeyService) {
        this.journeyService = journeyService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public List<JourneyDTO> findAll() {
        return JourneyMapper.INSTANCE.toDto(journeyService.findAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public JourneyDTO findById(@PathVariable Long id) {
        return JourneyMapper.INSTANCE.toDto(journeyService.findById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/", produces = "application/json")
    public JourneyDTO create(@RequestBody JourneyDTO journey) {
        if (journey.getId() != null) throw new IllegalArgumentException();
        List<Trip> trips = TripMapper.INSTANCE.toEntity(journey.getTripList());
        Journey journeyEntity = JourneyMapper.INSTANCE.toEntity(journey);
        return JourneyMapper.INSTANCE.toDto(journeyService.save(journeyEntity, trips));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/search")
    public List<JourneyDTO> search(@Validated JourneySearch journeySearch) {
        return JourneyMapper.INSTANCE.toDto(journeyService.search(journeySearch));

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public JourneyDTO update(@RequestBody JourneyDTO journey, @PathVariable Long id) {
        journey.setId(id);
        List<Trip> trips = TripMapper.INSTANCE.toEntity(journey.getTripList());
        Journey journeyEntity = JourneyMapper.INSTANCE.toEntity(journey);
        return JourneyMapper.INSTANCE.toDto(journeyService.save(journeyEntity, trips));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        journeyService.deleteById(id);
    }
}
