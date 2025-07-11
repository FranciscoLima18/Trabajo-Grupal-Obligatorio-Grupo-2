package com.votacion.votacion.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ciudadano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ciudadanoId;

    @Column(nullable = false, unique = true, length = 12)
    private String ci;

    @Column(nullable = false, unique = true, length = 12)
    private String cc;

    @Column(nullable = false, length = 200)
    private String nombreCompleto;

    @Column(nullable = false)
    private LocalDate fechaNacimiento;
}
