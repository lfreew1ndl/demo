package com.example.demo.controller.mapper;

import com.example.demo.entity.Country;
import com.example.demo.controller.dto.CountryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CountryMapper extends EntityMapper<CountryDTO, Country>{
    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    @Override
    CountryDTO toDto(Country country);

    @Override
    List<CountryDTO> toDto(List<Country> countryList);

    @Override
    Country toEntity(CountryDTO country);

    @Override
    List<Country> toEntity(List<CountryDTO> countryList);
}
