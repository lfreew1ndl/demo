package com.example.demo.controller.dto;

import lombok.Data;

import java.util.List;

@Data
public class JourneyDTO {
    private Long id;
    private Long transportId;
    private Long crewId;
    private List<TripDTO> tripList;

}
