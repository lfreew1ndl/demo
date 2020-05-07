package com.example.demo.controller.mapper;

import com.example.demo.entity.Journey;
import com.example.demo.controller.dto.JourneyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface JourneyMapper extends EntityMapper<JourneyDTO, Journey> {
    JourneyMapper INSTANCE = Mappers.getMapper(JourneyMapper.class);

    @Override
    @Mapping(source = "transport.id", target = "transportId")
    @Mapping(source = "crew.id", target = "crewId")
    JourneyDTO toDto(Journey journey);

    @Override
    List<JourneyDTO> toDto(List<Journey> journeyList);

    @Override
    @Mapping(source = "transportId", target = "transport.id")
    @Mapping(source = "crewId", target = "crew.id")
    Journey toEntity(JourneyDTO journey);

    @Override
    List<Journey> toEntity(List<JourneyDTO> journeyList);
}
