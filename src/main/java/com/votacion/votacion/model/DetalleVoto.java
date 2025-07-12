package com.votacion.votacion.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "detalle_voto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetalleVoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detalle_id")
    private Long detalleId;

    @ManyToOne
    @JoinColumn(name = "voto_id", nullable = false)
    private VotoCabecera voto;

    @ManyToOne
    @JoinColumn(name = "lista_id")
    private Lista lista;

    @ManyToOne
    @JoinColumn(name = "papeleta_id")
    private Papeleta papeleta;
}
