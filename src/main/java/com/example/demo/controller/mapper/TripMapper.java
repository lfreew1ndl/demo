package com.example.demo.controller.mapper;

import com.example.demo.entity.Trip;
import com.example.demo.controller.dto.TripDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TripMapper extends EntityMapper<TripDTO, Trip> {
    TripMapper INSTANCE = Mappers.getMapper(TripMapper.class);

    @Override
    @Mapping(source = "journey.id", target = "journeyId")
    @Mapping(source = "to.id", target = "toStationId")
    @Mapping(source = "from.id", target = "fromStationId")
    TripDTO toDto(Trip trip);

    @Override
    List<TripDTO> toDto(List<Trip> tripList);

    @Override
    @Mapping(source = "journeyId", target = "journey.id")
    @Mapping(source = "toStationId", target = "to.id")
    @Mapping(source = "fromStationId", target = "from.id")
    Trip toEntity(TripDTO trip);

    @Override
    List<Trip> toEntity(List<TripDTO> tripList);
}
