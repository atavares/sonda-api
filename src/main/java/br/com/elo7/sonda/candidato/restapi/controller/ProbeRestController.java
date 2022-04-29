package br.com.elo7.sonda.candidato.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.elo7.sonda.candidato.restapi.controller.form.InputForm;
import br.com.elo7.sonda.candidato.model.Probe;
import br.com.elo7.sonda.candidato.service.ProbeService;

@Controller
@RequestMapping("/planet-with-probes")
public class ProbeRestController {
	@Autowired
	private ProbeService probeService;

	@PostMapping
    public ResponseEntity<List<Probe>> register(@RequestBody InputForm inputForm) {
		return ResponseEntity.ok(probeService.landProbes(inputForm));
    }
}
