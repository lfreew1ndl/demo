package com.example.demo.controller.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class TripDTO {
    private Long id;

    private String name;

    private Long fromStationId;

    private Long toStationId;

    private Long journeyId;

    private List<ClientDTO> clientList;

    private LocalDate dateOfDeparture;

    private Long duration;
}
