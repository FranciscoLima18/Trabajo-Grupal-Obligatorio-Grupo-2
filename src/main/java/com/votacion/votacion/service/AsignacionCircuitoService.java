package com.votacion.votacion.service;

import com.votacion.votacion.model.AsignacionCircuito;
import com.votacion.votacion.model.AsignacionCircuitoId;
import com.votacion.votacion.model.Ciudadano;
import com.votacion.votacion.model.Circuito;
import com.votacion.votacion.repository.AsignacionCircuitoRepository;
import com.votacion.votacion.repository.CiudadanoRepository;
import com.votacion.votacion.repository.CircuitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignacionCircuitoService {

    @Autowired
    private AsignacionCircuitoRepository asignacionCircuitoRepository;

    @Autowired
    private CiudadanoRepository ciudadanoRepository;

    @Autowired
    private CircuitoRepository circuitoRepository;

    public List<AsignacionCircuito> findAll() {
        return asignacionCircuitoRepository.findAll();
    }

    public AsignacionCircuito save(AsignacionCircuito asignacion) {
        return asignacionCircuitoRepository.save(asignacion);
    }

    public void delete(AsignacionCircuitoId id) {
        asignacionCircuitoRepository.deleteById(id);
    }

    // ✅ Nuevo método para crear asignación a partir de IDs
    public AsignacionCircuito createFromIds(Long ciudadanoId, Long circuitoId) {
        Ciudadano ciudadano = ciudadanoRepository.findById(ciudadanoId)
                .orElseThrow(() -> new RuntimeException("Ciudadano no encontrado con ID: " + ciudadanoId));

        Circuito circuito = circuitoRepository.findById(circuitoId)
                .orElseThrow(() -> new RuntimeException("Circuito no encontrado con ID: " + circuitoId));

        AsignacionCircuito asignacion = new AsignacionCircuito(ciudadano, circuito);
        return asignacionCircuitoRepository.save(asignacion);
    }
}
