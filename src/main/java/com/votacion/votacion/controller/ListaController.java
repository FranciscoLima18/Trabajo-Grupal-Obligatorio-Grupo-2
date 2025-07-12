package com.votacion.votacion.controller;

import com.votacion.votacion.dto.ListaDTO;
import com.votacion.votacion.model.Lista;
import com.votacion.votacion.model.Partido;
import com.votacion.votacion.service.ListaService;
import com.votacion.votacion.service.PartidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listas")
@RequiredArgsConstructor
public class ListaController {

    private final ListaService listaService;
    private final PartidoService partidoService;

    @GetMapping
    public List<Lista> getAll() {
        return listaService.findAll();
    }

    @PostMapping
    public Lista create(@RequestBody ListaDTO dto) {
        Partido partido = partidoService.findById(dto.getPartidoId())
            .orElseThrow(() -> new RuntimeException("Partido no encontrado"));

        Lista lista = Lista.builder()
            .partido(partido)
            .numeroLista(dto.getNumeroLista())
            .organo(dto.getOrgano())
            .orden(dto.getOrden())
            .departamento(dto.getDepartamento())
            .build();

        return listaService.save(lista);
    }
}
