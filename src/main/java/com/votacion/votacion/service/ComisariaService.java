package com.votacion.votacion.service;

import com.votacion.votacion.model.Comisaria;
import com.votacion.votacion.repository.ComisariaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComisariaService {

    private final ComisariaRepository comisariaRepository;

    public ComisariaService(ComisariaRepository comisariaRepository) {
        this.comisariaRepository = comisariaRepository;
    }

    public List<Comisaria> findAll() {
        return comisariaRepository.findAll();
    }

    public Comisaria save(Comisaria comisaria) {
        return comisariaRepository.save(comisaria);
    }

    public void delete(Long id) {
        comisariaRepository.deleteById(id);
    }
}
