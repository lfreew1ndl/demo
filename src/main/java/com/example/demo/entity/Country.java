package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class Country {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

}
