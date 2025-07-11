package com.votacion.votacion.controller;

import com.votacion.votacion.model.Circuito;
import com.votacion.votacion.service.CircuitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/circuitos")
public class CircuitoController {

    @Autowired
    private CircuitoService circuitoService;

    @GetMapping
    public List<Circuito> getAll() {
        return circuitoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Circuito> getById(@PathVariable Long id) {
        return circuitoService.findById(id);
    }

    @PostMapping
    public Circuito create(@RequestBody Circuito circuito) {
        return circuitoService.save(circuito);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        circuitoService.deleteById(id);
    }
}
