package com.votacion.votacion.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "agente_policia", uniqueConstraints = @UniqueConstraint(columnNames = {"ci", "cc"}))
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgentePolicia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agente_id")
    private Long agenteId;

    @Column(name = "ci", nullable = false, length = 12)
    private String ci;

    @Column(name = "cc", nullable = false, length = 12)
    private String cc;

    @Column(name = "nombre_completo", nullable = false, length = 200)
    private String nombreCompleto;

    @ManyToOne
    @JoinColumn(name = "comisaria_id", nullable = false)
    private Comisaria comisaria;

    @ManyToOne
    @JoinColumn(name = "establecimiento_id", nullable = false)
    private Establecimiento establecimiento;
}
