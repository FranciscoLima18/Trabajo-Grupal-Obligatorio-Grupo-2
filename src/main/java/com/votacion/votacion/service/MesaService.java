package com.votacion.votacion.service;

import com.votacion.votacion.model.Mesa;
import com.votacion.votacion.repository.MesaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesaService {

    private final MesaRepository mesaRepository;

    public MesaService(MesaRepository mesaRepository) {
        this.mesaRepository = mesaRepository;
    }

    public List<Mesa> findAll() {
        return mesaRepository.findAll();
    }

    public Mesa save(Mesa mesa) {
        return mesaRepository.save(mesa);
    }

    public Mesa findById(Long id) {
        return mesaRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        mesaRepository.deleteById(id);
    }
}
