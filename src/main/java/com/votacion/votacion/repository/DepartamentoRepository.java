package com.votacion.votacion.repository;

import com.votacion.votacion.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    // Spring genera los métodos básicos automáticamente
}
