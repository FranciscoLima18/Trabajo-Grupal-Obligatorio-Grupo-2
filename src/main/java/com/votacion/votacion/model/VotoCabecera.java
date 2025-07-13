package com.votacion.votacion.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "voto_cabecera", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"ciudadano_id", "eleccion_id"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VotoCabecera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voto_id")
    private Long votoId;

    @ManyToOne
    @JoinColumn(name = "ciudadano_id", nullable = false)
    private Ciudadano ciudadano;

    @ManyToOne
    @JoinColumn(name = "eleccion_id", nullable = false)
    private Eleccion eleccion;

    @ManyToOne
    @JoinColumn(name = "circuito_id", nullable = false)
    private Circuito circuito;

    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora = LocalDateTime.now();

    @Column(name = "observado", nullable = false)
    private boolean observado = false;

    @Column(name = "estado_voto", nullable = false)
    private String estadoVoto;

    @Column(name = "causal_anulacion")
    private String causalAnulacion;
}
