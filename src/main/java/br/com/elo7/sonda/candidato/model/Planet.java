package br.com.elo7.sonda.candidato.model;

import br.com.elo7.sonda.candidato.restapi.controller.form.InputForm;

public class Planet {
	private int id;
	private int width;
	private int height;
	
	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Planet) {
			return ((Planet) obj).id == this.id;
		}
		return false;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	public static Planet converterFrom(InputForm input) {
		Planet planet = new Planet();
		planet.setHeight(input.getHeight());
		planet.setWidth(input.getWidth());
		return planet;
	}

}
