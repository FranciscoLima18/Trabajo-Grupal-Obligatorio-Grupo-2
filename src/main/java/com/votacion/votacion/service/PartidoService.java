package com.votacion.votacion.service;

import com.votacion.votacion.model.Partido;
import com.votacion.votacion.repository.PartidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PartidoService {

    private final PartidoRepository repository;

    public List<Partido> findAll() {
        return repository.findAll();
    }

    public Optional<Partido> findById(Long id) {
        return repository.findById(id);
    }

    public Partido save(Partido partido) {
        return repository.save(partido);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
