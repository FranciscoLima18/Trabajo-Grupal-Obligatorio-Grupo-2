package com.votacion.votacion.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "mesa_miembro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(MesaMiembroId.class)
public class MesaMiembro {

    @Id
    @ManyToOne
    @JoinColumn(name = "mesa_id", nullable = false)
    private Mesa mesa;

    @Id
    @ManyToOne
    @JoinColumn(name = "ciudadano_id", nullable = false)
    private Ciudadano ciudadano;

    @Column(nullable = false)
    private String rol;

    private String organismo;
}
