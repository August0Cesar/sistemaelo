package br.com.augusto.controller.entidade;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cargo")
public class Cargo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_cargo;
	private String nome_cargo;
	
	@ManyToMany(mappedBy = "cargo")
	private List<Pessoa> pessoa;

	public Cargo() {
		super();
	}
	

	public Integer getId_cargo() {
		return id_cargo;
	}


	public void setId_cargo(Integer id_cargo) {
		this.id_cargo = id_cargo;
	}


	public List<Pessoa> getPessoa() {
		return pessoa;
	}


	public void setPessoa(List<Pessoa> pessoa) {
		this.pessoa = pessoa;
	}


	public Integer getId_telefone() {
		return id_cargo;
	}

	public void setId_telefone(Integer id_telefone) {
		this.id_cargo = id_telefone;
	}

	public String getNome_cargo() {
		return nome_cargo;
	}

	public void setNome_cargo(String nome_cargo) {
		this.nome_cargo = nome_cargo;
	}

}
