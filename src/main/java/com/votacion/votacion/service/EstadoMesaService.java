package com.votacion.votacion.service;

import com.votacion.votacion.model.EstadoMesa;
import com.votacion.votacion.repository.EstadoMesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoMesaService {

    @Autowired
    private EstadoMesaRepository estadoMesaRepository;

    public List<EstadoMesa> findAll() {
        return estadoMesaRepository.findAll();
    }

    public Optional<EstadoMesa> findById(Long id) {
        return estadoMesaRepository.findById(id);
    }

    public EstadoMesa save(EstadoMesa estadoMesa) {
        return estadoMesaRepository.save(estadoMesa);
    }

    public void deleteById(Long id) {
        estadoMesaRepository.deleteById(id);
    }
}
