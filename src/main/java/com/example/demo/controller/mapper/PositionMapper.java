package com.example.demo.controller.mapper;

import com.example.demo.entity.Position;
import com.example.demo.controller.dto.PositionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PositionMapper extends EntityMapper<PositionDTO, Position> {
    PositionMapper INSTANCE = Mappers.getMapper(PositionMapper.class);

    @Override
    PositionDTO toDto(Position position);

    @Override
    List<PositionDTO> toDto(List<Position> positionList);

    @Override
    Position toEntity(PositionDTO position);

    @Override
    List<Position> toEntity(List<PositionDTO> positionList);
}
