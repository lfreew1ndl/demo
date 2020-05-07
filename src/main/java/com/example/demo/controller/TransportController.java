package com.example.demo.controller;

import com.example.demo.service.TransportService;
import com.example.demo.controller.dto.TransportDTO;
import com.example.demo.controller.mapper.TransportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transport/")
public class TransportController {

    final
    TransportService transportService;

    @Autowired
    public TransportController(TransportService transportService) {
        this.transportService = transportService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public List<TransportDTO> findAll() {
        return TransportMapper.INSTANCE.toDto(transportService.findAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public TransportDTO findById(@PathVariable Long id) {
        return TransportMapper.INSTANCE.toDto(transportService.findById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/", produces = "application/json")
    public TransportDTO create(@RequestBody TransportDTO transport) {
        if (transport.getId() != null) throw new IllegalArgumentException();
        return TransportMapper.INSTANCE.toDto(transportService.save(TransportMapper.INSTANCE.toEntity(transport)));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public TransportDTO update(@RequestBody TransportDTO transport, @PathVariable Long id) {
        transport.setId(id);
        return TransportMapper.INSTANCE.toDto(transportService.save(TransportMapper.INSTANCE.toEntity(transport)));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        transportService.deleteById(id);
    }
}
