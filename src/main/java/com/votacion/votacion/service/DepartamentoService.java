package com.votacion.votacion.service;

import com.votacion.votacion.model.Departamento;
import com.votacion.votacion.repository.DepartamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    private final DepartamentoRepository departamentoRepository;

    public DepartamentoService(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    public List<Departamento> obtenerTodos() {
        return departamentoRepository.findAll();
    }

    public Optional<Departamento> obtenerPorId(Long id) {
        return departamentoRepository.findById(id);
    }

    public Departamento crear(Departamento depto) {
        return departamentoRepository.save(depto);
    }

    public void eliminar(Long id) {
        departamentoRepository.deleteById(id);
    }

    public Departamento actualizar(Long id, Departamento datosNuevos) {
        return departamentoRepository.findById(id).map(depto -> {
            depto.setNombre(datosNuevos.getNombre());
            return departamentoRepository.save(depto);
        }).orElseThrow(() -> new RuntimeException("Departamento no encontrado"));
    }
}
