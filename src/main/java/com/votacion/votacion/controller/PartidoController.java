package com.votacion.votacion.controller;

import com.votacion.votacion.model.Partido;
import com.votacion.votacion.service.PartidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partidos")
@RequiredArgsConstructor
public class PartidoController {

    private final PartidoService service;

    @GetMapping
    public List<Partido> getAll() {
        return service.findAll();
    }

    @PostMapping
    public Partido create(@RequestBody Partido partido) {
        return service.save(partido);
    }
}
