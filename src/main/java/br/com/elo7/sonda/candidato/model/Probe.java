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
	private final Planet planet;
	private final String commands;

	private Probe(Builder builder) {
		this.x = builder.x;
		this.y = builder.y;
		this.direction = builder.direction;
		this.planet = builder.planet;
		this.commands = builder.commands;
	}

	public static class Builder {
		private Planet planet;
		private int x;
		private int y;
		private Direction direction;
		private String commands;

		public Builder from(ProbeForm probeForm){
			this.x = probeForm.getX();
			this.y = probeForm.getY();
			this.direction = probeForm.getDirection();
			this.commands = probeForm.getCommands();
			return this;
		}
		public Builder from(Planet planet){
			this.planet = planet;
			return this;
		}
		public Builder with(Direction direction){
			this.direction = direction;
			return this;
		}
		public Builder withX(int x){
			this.x = x;
			return this;
		}
		public Builder withY(int y){
			this.y = y;
			return this;
		}
		public Probe build() {
			return new Probe(this);
		}

	}

	public long getId() {
		return id;
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


	public Direction getDirection() {
		return direction;
	}


	public void moveProbeWithAllCommands() {
		for (char command : commands.toCharArray()) {
			applyCommandToProbe(Command.valueOf(String.valueOf(command)));
		}
	}

	@VisibleForTesting
	void applyCommandToProbe(Command command) {
		switch (command) {
			case R -> turnProbeRight();
			case L -> turnProbeLeft();
			case M -> moveProbeForward();
		}
	}

	private void turnProbeLeft() {
		switch (direction) {
			case N -> direction = Direction.W;
			case W -> direction = Direction.S;
			case S -> direction = Direction.E;
			default -> direction = Direction.N;
		}
	}

	private void turnProbeRight() {
		switch (direction) {
			case N -> direction = Direction.E;
			case E -> direction = Direction.S;
			case S -> direction = Direction.W;
			default -> direction = Direction.N;
		}
	}

	private void moveProbeForward() {
		switch (direction) {
			case N -> y++;
			case W -> x--;
			case S -> y--;
			case E -> x++;
		}
	}



}
