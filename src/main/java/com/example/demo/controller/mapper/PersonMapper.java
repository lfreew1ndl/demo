package com.example.demo.controller.mapper;

import com.example.demo.entity.Person;
import com.example.demo.controller.dto.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PersonMapper extends EntityMapper<PersonDTO, Person> {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Override
    PersonDTO toDto(Person person);

    @Override
    List<PersonDTO> toDto(List<Person> personList);

    @Override
    Person toEntity(PersonDTO person);

    @Override
    List<Person> toEntity(List<PersonDTO> personList);
}
