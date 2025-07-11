package com.votacion.votacion.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Eleccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eleccionId;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private String tipo; // presidencial, municipal, plebiscito, referendum, ballotage
}
