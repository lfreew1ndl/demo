package com.example.demo.controller.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class CrewDTO {
    private Long id;
    private List<CadreDTO> cadres;
    private LocalDate createdDate;
    private Long duration;
}
