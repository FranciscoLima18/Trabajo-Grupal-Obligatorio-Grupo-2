package com.votacion.votacion.controller;

import com.votacion.votacion.model.Establecimiento;
import com.votacion.votacion.service.EstablecimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/establecimientos")
public class EstablecimientoController {

    @Autowired
    private EstablecimientoService establecimientoService;

    @GetMapping
    public List<Establecimiento> getAll() {
        return establecimientoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Establecimiento> getById(@PathVariable Long id) {
        return establecimientoService.findById(id);
    }

    @PostMapping
    public Establecimiento create(@RequestBody Establecimiento establecimiento) {
        return establecimientoService.save(establecimiento);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        establecimientoService.deleteById(id);
    }
}
