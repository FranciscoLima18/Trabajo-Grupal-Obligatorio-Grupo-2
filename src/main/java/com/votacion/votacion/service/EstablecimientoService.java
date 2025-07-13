package com.votacion.votacion.service;

import com.votacion.votacion.model.Establecimiento;
import com.votacion.votacion.repository.EstablecimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstablecimientoService {

    @Autowired
    private EstablecimientoRepository establecimientoRepository;

    public List<Establecimiento> findAll() {
        return establecimientoRepository.findAll();
    }

    public Optional<Establecimiento> findById(Long id) {
        return establecimientoRepository.findById(id);
    }

    public Establecimiento save(Establecimiento establecimiento) {
        return establecimientoRepository.save(establecimiento);
    }

    public void deleteById(Long id) {
        establecimientoRepository.deleteById(id);
    }
}
