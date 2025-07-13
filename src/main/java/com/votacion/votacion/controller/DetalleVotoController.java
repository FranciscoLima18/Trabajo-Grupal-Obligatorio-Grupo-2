package com.votacion.votacion.controller;

import com.votacion.votacion.dto.DetalleVotoDTO;
import com.votacion.votacion.model.*;
import com.votacion.votacion.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalle-votos")
@RequiredArgsConstructor
public class DetalleVotoController {

    private final DetalleVotoService detalleVotoService;
    private final VotoCabeceraService votoCabeceraService;
    private final ListaService listaService;
    private final PapeletaService papeletaService;

    @GetMapping
    public List<DetalleVoto> getAll() {
        return detalleVotoService.findAll();
    }

    @PostMapping
    public DetalleVoto create(@RequestBody DetalleVotoDTO dto) {
        VotoCabecera voto = votoCabeceraService.findById(dto.getVotoId())
                .orElseThrow(() -> new RuntimeException("Voto no encontrado"));
        Lista lista = listaService.findById(dto.getListaId())
                .orElse(null); // puede ser null
        Papeleta papeleta = papeletaService.findById(dto.getPapeletaId())
                .orElse(null); // puede ser null

        DetalleVoto detalle = DetalleVoto.builder()
                .voto(voto)
                .lista(lista)
                .papeleta(papeleta)
                .build();

        return detalleVotoService.save(detalle);
    }
}
