package br.com.elo7.sonda.candidato.model;

import br.com.elo7.sonda.candidato.restapi.controller.form.ProbeForm;

public class Probe {
	private int id;
	private int x;
	private int y;
	private char direction;
	private Planet planet;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public char getDirection() {
		return direction;
	}
	public void setDirection(char direction) {
		this.direction = direction;
	}
	public Planet getPlanet() {
		return planet;
	}
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}

	public static Probe converterFrom(ProbeForm probeDto, Planet planet) {
		Probe probe = new Probe();
		probe.setPlanet(planet);
		probe.setX(probeDto.getX());
		probe.setY(probeDto.getY());
		probe.setDirection(probeDto.getDirection());
		return probe;
	}
}
