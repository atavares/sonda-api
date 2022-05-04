package br.com.elo7.sonda.candidato.model;

import br.com.elo7.sonda.candidato.restapi.controller.form.ProbeForm;
import com.google.common.annotations.VisibleForTesting;

import javax.persistence.*;

@Entity
public class Probe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int x;
	private int y;
	@Enumerated(EnumType.STRING)
	private Direction direction;
	@ManyToOne
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

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Planet getPlanet() {
		return planet;
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

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public void moveProbeWithAllCommands() {
		for (char command : commands.toCharArray()) {
			applyCommandToProbe(Command.valueOf(String.valueOf(command)));
		}
	}

	@VisibleForTesting
	void applyCommandToProbe(Command command) {
		switch (command) {
			case R:
				turnProbeRight();
				break;
			case L:
				turnProbeLeft();
				break;
			case M:
				moveProbeForward();
				break;
		}
	}

	private void turnProbeLeft() {
		switch (direction) {
			case N:
				direction = Direction.W;
				break;
			case W:
				direction = Direction.S;
				break;
			case S:
				direction = Direction.E;
				break;
			default:
				direction = Direction.N;
		}
	}

	private void turnProbeRight() {
		switch (direction) {
			case N:
				direction = Direction.E;
				break;
			case E:
				direction = Direction.S;
				break;
			case S:
				direction = Direction.W;
				break;
			default:
				direction = Direction.N;
		}
	}

	private void moveProbeForward() {
		switch (direction) {
			case N:
				y++;
				break;
			case W:
				x--;
				break;
			case S:
				y--;
				break;
			case E:
				x++;
				break;
		}
	}



}
