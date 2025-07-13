package com.votacion.votacion.service;

import com.votacion.votacion.model.DetalleVoto;
import com.votacion.votacion.repository.DetalleVotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetalleVotoService {

    private final DetalleVotoRepository repository;

    public List<DetalleVoto> findAll() {
        return repository.findAll();
    }

    public DetalleVoto save(DetalleVoto detalleVoto) {
        return repository.save(detalleVoto);
    }
}
