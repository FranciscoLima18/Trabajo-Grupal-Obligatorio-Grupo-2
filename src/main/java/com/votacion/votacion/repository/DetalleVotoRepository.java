package com.votacion.votacion.repository;

import com.votacion.votacion.model.DetalleVoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleVotoRepository extends JpaRepository<DetalleVoto, Long> {
}
