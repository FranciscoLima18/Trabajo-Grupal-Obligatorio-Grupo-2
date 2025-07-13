package com.votacion.votacion.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "mesa")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mesa_id")
    private Long mesaId;

    @ManyToOne
    @JoinColumn(name = "circuito_id", nullable = false)
    private Circuito circuito;

    @ManyToOne
    @JoinColumn(name = "estado_mesa_id", nullable = false)
    private EstadoMesa estadoMesa;

    @Column(name = "fecha_hora_cierre")
    private LocalDateTime fechaHoraCierre;

    @Column(name = "numero", nullable = false)
    private Integer numero;
}
