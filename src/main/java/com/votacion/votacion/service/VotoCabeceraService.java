package com.votacion.votacion.service;

import com.votacion.votacion.model.VotoCabecera;
import com.votacion.votacion.repository.VotoCabeceraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VotoCabeceraService {

    private final VotoCabeceraRepository repository;

    public List<VotoCabecera> findAll() {
        return repository.findAll();
    }

    public VotoCabecera save(VotoCabecera voto) {
        return repository.save(voto);
    }

    public Optional<VotoCabecera> findById(Long id) {
        return repository.findById(id);
    }
}
