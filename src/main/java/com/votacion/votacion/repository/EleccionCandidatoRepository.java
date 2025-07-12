package com.votacion.votacion.repository;

import com.votacion.votacion.model.EleccionCandidato;
import com.votacion.votacion.model.EleccionCandidatoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EleccionCandidatoRepository extends JpaRepository<EleccionCandidato, EleccionCandidatoId> {
}
