package com.example.demo.service;

import com.example.demo.entity.Person;

import java.util.List;

public interface PersonService {
    Person save(Person person);

    void deleteById(Long id);

    Person findById(Long id);

    List<Person> findAll();
}
