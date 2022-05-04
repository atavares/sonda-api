package br.com.elo7.sonda.candidato.service;

import br.com.elo7.sonda.candidato.model.Command;
import br.com.elo7.sonda.candidato.model.Direction;
import br.com.elo7.sonda.candidato.model.Planet;
import br.com.elo7.sonda.candidato.model.Probe;
import br.com.elo7.sonda.candidato.repository.PlanetsRepository;
import br.com.elo7.sonda.candidato.repository.ProbesRepository;
import br.com.elo7.sonda.candidato.restapi.controller.dto.ProbeDTO;
import br.com.elo7.sonda.candidato.restapi.controller.form.InputForm;
import br.com.elo7.sonda.candidato.restapi.controller.form.ProbeForm;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ProbeServiceTest {

    @Mock
    private PlanetsRepository planetsRepository;
    @Mock
    private ProbesRepository probesRepository;
    @InjectMocks
    private ProbeService probeService;

    @Test
    public void should_return_list_probes_when_convert_and_move_probes() {

        ProbeForm pf1 = new ProbeForm();
        pf1.setX(1);
        pf1.setY(2);
        pf1.setDirection(Direction.N);
        pf1.setCommands("LMLMLMLMM");

        InputForm input = new InputForm();
        input.setHeight(10);
        input.setWidth(10);
        input.setProbes(Arrays.asList(pf1));

        Mockito.when(planetsRepository.save(Mockito.any(Planet.class))).thenReturn(new Planet());
        Mockito.when(probesRepository.save(Mockito.any(Probe.class))).thenReturn(new Probe.Builder().build());

        List<ProbeDTO> probes = probeService.landProbes(input);

        assertEquals(1, probes.size());
        assertEquals(1, probes.get(0).getX());
        assertEquals(3, probes.get(0).getY());
        assertEquals(Direction.N, probes.get(0).getDirection());
        assertEquals(10, probes.get(0).getPlanet().getWidth());
        assertEquals(10, probes.get(0).getPlanet().getHeight());
    }


}
