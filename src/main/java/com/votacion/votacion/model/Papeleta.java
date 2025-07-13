package com.votacion.votacion.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "papeleta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Papeleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "papeleta_id")
    private Long papeletaId;

    @ManyToOne
    @JoinColumn(name = "eleccion_id", nullable = false)
    private Eleccion eleccion;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "color", nullable = false)
    private String color;
}
