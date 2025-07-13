package com.votacion.votacion.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "candidato")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidato_id")
    private Long candidatoId;

    @Column(name = "ci", nullable = false, unique = true, length = 12)
    private String ci;

    @Column(name = "cc", nullable = false, unique = true, length = 12)
    private String cc;

    @Column(name = "nombre_completo", nullable = false, length = 200)
    private String nombreCompleto;
}
