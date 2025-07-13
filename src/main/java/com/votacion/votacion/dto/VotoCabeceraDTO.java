package com.votacion.votacion.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VotoCabeceraDTO {
    private Long ciudadanoId;
    private Long eleccionId;
    private Long circuitoId;
    private LocalDateTime fechaHora;
    private boolean observado;
    private String estadoVoto;
    private String causalAnulacion;
}
