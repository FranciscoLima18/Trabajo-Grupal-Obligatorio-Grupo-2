package com.votacion.votacion.service;

import com.votacion.votacion.model.EleccionCandidato;
import com.votacion.votacion.repository.EleccionCandidatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EleccionCandidatoService {

    private final EleccionCandidatoRepository repository;

    public List<EleccionCandidato> findAll() {
        return repository.findAll();
    }

    public EleccionCandidato save(EleccionCandidato eleccionCandidato) {
        return repository.save(eleccionCandidato);
    }
}
