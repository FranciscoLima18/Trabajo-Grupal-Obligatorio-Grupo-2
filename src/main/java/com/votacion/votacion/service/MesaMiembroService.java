package com.votacion.votacion.service;

import com.votacion.votacion.model.MesaMiembro;
import com.votacion.votacion.model.MesaMiembroId;
import com.votacion.votacion.repository.MesaMiembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MesaMiembroService {

    @Autowired
    private MesaMiembroRepository mesaMiembroRepository;

    public List<MesaMiembro> findAll() {
        return mesaMiembroRepository.findAll();
    }

    public Optional<MesaMiembro> findById(MesaMiembroId id) {
        return mesaMiembroRepository.findById(id);
    }

    public MesaMiembro save(MesaMiembro mesaMiembro) {
        return mesaMiembroRepository.save(mesaMiembro);
    }

    public void deleteById(MesaMiembroId id) {
        mesaMiembroRepository.deleteById(id);
    }
}
