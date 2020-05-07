package com.example.demo.controller;

import com.example.demo.service.PersonService;
import com.example.demo.controller.dto.PersonDTO;
import com.example.demo.controller.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person/")
public class PersonController {

    final
    PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public List<PersonDTO> findAll() {
        return PersonMapper.INSTANCE.toDto(personService.findAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) {
        return PersonMapper.INSTANCE.toDto(personService.findById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/", produces = "application/json")
    public PersonDTO create(@RequestBody PersonDTO person) {
        if (person.getId() != null) throw new IllegalArgumentException();
        return PersonMapper.INSTANCE.toDto(personService.save(PersonMapper.INSTANCE.toEntity(person)));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public PersonDTO update(@RequestBody PersonDTO person, @PathVariable Long id) {
        person.setId(id);
        return PersonMapper.INSTANCE.toDto(personService.save(PersonMapper.INSTANCE.toEntity(person)));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        personService.deleteById(id);
    }
}
