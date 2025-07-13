package com.votacion.votacion.model;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignacionCircuitoId implements Serializable {
    private Long ciudadano;
    private Long circuito;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AsignacionCircuitoId)) return false;
        AsignacionCircuitoId that = (AsignacionCircuitoId) o;
        return Objects.equals(ciudadano, that.ciudadano) &&
               Objects.equals(circuito, that.circuito);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ciudadano, circuito);
    }
}
