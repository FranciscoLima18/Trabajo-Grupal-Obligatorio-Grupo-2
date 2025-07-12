package com.votacion.votacion.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "estado_mesa")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstadoMesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estado_mesa_id")
    private Long estadoMesaId;

    @Column(nullable = false, unique = true)
    private String descripcion;
}
