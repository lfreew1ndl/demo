package com.example.demo.controller.mapper;

import com.example.demo.entity.Transport;
import com.example.demo.controller.dto.TransportDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TransportMapper extends EntityMapper<TransportDTO, Transport> {
    TransportMapper INSTANCE = Mappers.getMapper(TransportMapper.class);

    @Override
    TransportDTO toDto(Transport transport);

    @Override
    List<TransportDTO> toDto(List<Transport> transportList);

    @Override
    Transport toEntity(TransportDTO transport);

    @Override
    List<Transport> toEntity(List<TransportDTO> transportList);
}
