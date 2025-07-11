package com.votacion.votacion.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Circuito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long circuitoId;

    @Column(nullable = false)
    private String departamento;

    @Column(nullable = false)
    private String localidad;

    private String barrio;

    @Column(nullable = false)
    private Boolean esAccesible;
}
