package com.example.demo.controller.mapper;

import com.example.demo.entity.Station;
import com.example.demo.controller.dto.StationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StationMapper extends EntityMapper<StationDTO, Station> {
    StationMapper INSTANCE = Mappers.getMapper(StationMapper.class);

    @Override
    @Mapping(source = "city.id", target = "cityId")
    StationDTO toDto(Station station);

    @Override
    List<StationDTO> toDto(List<Station> stationList);

    @Override
    @Mapping(source = "cityId", target = "city.id")
    Station toEntity(StationDTO station);

    @Override
    List<Station> toEntity(List<StationDTO> stationList);
}
