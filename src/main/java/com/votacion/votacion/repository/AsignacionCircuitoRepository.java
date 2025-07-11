package com.votacion.votacion.repository;

import com.votacion.votacion.model.AsignacionCircuito;
import com.votacion.votacion.model.AsignacionCircuitoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignacionCircuitoRepository extends JpaRepository<AsignacionCircuito, AsignacionCircuitoId> {
}
