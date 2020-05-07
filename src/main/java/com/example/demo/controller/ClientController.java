package com.example.demo.controller;

import com.example.demo.service.ClientService;
import com.example.demo.controller.dto.ClientDTO;
import com.example.demo.controller.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client/")
public class ClientController {

    final
    ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public List<ClientDTO> findAll() {
        return ClientMapper.INSTANCE.toDto(clientService.findAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ClientDTO findById(@PathVariable Long id) {
        return ClientMapper.INSTANCE.toDto(clientService.findById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/", produces = "application/json")
    public ClientDTO create(@RequestBody ClientDTO client) {
        if (client.getId() != null) throw new IllegalArgumentException();
        return ClientMapper.INSTANCE.toDto(clientService.save(ClientMapper.INSTANCE.toEntity(client)));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public ClientDTO update(@RequestBody ClientDTO client, @PathVariable Long id) {
        client.setId(id);
        return ClientMapper.INSTANCE.toDto(clientService.save(ClientMapper.INSTANCE.toEntity(client)));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        clientService.deleteById(id);
    }
}
