package com.votacion.votacion.controller;

import com.votacion.votacion.model.AsignacionCircuito;
import com.votacion.votacion.model.AsignacionCircuitoId;
import com.votacion.votacion.service.AsignacionCircuitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.votacion.votacion.dto.AsignacionCircuitoDTO;

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
public ResponseEntity<AsignacionCircuito> create(@RequestBody AsignacionCircuitoDTO dto) {
    AsignacionCircuito asignacion = service.createFromIds(dto.getCiudadanoId(), dto.getCircuitoId());
    return ResponseEntity.ok(asignacion);
}


    @DeleteMapping
    public void delete(@RequestBody AsignacionCircuitoId id) {
        service.delete(id);
    }
}
