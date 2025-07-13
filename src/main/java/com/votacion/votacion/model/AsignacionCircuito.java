package com.votacion.votacion.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "asignacion_circuito")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(AsignacionCircuitoId.class)
public class AsignacionCircuito {

    @Id
    @ManyToOne
    @JoinColumn(name = "ciudadano_id", nullable = false)
    private Ciudadano ciudadano;

    @Id
    @ManyToOne
    @JoinColumn(name = "circuito_id", nullable = false)
    private Circuito circuito;
}
