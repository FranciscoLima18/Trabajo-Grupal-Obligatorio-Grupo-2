package com.votacion.votacion.service;

import com.votacion.votacion.model.Candidato;
import com.votacion.votacion.repository.CandidatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CandidatoService {

    private final CandidatoRepository repository;

    public List<Candidato> findAll() {
        return repository.findAll();
    }

    public Candidato save(Candidato candidato) {
        return repository.save(candidato);
    }

    public Optional<Candidato> findById(Long id) {
        return repository.findById(id);
    }
}
