package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Station from;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Station to;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Journey journey;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Client> clientList;

    @NotNull
    private LocalDate dateOfDeparture;

    @NotNull
    private Long duration;

}
