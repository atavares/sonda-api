package br.com.elo7.sonda.candidato.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProbeTest {

    private Probe probe;

    @Test
    public void should_change_probe_direction_from_N_To_W_when_receive_the_command_L() {
        probe = new Probe.Builder().with(Direction.N).build();
        probe.applyCommandToProbe(Command.L);
        assertEquals(Direction.W, probe.getDirection());
    }

    @Test
    public void should_change_probe_direction_from_W_To_S_when_receive_the_command_L() {
        probe = new Probe.Builder().with(Direction.W).build();
        probe.applyCommandToProbe(Command.L);
        assertEquals(Direction.S, probe.getDirection());
    }

    @Test
    public void should_change_probe_direction_from_S_To_E_when_receive_the_command_L() {
        probe = new Probe.Builder().with(Direction.S).build();
        probe.applyCommandToProbe(Command.L);
        assertEquals(Direction.E, probe.getDirection());
    }

    @Test
    public void should_change_probe_direction_from_E_To_N_when_receive_the_command_L() {
        probe = new Probe.Builder().with(Direction.E).build();
        probe.applyCommandToProbe(Command.L);
        assertEquals(Direction.N, probe.getDirection());
    }

    @Test
    public void should_change_probe_direction_from_N_To_E_when_receive_the_command_R() {
        probe = new Probe.Builder().with(Direction.N).build();
        probe.applyCommandToProbe(Command.R);
        assertEquals(Direction.E, probe.getDirection());
    }

    @Test
    public void should_change_probe_direction_from_E_To_S_when_receive_the_command_R() {
        probe = new Probe.Builder().with(Direction.E).build();
        probe.applyCommandToProbe(Command.R);
        assertEquals(Direction.S, probe.getDirection());
    }

    @Test
    public void should_change_probe_direction_from_S_To_W_when_receive_the_command_R() {
        probe = new Probe.Builder().with(Direction.S).build();
        probe.applyCommandToProbe(Command.R);
        assertEquals(Direction.W, probe.getDirection());
    }

    @Test
    public void should_change_probe_direction_from_W_To_N_when_receive_the_command_R() {
        probe = new Probe.Builder().with(Direction.W).build();
        probe.applyCommandToProbe(Command.R);
        assertEquals(Direction.N, probe.getDirection());
    }

    @Test
    public void should_change_probe_position_from_1_1_N_To_1_2_N_when_receive_the_command_M() {
        probe = new Probe.Builder()
                         .with(Direction.N)
                         .withX(1)
                         .withY(1)
                         .build();

        probe.applyCommandToProbe(Command.M);
        assertEquals(2, probe.getY());
        assertEquals(1, probe.getX());
        assertEquals(Direction.N, probe.getDirection());
    }

    @Test
    public void should_change_probe_position_from_1_1_S_To_1_0_S_when_receive_the_command_M() {
        probe = new Probe.Builder()
                .with(Direction.S)
                .withX(1)
                .withY(1)
                .build();

        probe.applyCommandToProbe(Command.M);
        assertEquals(0, probe.getY());
        assertEquals(1, probe.getX());
        assertEquals(Direction.S, probe.getDirection());
    }

    @Test
    public void should_change_probe_position_from_1_1_W_To_0_1_W_when_receive_the_command_M() {
        probe = new Probe.Builder()
                .with(Direction.W)
                .withX(1)
                .withY(1)
                .build();

        probe.applyCommandToProbe(Command.M);
        assertEquals(0, probe.getX());
        assertEquals(1, probe.getY());
        assertEquals(Direction.W, probe.getDirection());
    }

    @Test
    public void should_change_probe_position_from_1_1_E_To_2_1_E_when_receive_the_command_M() {
        probe = new Probe.Builder()
                .with(Direction.E)
                .withX(1)
                .withY(1)
                .build();

        probe.applyCommandToProbe(Command.M);
        assertEquals(2, probe.getX());
        assertEquals(1, probe.getY());
        assertEquals(Direction.E, probe.getDirection());
    }
}
