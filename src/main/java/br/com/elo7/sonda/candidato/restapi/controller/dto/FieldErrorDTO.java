package br.com.elo7.sonda.candidato.restapi.controller.dto;

public class FieldErrorDTO {
    private String name;
    private String error;

    public FieldErrorDTO(String name, String error) {
        this.name = name;
        this.error = error;
    }

    public String getName() {
        return name;
    }

    public String getError() {
        return error;
    }
}
