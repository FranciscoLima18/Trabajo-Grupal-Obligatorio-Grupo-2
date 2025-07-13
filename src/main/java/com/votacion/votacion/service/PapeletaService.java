package com.votacion.votacion.service;

import com.votacion.votacion.model.Papeleta;
import com.votacion.votacion.repository.PapeletaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PapeletaService {

    private final PapeletaRepository repository;

    public List<Papeleta> findAll() {
        return repository.findAll();
    }

    public Optional<Papeleta> findById(Long id) {
        return repository.findById(id);
    }

    public Papeleta save(Papeleta papeleta) {
        return repository.save(papeleta);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
