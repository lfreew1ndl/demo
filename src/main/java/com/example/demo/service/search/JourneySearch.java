package com.example.demo.service.search;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class JourneySearch {
    @NotNull
    private Long fromStationId;
    @NotNull
    private Long toStationId;

}
