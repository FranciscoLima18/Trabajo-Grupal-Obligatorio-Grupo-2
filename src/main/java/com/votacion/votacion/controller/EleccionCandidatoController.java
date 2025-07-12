package com.votacion.votacion.controller;

import com.votacion.votacion.dto.EleccionCandidatoDTO;
import com.votacion.votacion.model.EleccionCandidato;
import com.votacion.votacion.model.EleccionCandidatoId;
import com.votacion.votacion.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eleccion-candidato")
@RequiredArgsConstructor
public class EleccionCandidatoController {

    private final EleccionCandidatoService service;
    private final EleccionService eleccionService;
    private final CandidatoService candidatoService;
    private final PartidoService partidoService;
    private final ListaService listaService;

    @GetMapping
    public List<EleccionCandidato> getAll() {
        return service.findAll();
    }

    @PostMapping
    public EleccionCandidato create(@RequestBody EleccionCandidatoDTO dto) {

        var eleccion = eleccionService.findById(dto.getEleccionId())
                .orElseThrow(() -> new RuntimeException("Elección no encontrada"));

        var candidato = candidatoService.findById(dto.getCandidatoId())
                .orElseThrow(() -> new RuntimeException("Candidato no encontrado"));

        var partido = partidoService.findById(dto.getPartidoId())
                .orElseThrow(() -> new RuntimeException("Partido no encontrado"));

        var lista = dto.getListaId() != null
                ? listaService.findById(dto.getListaId())
                    .orElseThrow(() -> new RuntimeException("Lista no encontrada"))
                : null;

        var id = new EleccionCandidatoId(dto.getEleccionId(), dto.getCandidatoId());

        var eleccionCandidato = EleccionCandidato.builder()
                .id(id)
                .eleccion(eleccion)
                .candidato(candidato)
                .partido(partido)
                .lista(lista)
                .build();

        return service.save(eleccionCandidato);
    }
}
