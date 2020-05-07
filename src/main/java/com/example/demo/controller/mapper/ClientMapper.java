package com.example.demo.controller.mapper;

import com.example.demo.entity.Client;
import com.example.demo.controller.dto.ClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClientMapper extends EntityMapper<ClientDTO, Client> {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Override
    @Mapping(source = "person.id", target = "personId")
    ClientDTO toDto(Client client);

    @Override
    List<ClientDTO> toDto(List<Client> clientList);

    @Override
    @Mapping(source = "personId", target = "person.id")
    Client toEntity(ClientDTO client);

    @Override
    List<Client> toEntity(List<ClientDTO> clientList);
}
