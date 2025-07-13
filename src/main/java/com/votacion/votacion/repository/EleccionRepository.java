package com.votacion.votacion.repository;

import com.votacion.votacion.model.Eleccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EleccionRepository extends JpaRepository<Eleccion, Long> {
}
