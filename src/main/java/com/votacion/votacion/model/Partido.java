package com.votacion.votacion.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "partido")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "partido_id")
    private Long partidoId;

    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre;

    @Column(name = "direccion_sede")
    private String direccionSede;
}
