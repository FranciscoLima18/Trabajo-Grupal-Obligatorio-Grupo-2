package com.votacion.votacion.repository;

import com.votacion.votacion.model.Ciudadano;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadanoRepository extends JpaRepository<Ciudadano, Long> {
}
