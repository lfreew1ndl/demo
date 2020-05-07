package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Position {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;
}
