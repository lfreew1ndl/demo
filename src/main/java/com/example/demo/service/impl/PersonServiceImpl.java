package com.example.demo.service.impl;

import com.example.demo.controller.exception.ResourceNotFoundException;
import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    final
    PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository PersonRepository) {
        this.personRepository = PersonRepository;
    }

    @Override
    public Person save(Person Person) {
        return personRepository.save(Person);
    }

    @Override
    public void deleteById(Long id) {
        if (!personRepository.existsById(id)) throw new ResourceNotFoundException();
        personRepository.deleteById(id);
    }

    @Override
    public Person findById(Long id) {
        return personRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }
}
