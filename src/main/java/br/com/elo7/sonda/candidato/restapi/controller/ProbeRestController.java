package br.com.elo7.sonda.candidato.restapi.controller;

import java.net.URI;
import java.util.List;

import br.com.elo7.sonda.candidato.restapi.controller.dto.ProbeDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import br.com.elo7.sonda.candidato.restapi.controller.form.InputForm;
import br.com.elo7.sonda.candidato.model.Probe;
import br.com.elo7.sonda.candidato.service.ProbeService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/planet-with-probes")
public class ProbeRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProbeRestController.class);
	@Autowired
	private ProbeService probeService;

	@Operation(summary = "Launch probe in planet")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Probe hurled",
					content = { @Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "400", description = "Invalid parameter sent",
					content = @Content)})
	@PostMapping
    public ResponseEntity<List<ProbeDTO>> register(@RequestBody @Valid InputForm inputForm) {
		LOGGER.info("register planet with probe to width {} height {} probes {}", inputForm.getWidth(), inputForm.getHeight(), inputForm.getProbes());
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequestUri()
																 .build()
				                                                 .toUri())
							 .body(probeService.landProbes(inputForm));
    }
}
