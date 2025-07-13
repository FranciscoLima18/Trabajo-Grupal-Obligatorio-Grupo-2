package com.votacion.votacion.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "eleccion_candidato")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EleccionCandidato {

    @EmbeddedId
    private EleccionCandidatoId id;

    @ManyToOne
    @MapsId("eleccionId")
    @JoinColumn(name = "eleccion_id", nullable = false)
    private Eleccion eleccion;

    @ManyToOne
    @MapsId("candidatoId")
    @JoinColumn(name = "candidato_id", nullable = false)
    private Candidato candidato;

    @ManyToOne
    @JoinColumn(name = "partido_id", nullable = false)
    private Partido partido;

    @ManyToOne
    @JoinColumn(name = "lista_id")
    private Lista lista;
}
