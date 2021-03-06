package br.com.elo7.sonda.candidato.restapi.controller.form;

import br.com.elo7.sonda.candidato.model.Direction;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProbeForm {
	@NotNull(message = "x é obrigatório")
	private Integer x;
	@NotNull(message = "y é obrigatório")
	private Integer y;
	@NotNull(message = "Direction é obrigatório")
	private Direction direction;
	@NotEmpty(message = "Commands é obrigatório")
	private String commands;

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public String getCommands() {
		return commands;
	}

	public void setCommands(String commands) {
		this.commands = commands;
	}

	@Override
	public String toString() {
		return "ProbeDTO{" +
				"x=" + x +
				", y=" + y +
				", direction=" + direction +
				", commands='" + commands + '\'' +
				'}';
	}
}
