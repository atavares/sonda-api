package br.com.elo7.sonda.candidato.restapi.controller.dto;

public class PlanetDTO {

    private long id;
    private int width;
    private int height;

    public PlanetDTO(long id, int width, int height) {
        this.id = id;
        this.width = width;
        this.height = height;
    }

    public long getId() {
        return id;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
