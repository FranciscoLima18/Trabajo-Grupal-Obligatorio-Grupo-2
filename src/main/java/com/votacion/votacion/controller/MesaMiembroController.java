package com.votacion.votacion.controller;

import com.votacion.votacion.dto.MesaMiembroDTO;
import com.votacion.votacion.model.Ciudadano;
import com.votacion.votacion.model.Mesa;
import com.votacion.votacion.model.MesaMiembro;
import com.votacion.votacion.model.MesaMiembroId;
import com.votacion.votacion.repository.CiudadanoRepository;
import com.votacion.votacion.repository.MesaRepository;
import com.votacion.votacion.service.MesaMiembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mesa-miembros")
@CrossOrigin
public class MesaMiembroController {

    @Autowired
    private MesaMiembroService mesaMiembroService;

    @Autowired
    private MesaRepository mesaRepository;

    @Autowired
    private CiudadanoRepository ciudadanoRepository;

    @GetMapping
    public List<MesaMiembro> getAll() {
        return mesaMiembroService.findAll();
    }

    @GetMapping("/{mesaId}/{ciudadanoId}")
    public Optional<MesaMiembro> getById(@PathVariable Long mesaId, @PathVariable Long ciudadanoId) {
        return mesaMiembroService.findById(new MesaMiembroId(mesaId, ciudadanoId));
    }

    @PostMapping
    public ResponseEntity<MesaMiembro> create(@RequestBody MesaMiembroDTO dto) {
        Mesa mesa = mesaRepository.findById(dto.getMesaId())
                .orElseThrow(() -> new RuntimeException("Mesa no encontrada"));

        Ciudadano ciudadano = ciudadanoRepository.findById(dto.getCiudadanoId())
                .orElseThrow(() -> new RuntimeException("Ciudadano no encontrado"));

        MesaMiembro miembro = new MesaMiembro();
        miembro.setMesa(mesa);
        miembro.setCiudadano(ciudadano);
        miembro.setRol(dto.getRol());

        return ResponseEntity.ok(mesaMiembroService.save(miembro));
    }

    @DeleteMapping("/{mesaId}/{ciudadanoId}")
    public void delete(@PathVariable Long mesaId, @PathVariable Long ciudadanoId) {
        mesaMiembroService.deleteById(new MesaMiembroId(mesaId, ciudadanoId));
    }
}
