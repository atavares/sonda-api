package br.com.elo7.sonda.candidato.restapi.controller.dto;

import br.com.elo7.sonda.candidato.model.Direction;
import br.com.elo7.sonda.candidato.model.Planet;
import br.com.elo7.sonda.candidato.model.Probe;

import java.util.List;
import java.util.stream.Collectors;

public class ProbeDTO {

    private int id;
    private int x;
    private int y;
    private Direction direction;
    private PlanetDTO planet;

    public ProbeDTO(int id, int x, int y, Direction direction, PlanetDTO planet) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.planet = planet;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public PlanetDTO getPlanet() {
        return planet;
    }

    public static List<ProbeDTO> converterFrom(List<Probe> probes){
        return probes.stream()
                     .map(p-> new ProbeDTO(p.getId(),
                                           p.getX(),
                                           p.getY(),p.getDirection(),
                                           new PlanetDTO(p.getPlanet().getId(), p.getPlanet().getWidth(), p.getPlanet().getHeight())))
                     .collect(Collectors.toList());
    }
}
