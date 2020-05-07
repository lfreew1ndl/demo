package com.example.demo.controller.mapper;

import com.example.demo.entity.Cadre;
import com.example.demo.controller.dto.CadreDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CadreMapper extends EntityMapper<CadreDTO, Cadre> {
    CadreMapper INSTANCE = Mappers.getMapper(CadreMapper.class);

    @Override
    @Mapping(source = "person.id", target = "personId")
    @Mapping(source = "position.id", target = "positionId")
    CadreDTO toDto(Cadre cadre);

    @Override
    List<CadreDTO> toDto(List<Cadre> cadreList);

    @Override
    @Mapping(source = "personId", target = "person.id")
    @Mapping(source = "positionId", target = "position.id")
    Cadre toEntity(CadreDTO cadre);

    @Override
    List<Cadre> toEntity(List<CadreDTO> cadreList);
}
