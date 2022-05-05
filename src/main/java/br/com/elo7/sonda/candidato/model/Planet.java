package br.com.elo7.sonda.candidato.model;

import br.com.elo7.sonda.candidato.restapi.controller.form.InputForm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Planet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int width;
	private int height;

	public Planet() {
	}

	public Planet(InputForm input) {
		this.height = input.getHeight();
		this.width = input.getWidth();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Planet planet = (Planet) o;
		return id == planet.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	public long getId() {
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

}
