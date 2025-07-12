package com.votacion.votacion.dto;

import lombok.Data;

@Data
public class ListaDTO {
    private Long partidoId;
    private Integer numeroLista;
    private String organo;
    private Integer orden;
    private String departamento;
}
