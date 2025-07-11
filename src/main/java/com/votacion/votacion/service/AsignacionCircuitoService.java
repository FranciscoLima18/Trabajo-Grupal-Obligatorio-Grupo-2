package com.votacion.votacion.service;

import com.votacion.votacion.model.AsignacionCircuito;
import com.votacion.votacion.model.AsignacionCircuitoId;
import com.votacion.votacion.repository.AsignacionCircuitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignacionCircuitoService {

    @Autowired
    private AsignacionCircuitoRepository asignacionCircuitoRepository;

    public List<AsignacionCircuito> findAll() {
        return asignacionCircuitoRepository.findAll();
    }

    public AsignacionCircuito save(AsignacionCircuito asignacion) {
        return asignacionCircuitoRepository.save(asignacion);
    }

    public void delete(AsignacionCircuitoId id) {
        asignacionCircuitoRepository.deleteById(id);
    }
}
