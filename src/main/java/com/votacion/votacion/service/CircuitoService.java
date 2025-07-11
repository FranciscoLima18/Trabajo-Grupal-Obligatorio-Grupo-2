package com.votacion.votacion.service;

import com.votacion.votacion.model.Circuito;
import com.votacion.votacion.repository.CircuitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CircuitoService {

    @Autowired
    private CircuitoRepository circuitoRepository;

    public List<Circuito> findAll() {
        return circuitoRepository.findAll();
    }

    public Optional<Circuito> findById(Long id) {
        return circuitoRepository.findById(id);
    }

    public Circuito save(Circuito circuito) {
        return circuitoRepository.save(circuito);
    }

    public void deleteById(Long id) {
        circuitoRepository.deleteById(id);
    }
}
