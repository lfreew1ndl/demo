package com.example.demo.controller.mapper;

import com.example.demo.entity.Crew;
import com.example.demo.controller.dto.CrewDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CrewMapper extends EntityMapper<CrewDTO, Crew> {
    CrewMapper INSTANCE = Mappers.getMapper(CrewMapper.class);

    @Override
    CrewDTO toDto(Crew crew);

    @Override
    List<CrewDTO> toDto(List<Crew> crewList);

    @Override
    Crew toEntity(CrewDTO crew);

    @Override
    List<Crew> toEntity(List<CrewDTO> crewList);
}
