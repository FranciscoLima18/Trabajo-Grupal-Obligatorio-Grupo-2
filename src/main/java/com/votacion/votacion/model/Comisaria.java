package com.votacion.votacion.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "comisaria")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comisaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comisaria_id")
    private Long comisariaId;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "departamento", nullable = false)
    private String departamento;
}
