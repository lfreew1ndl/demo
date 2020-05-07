package com.example.demo.controller;

import com.example.demo.service.CityService;
import com.example.demo.controller.dto.CityDTO;
import com.example.demo.controller.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city/")
public class CityController {

    final
    CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public List<CityDTO> findAll() {
        return CityMapper.INSTANCE.toDto(cityService.findAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public CityDTO findById(@PathVariable Long id) {
        return CityMapper.INSTANCE.toDto(cityService.findById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/", produces = "application/json")
    public CityDTO create(@RequestBody CityDTO city) {
        if (city.getId() != null) throw new IllegalArgumentException();
        return CityMapper.INSTANCE.toDto(cityService.save(CityMapper.INSTANCE.toEntity(city)));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public CityDTO update(@RequestBody CityDTO city, @PathVariable Long id) {
        city.setId(id);
        return CityMapper.INSTANCE.toDto(cityService.save(CityMapper.INSTANCE.toEntity(city)));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        cityService.deleteById(id);
    }
}
