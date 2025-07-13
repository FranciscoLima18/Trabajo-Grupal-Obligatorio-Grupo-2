package com.votacion.votacion.repository;

import com.votacion.votacion.model.Papeleta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PapeletaRepository extends JpaRepository<Papeleta, Long> {
}
