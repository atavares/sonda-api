package br.com.elo7.sonda.candidato.service;

import java.util.List;
import java.util.stream.Collectors;

import br.com.elo7.sonda.candidato.restapi.controller.dto.ProbeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.annotations.VisibleForTesting;
import br.com.elo7.sonda.candidato.restapi.controller.form.InputForm;
import br.com.elo7.sonda.candidato.restapi.controller.form.ProbeForm;
import br.com.elo7.sonda.candidato.model.Command;
import br.com.elo7.sonda.candidato.model.Direction;
import br.com.elo7.sonda.candidato.model.Planet;
import br.com.elo7.sonda.candidato.model.Probe;
import br.com.elo7.sonda.candidato.persistence.Planets;
import br.com.elo7.sonda.candidato.persistence.Probes;

@Service
public class ProbeService {
	@Autowired
	private Planets planets;
	@Autowired
	private Probes probes;
	
	public List<ProbeDTO> landProbes(InputForm input) {
		Planet planet =  new Planet(input);
		planets.save(planet);
		
		List<Probe> convertedProbes = convertAndMoveProbes(input, planet);
		convertedProbes.forEach(probe -> probes.save(probe));
		
		return ProbeDTO.converterFrom(convertedProbes);
	}

	private List<Probe> convertAndMoveProbes(InputForm input, Planet planet) {
		return input.getProbes()
						.stream().map(probeDto -> {
							Probe probe = new Probe(probeDto, planet);
							probe.moveProbeWithAllCommands();
							return probe;
						}).collect(Collectors.toList());
	}
}
