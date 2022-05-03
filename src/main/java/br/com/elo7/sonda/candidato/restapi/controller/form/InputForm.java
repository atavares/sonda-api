package br.com.elo7.sonda.candidato.restapi.controller.form;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class InputForm {
	@NotNull(message = "Width é obrigatório")
	private Integer width;
	@NotNull(message = "Height é obrigatório")
	private Integer height;
	@Valid
	@NotEmpty(message = "Probes são obrigatórios")
	private List<ProbeForm> probes;

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public List<ProbeForm> getProbes() {
		return probes;
	}

	public void setProbes(List<ProbeForm> probes) {
		this.probes = probes;
	}
}
