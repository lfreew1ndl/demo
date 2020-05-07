package com.example.demo.service;

import com.example.demo.entity.Client;

import java.util.List;

public interface ClientService {
    Client save(Client client);

    void deleteById(Long id);

    Client findById(Long id);

    List<Client> findAll();
}
