package com.votacion.votacion.dto;

public class PapeletaDTO {
    private String tipo;
    private String color;
    private Long eleccionId;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getEleccionId() {
        return eleccionId;
    }

    public void setEleccionId(Long eleccionId) {
        this.eleccionId = eleccionId;
    }
}
