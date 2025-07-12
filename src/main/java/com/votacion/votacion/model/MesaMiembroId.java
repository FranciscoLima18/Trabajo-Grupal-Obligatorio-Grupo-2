package com.votacion.votacion.model;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MesaMiembroId implements Serializable {
    private Long mesa;
    private Long ciudadano;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MesaMiembroId that)) return false;
        return Objects.equals(mesa, that.mesa) && Objects.equals(ciudadano, that.ciudadano);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mesa, ciudadano);
    }
}
