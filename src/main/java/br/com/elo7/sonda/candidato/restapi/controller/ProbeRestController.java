package br.com.elo7.sonda.candidato.restapi.controller;

import java.net.URI;
import java.util.List;

import br.com.elo7.sonda.candidato.restapi.controller.dto.ProbeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.elo7.sonda.candidato.restapi.controller.form.InputForm;
import br.com.elo7.sonda.candidato.model.Probe;
import br.com.elo7.sonda.candidato.service.ProbeService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@Controller
@RequestMapping("/planet-with-probes")
public class ProbeRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProbeRestController.class);
	@Autowired
	private ProbeService probeService;

	@PostMapping
    public ResponseEntity<List<ProbeDTO>> register(@RequestBody @Valid InputForm inputForm) {
		LOGGER.info("register planet with probe to width {} height {} probes {}", inputForm.getWidth(), inputForm.getHeight(), inputForm.getProbes());
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequestUri()
																 .build()
				                                                 .toUri())
							 .body(probeService.landProbes(inputForm));
    }
}
