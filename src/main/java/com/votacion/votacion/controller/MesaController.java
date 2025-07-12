package com.votacion.votacion.controller;

import com.votacion.votacion.dto.MesaDTO;
import com.votacion.votacion.model.Circuito;
import com.votacion.votacion.model.EstadoMesa;
import com.votacion.votacion.model.Mesa;
import com.votacion.votacion.repository.CircuitoRepository;
import com.votacion.votacion.repository.EstadoMesaRepository;
import com.votacion.votacion.service.MesaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/mesas")
@CrossOrigin
public class MesaController {

    private final MesaService mesaService;
    private final CircuitoRepository circuitoRepository;
    private final EstadoMesaRepository estadoMesaRepository;

    public MesaController(MesaService mesaService,
                          CircuitoRepository circuitoRepository,
                          EstadoMesaRepository estadoMesaRepository) {
        this.mesaService = mesaService;
        this.circuitoRepository = circuitoRepository;
        this.estadoMesaRepository = estadoMesaRepository;
    }

    @GetMapping
    public List<Mesa> getAll() {
        return mesaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mesa> getById(@PathVariable Long id) {
        Mesa mesa = mesaService.findById(id);
        return mesa != null ? ResponseEntity.ok(mesa) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Mesa> create(@RequestBody MesaDTO dto) {
        Circuito circuito = circuitoRepository.findById(dto.getCircuitoId())
                .orElseThrow(() -> new RuntimeException("Circuito no encontrado"));
        EstadoMesa estadoMesa = estadoMesaRepository.findById(dto.getEstadoMesaId())
                .orElseThrow(() -> new RuntimeException("Estado de mesa no encontrado"));
    
        Mesa mesa = new Mesa();
        mesa.setCircuito(circuito);
        mesa.setEstadoMesa(estadoMesa);
        mesa.setNumero(dto.getNumero()); // <- 🔥 línea agregada
    
        if (dto.getFechaHoraCierre() != null) {
            mesa.setFechaHoraCierre(LocalDateTime.parse(dto.getFechaHoraCierre()));
        }
    
        return ResponseEntity.ok(mesaService.save(mesa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        mesaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
