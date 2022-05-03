package br.com.elo7.sonda.candidato.restapi.controller.dto;

import java.util.List;

public class StandardErrorDTO {
    private long timestamp;
    private int code;

    private List<FieldErrorDTO> errors;

    public StandardErrorDTO(long timestamp, int code, List<FieldErrorDTO> errors) {
        this.timestamp = timestamp;
        this.code = code;
        this.errors = errors;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public int getCode() {
        return code;
    }

    public List<FieldErrorDTO> getErrors() {
        return errors;
    }
}
