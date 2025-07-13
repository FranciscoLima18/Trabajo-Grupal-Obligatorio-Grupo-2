package com.votacion.votacion.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Establecimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long establecimientoId;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String tipo; // Escuela, Liceo, Universidad, etc.

    private String ubicacion;
}
