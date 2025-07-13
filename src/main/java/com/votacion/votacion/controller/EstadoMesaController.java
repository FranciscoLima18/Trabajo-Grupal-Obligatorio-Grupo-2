package com.votacion.votacion.controller;

import com.votacion.votacion.model.EstadoMesa;
import com.votacion.votacion.service.EstadoMesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estado-mesas")
public class EstadoMesaController {

    @Autowired
    private EstadoMesaService estadoMesaService;

    @GetMapping
    public List<EstadoMesa> getAll() {
        return estadoMesaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<EstadoMesa> getById(@PathVariable Long id) {
        return estadoMesaService.findById(id);
    }

    @PostMapping
    public EstadoMesa create(@RequestBody EstadoMesa estadoMesa) {
        return estadoMesaService.save(estadoMesa);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        estadoMesaService.deleteById(id);
    }
}
