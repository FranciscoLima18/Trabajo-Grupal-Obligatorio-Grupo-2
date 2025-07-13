package com.votacion.votacion.service;

import com.votacion.votacion.model.Lista;
import com.votacion.votacion.repository.ListaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ListaService {

    private final ListaRepository repository;

    public List<Lista> findAll() {
        return repository.findAll();
    }

    public Lista save(Lista lista) {
        return repository.save(lista);
    }

    public Optional<Lista> findById(Long id) {
        return repository.findById(id);
    }
}
