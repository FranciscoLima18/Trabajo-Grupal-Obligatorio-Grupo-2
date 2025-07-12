package com.votacion.votacion.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lista", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"partido_id", "numero_lista"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lista_id")
    private Long listaId;

    @ManyToOne
    @JoinColumn(name = "partido_id", nullable = false)
    private Partido partido;

    @Column(name = "numero_lista", nullable = false)
    private Integer numeroLista;

    @Column(name = "organo", nullable = false)
    private String organo;

    @Column(name = "orden", nullable = false)
    private Integer orden;

    @Column(name = "departamento")
    private String departamento;
}
