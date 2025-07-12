package com.votacion.votacion.controller;

import com.votacion.votacion.model.Candidato;
import com.votacion.votacion.service.CandidatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidatos")
@RequiredArgsConstructor
public class CandidatoController {

    private final CandidatoService service;

    @GetMapping
    public List<Candidato> getAll() {
        return service.findAll();
    }

    @PostMapping
    public Candidato create(@RequestBody Candidato candidato) {
        return service.save(candidato);
    }
}
