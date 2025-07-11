package com.votacion.votacion.service;

import com.votacion.votacion.model.Eleccion;
import com.votacion.votacion.repository.EleccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EleccionService {

    @Autowired
    private EleccionRepository eleccionRepository;

    public List<Eleccion> findAll() {
        return eleccionRepository.findAll();
    }

    public Optional<Eleccion> findById(Long id) {
        return eleccionRepository.findById(id);
    }

    public Eleccion save(Eleccion eleccion) {
        return eleccionRepository.save(eleccion);
    }

    public void deleteById(Long id) {
        eleccionRepository.deleteById(id);
    }
}
