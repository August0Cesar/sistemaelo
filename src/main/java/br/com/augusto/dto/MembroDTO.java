package br.com.augusto.dto;

import java.util.List;

public class MembroDTO {
	private String nome;
	private String endereco;
	private String phoneWhats;
	private String phoneRedidencia;
	private String casado;
	private String nomeConjugue;
	private String naturalidade;
	private String dataNascimento;
	private String nomePai;
	private String nomeMae;
	private String pertenceCelula;
	private String chegadaIgreja;
	private String batizadoPor;
	private String[]  cargo;

	public MembroDTO(String nome, String endereco, String phoneWhats, String phoneRedidencia, String casado,
			String nomeConjugue, String naturalidade, String dataNascimento, String nomePai, String nomeMae,
			String pertenceCelula, String chegadaIgreja, String batizadoPor, String[] cargo) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.phoneWhats = phoneWhats;
		this.phoneRedidencia = phoneRedidencia;
		this.casado = casado;
		this.nomeConjugue = nomeConjugue;
		this.naturalidade = naturalidade;
		this.dataNascimento = dataNascimento;
		this.nomePai = nomePai;
		this.nomeMae = nomeMae;
		this.pertenceCelula = pertenceCelula;
		this.chegadaIgreja = chegadaIgreja;
		this.batizadoPor = batizadoPor;
		this.cargo = cargo;
	}

	public MembroDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getPhoneWhats() {
		return phoneWhats;
	}

	public void setPhoneWhats(String phoneWhats) {
		this.phoneWhats = phoneWhats;
	}

	public String getPhoneRedidencia() {
		return phoneRedidencia;
	}

	public void setPhoneRedidencia(String phoneRedidencia) {
		this.phoneRedidencia = phoneRedidencia;
	}

	public String getCasado() {
		return casado;
	}

	public void setCasado(String casado) {
		this.casado = casado;
	}

	public String getNomeConjugue() {
		return nomeConjugue;
	}

	public void setNomeConjugue(String nomeConjugue) {
		this.nomeConjugue = nomeConjugue;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getPertenceCelula() {
		return pertenceCelula;
	}

	public void setPertenceCelula(String pertenceCelula) {
		this.pertenceCelula = pertenceCelula;
	}

	public String getChegadaIgreja() {
		return chegadaIgreja;
	}

	public void setChegadaIgreja(String chegadaIgreja) {
		this.chegadaIgreja = chegadaIgreja;
	}

	public String getBatizadoPor() {
		return batizadoPor;
	}

	public void setBatizadoPor(String batizadoPor) {
		this.batizadoPor = batizadoPor;
	}

	public String[] getCargo() {
		return cargo;
	}

	public void setCargo(String[] cargo) {
		this.cargo = cargo;
	}

}
