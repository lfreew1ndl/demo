package com.example.demo.controller;

import com.example.demo.service.CountryService;
import com.example.demo.controller.dto.CountryDTO;
import com.example.demo.controller.mapper.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/country/")
public class CountryController {

    final
    CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public List<CountryDTO> findAll() {
        return CountryMapper.INSTANCE.toDto(countryService.findAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public CountryDTO findById(@PathVariable Long id) {
        return CountryMapper.INSTANCE.toDto(countryService.findById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/", produces = "application/json")
    public CountryDTO create(@RequestBody CountryDTO country) {
        if (country.getId() != null) throw new IllegalArgumentException();
        return CountryMapper.INSTANCE.toDto(countryService.save(CountryMapper.INSTANCE.toEntity(country)));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public CountryDTO update(@RequestBody CountryDTO country, @PathVariable Long id) {
        country.setId(id);
        return CountryMapper.INSTANCE.toDto(countryService.save(CountryMapper.INSTANCE.toEntity(country)));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        countryService.deleteById(id);
    }
}
