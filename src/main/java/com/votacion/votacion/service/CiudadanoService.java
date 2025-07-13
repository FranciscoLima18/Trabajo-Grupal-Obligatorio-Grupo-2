package com.votacion.votacion.service;

import com.votacion.votacion.model.Ciudadano;
import com.votacion.votacion.repository.CiudadanoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CiudadanoService {

    private final CiudadanoRepository ciudadanoRepository;

    public List<Ciudadano> findAll() {
        return ciudadanoRepository.findAll();
    }

    public Optional<Ciudadano> findById(Long id) {
        return ciudadanoRepository.findById(id);
    }

    public Ciudadano save(Ciudadano ciudadano) {
        return ciudadanoRepository.save(ciudadano);
    }

    public void deleteById(Long id) {
        ciudadanoRepository.deleteById(id);
    }
}
