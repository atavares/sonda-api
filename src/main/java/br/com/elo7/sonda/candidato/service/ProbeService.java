package br.com.elo7.sonda.candidato.service;

import java.util.List;
import java.util.stream.Collectors;

import br.com.elo7.sonda.candidato.model.Command;
import br.com.elo7.sonda.candidato.restapi.controller.dto.ProbeDTO;
import com.google.common.annotations.VisibleForTesting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.elo7.sonda.candidato.restapi.controller.form.InputForm;
import br.com.elo7.sonda.candidato.model.Planet;
import br.com.elo7.sonda.candidato.model.Probe;
import br.com.elo7.sonda.candidato.repository.PlanetsRepository;
import br.com.elo7.sonda.candidato.repository.ProbesRepository;

@Service
public class ProbeService {

	private PlanetsRepository planetsRepository;
	private ProbesRepository probesRepository;

	@Autowired
	public ProbeService(PlanetsRepository planetsRepository,
						ProbesRepository probesRepository){
		this.planetsRepository = planetsRepository;
		this.probesRepository = probesRepository;
	}
	
	public List<ProbeDTO> landProbes(InputForm input) {
		Planet planet =  new Planet(input);
		planetsRepository.save(planet);

		List<Probe> convertedProbes = convertAndMoveProbes(input, planet);
		convertedProbes.forEach(probe -> probesRepository.save(probe));

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
