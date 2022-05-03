package br.com.elo7.sonda.candidato.model;

import br.com.elo7.sonda.candidato.restapi.controller.form.ProbeForm;
import com.google.common.annotations.VisibleForTesting;

public class Probe {
	private int id;
	private int x;
	private int y;
	private char direction;
	private Planet planet;
	private String commands;

	public Probe() {
	}

	public Probe(ProbeForm probeDto, Planet planet) {
		this.planet = planet;
		this.x = probeDto.getX();
		this.y = probeDto.getY();
		this.direction = probeDto.getDirection();
		this.commands = probeDto.getCommands();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Planet getPlanet() {
		return planet;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public char getDirection() {
		return direction;
	}

	public void moveProbeWithAllCommands() {
		for (char command : commands.toCharArray()) {
			applyCommandToProbe(command);
		}
	}

	@VisibleForTesting
	void applyCommandToProbe(char command) {
		switch (command) {
			case Command.R:
				turnProbeRight();
				break;
			case Command.L:
				turnProbeLeft();
				break;
			case Command.M:
				moveProbeForward();
				break;
		}
	}

	private void turnProbeLeft() {
		char newDirection = Direction.N;
		switch (direction) {
			case Direction.N:
				newDirection = Direction.W;
				break;
			case Direction.W:
				newDirection = Direction.S;
				break;
			case Direction.S:
				newDirection = Direction.E;
				break;
			case Direction.E:
				newDirection = Direction.N;
				break;
		}
		direction = newDirection;
	}

	private void turnProbeRight() {
		char newDirection = Direction.N;
		switch (direction) {
			case Direction.N:
				newDirection = Direction.E;
				break;
			case Direction.E:
				newDirection = Direction.S;
				break;
			case Direction.S:
				newDirection = Direction.W;
				break;
			case Direction.W:
				newDirection = Direction.N;
				break;
		}
		direction = newDirection;
	}

	private void moveProbeForward() {
		int newX = x;
		int newY = y;
		switch (direction) {
			case Direction.N:
				newY++;
				break;
			case Direction.W:
				newX--;
				break;
			case Direction.S:
				newY--;
				break;
			case Direction.E:
				newX++;
				break;
		}
		x = newX;
		y = newY;
	}



}
