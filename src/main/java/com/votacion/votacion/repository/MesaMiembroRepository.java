package com.votacion.votacion.repository;

import com.votacion.votacion.model.MesaMiembro;
import com.votacion.votacion.model.MesaMiembroId;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MesaMiembroRepository extends JpaRepository<MesaMiembro, MesaMiembroId> {
    List<MesaMiembro> findByCiudadano_CiudadanoId(Long ciudadanoId);
}
