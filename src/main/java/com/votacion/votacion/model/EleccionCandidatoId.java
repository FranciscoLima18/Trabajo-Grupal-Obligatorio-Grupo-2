package com.votacion.votacion.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EleccionCandidatoId implements Serializable {

    @Column(name = "eleccion_id")
    private Long eleccionId;

    @Column(name = "candidato_id")
    private Long candidatoId;
}
