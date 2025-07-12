package com.votacion.votacion.dto;

import lombok.Data;

@Data
public class EleccionCandidatoDTO {
    private Long eleccionId;
    private Long candidatoId;
    private Long partidoId;
    private Long listaId;
}
