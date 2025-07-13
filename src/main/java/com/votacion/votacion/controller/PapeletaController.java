package com.votacion.votacion.controller;

import com.votacion.votacion.dto.PapeletaDTO;
import com.votacion.votacion.model.Eleccion;
import com.votacion.votacion.model.Papeleta;
import com.votacion.votacion.repository.EleccionRepository;
import com.votacion.votacion.service.PapeletaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/papeletas")
@CrossOrigin
public class PapeletaController {

    private final PapeletaService papeletaService;
    private final EleccionRepository eleccionRepository;

    public PapeletaController(PapeletaService papeletaService, EleccionRepository eleccionRepository) {
        this.papeletaService = papeletaService;
        this.eleccionRepository = eleccionRepository;
    }

    @GetMapping
    public List<Papeleta> getAll() {
        return papeletaService.findAll();
    }

    @PostMapping
    public ResponseEntity<Papeleta> create(@RequestBody PapeletaDTO dto) {
        Eleccion eleccion = eleccionRepository.findById(dto.getEleccionId())
            .orElseThrow(() -> new RuntimeException("Elección no encontrada"));
    
        Papeleta papeleta = new Papeleta();
        papeleta.setEleccion(eleccion);
        papeleta.setTipo(dto.getTipo());
        papeleta.setColor(dto.getColor());
    
        return ResponseEntity.ok(papeletaService.save(papeleta));
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<Papeleta> getById(@PathVariable Long id) {
        return papeletaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        papeletaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
