package com.votacion.votacion.controller;

import com.votacion.votacion.dto.VotoCabeceraDTO;
import com.votacion.votacion.model.Circuito;
import com.votacion.votacion.model.Ciudadano;
import com.votacion.votacion.model.Eleccion;
import com.votacion.votacion.model.VotoCabecera;
import com.votacion.votacion.service.VotoCabeceraService;
import com.votacion.votacion.service.CiudadanoService;
import com.votacion.votacion.service.EleccionService;
import com.votacion.votacion.service.CircuitoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/votos")
@RequiredArgsConstructor
public class VotoCabeceraController {

    private final VotoCabeceraService votoCabeceraService;
    private final CiudadanoService ciudadanoService;
    private final EleccionService eleccionService;
    private final CircuitoService circuitoService;

    @GetMapping
    public List<VotoCabecera> getAll() {
        return votoCabeceraService.findAll();
    }

    @PostMapping
    public VotoCabecera create(@RequestBody VotoCabeceraDTO dto) {
        Ciudadano ciudadano = ciudadanoService.findById(dto.getCiudadanoId())
                .orElseThrow(() -> new RuntimeException("Ciudadano no encontrado"));

        Eleccion eleccion = eleccionService.findById(dto.getEleccionId())
                .orElseThrow(() -> new RuntimeException("Elección no encontrada"));

        Circuito circuito = circuitoService.findById(dto.getCircuitoId())
                .orElseThrow(() -> new RuntimeException("Circuito no encontrado"));

        VotoCabecera voto = VotoCabecera.builder()
                .ciudadano(ciudadano)
                .eleccion(eleccion)
                .circuito(circuito)
                .fechaHora(dto.getFechaHora())
                .observado(dto.isObservado())
                .estadoVoto(dto.getEstadoVoto())
                .causalAnulacion(dto.getCausalAnulacion())
                .build();

        return votoCabeceraService.save(voto);
    }
}
