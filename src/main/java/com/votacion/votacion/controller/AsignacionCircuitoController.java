package com.votacion.votacion.controller;

import com.votacion.votacion.model.AsignacionCircuito;
import com.votacion.votacion.model.AsignacionCircuitoId;
import com.votacion.votacion.service.AsignacionCircuitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignaciones")
public class AsignacionCircuitoController {

    @Autowired
    private AsignacionCircuitoService service;

    @GetMapping
    public List<AsignacionCircuito> getAll() {
        return service.findAll();
    }

    @PostMapping
    public AsignacionCircuito create(@RequestBody AsignacionCircuito asignacion) {
        return service.save(asignacion);
    }

    @DeleteMapping
    public void delete(@RequestBody AsignacionCircuitoId id) {
        service.delete(id);
    }
}
