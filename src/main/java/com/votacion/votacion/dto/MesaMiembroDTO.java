package com.votacion.votacion.dto;

import lombok.Data;

@Data
public class MesaMiembroDTO {
    private Long mesaId;
    private Long ciudadanoId;
    private String rol;
}
