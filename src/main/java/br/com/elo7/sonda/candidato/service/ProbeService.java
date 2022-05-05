package br.com.elo7.sonda.candidato.service;

import br.com.elo7.sonda.candidato.model.Planet;
import br.com.elo7.sonda.candidato.model.Probe;
import br.com.elo7.sonda.candidato.repository.PlanetsRepository;
import br.com.elo7.sonda.candidato.repository.ProbesRepository;
import br.com.elo7.sonda.candidato.restapi.controller.dto.ProbeDTO;
import br.com.elo7.sonda.candidato.restapi.controller.form.InputForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
						.stream().map(probeForm -> {
							Probe probe = new Probe.Builder()
									               .from(probeForm)
									               .from(planet)
									               .build();
							probe.moveProbeWithAllCommands();
							return probe;
						}).collect(Collectors.toList());
	}

}
