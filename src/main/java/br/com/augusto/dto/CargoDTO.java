package br.com.augusto.dto;

public class CargoDTO {
	private String lider;
	private String lider_Treinamento;
	private String supervisorSetor;
	private String supervisorArea;
	private String discipulador;

	public CargoDTO( String lider, String lider_Treinamento, String supervisorSetor, String supervisorArea,
			String discipulador) {
		super();
		this.lider = lider;
		this.lider_Treinamento = lider_Treinamento;
		this.supervisorSetor = supervisorSetor;
		this.supervisorArea = supervisorArea;
		this.discipulador = discipulador;
	}

	public CargoDTO() {
		super();

	}

	public String getLider() {
		return lider;
	}

	public void setLider(String lider) {
		this.lider = lider;
	}

	public String getLider_Treinamento() {
		return lider_Treinamento;
	}

	public void setLider_Treinamento(String lider_Treinamento) {
		this.lider_Treinamento = lider_Treinamento;
	}

	public String getSupervisorSetor() {
		return supervisorSetor;
	}

	public void setSupervisorSetor(String supervisorSetor) {
		this.supervisorSetor = supervisorSetor;
	}

	public String getSupervisorArea() {
		return supervisorArea;
	}

	public void setSupervisorArea(String supervisorArea) {
		this.supervisorArea = supervisorArea;
	}

	public String getDiscipulador() {
		return discipulador;
	}

	public void setDiscipulador(String discipulador) {
		this.discipulador = discipulador;
	}

}
