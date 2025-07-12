package com.votacion.votacion.dto;

import lombok.Data;

@Data
public class MesaDTO {
    private Long circuitoId;
    private Long estadoMesaId;
    private String fechaHoraCierre;
    private Integer numero;
}
