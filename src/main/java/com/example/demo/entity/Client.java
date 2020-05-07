package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Table(name = "client", uniqueConstraints = @UniqueConstraint(columnNames = "person_id"))
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne
    private Person person;

    @ManyToMany(mappedBy = "clientList")
    private List<Trip> tripList;
}
