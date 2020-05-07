package com.example.demo.controller.mapper;

import com.example.demo.entity.City;
import com.example.demo.controller.dto.CityDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CityMapper extends EntityMapper<CityDTO, City> {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    @Override
    @Mapping(source = "country.id", target = "countryId")
    CityDTO toDto(City city);

    @Override
    List<CityDTO> toDto(List<City> cityList);

    @Override
    @Mapping(source = "countryId", target = "country.id")
    City toEntity(CityDTO city);

    @Override
    List<City> toEntity(List<CityDTO> cityList);
}
