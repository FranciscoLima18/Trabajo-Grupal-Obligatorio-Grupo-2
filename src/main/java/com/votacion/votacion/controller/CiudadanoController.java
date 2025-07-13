package com.votacion.votacion.controller;

import com.votacion.votacion.model.Ciudadano;
import com.votacion.votacion.service.CiudadanoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ciudadanos")
public class CiudadanoController {

    private final CiudadanoService ciudadanoService;

    public CiudadanoController(CiudadanoService ciudadanoService) {
        this.ciudadanoService = ciudadanoService;
    }

    @GetMapping
    public List<Ciudadano> getAllCiudadanos() {
        return ciudadanoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ciudadano> getCiudadanoById(@PathVariable Long id) {
        return ciudadanoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Ciudadano createCiudadano(@RequestBody Ciudadano ciudadano) {
        return ciudadanoService.save(ciudadano);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCiudadano(@PathVariable Long id) {
        ciudadanoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
