package com.votacion.votacion.controller;

import com.votacion.votacion.model.Eleccion;
import com.votacion.votacion.service.EleccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/elecciones")
public class EleccionController {

    @Autowired
    private EleccionService eleccionService;

    @GetMapping
    public List<Eleccion> getAll() {
        return eleccionService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Eleccion> getById(@PathVariable Long id) {
        return eleccionService.findById(id);
    }

    @PostMapping
    public Eleccion create(@RequestBody Eleccion eleccion) {
        return eleccionService.save(eleccion);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        eleccionService.deleteById(id);
    }
}