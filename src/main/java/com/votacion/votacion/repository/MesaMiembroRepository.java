package com.votacion.votacion.repository;

import com.votacion.votacion.model.MesaMiembro;
import com.votacion.votacion.model.MesaMiembroId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MesaMiembroRepository extends JpaRepository<MesaMiembro, MesaMiembroId> {
}
