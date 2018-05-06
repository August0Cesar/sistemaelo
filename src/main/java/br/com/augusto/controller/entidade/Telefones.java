package br.com.augusto.controller.entidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "telefones")
public class Telefones {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_telefone;
	private String tel_residencia;
	private String tel_celular;
	private String tel_whatsapp;
	private String status;

	// relacionamento com a tabela Pessoa
	@OneToOne(mappedBy = "telefones",cascade = CascadeType.ALL)
	private Pessoa pessoa;

	public Telefones() {
		super();
	}
	

	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa( Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	public Integer getId_telefone() {
		return id_telefone;
	}

	public void setId_telefone(Integer id_telefone) {
		this.id_telefone = id_telefone;
	}

	public String getTel_residencia() {
		return tel_residencia;
	}

	public void setTel_residencia(String tel_residencia) {
		this.tel_residencia = tel_residencia;
	}

	public String getTel_celular() {
		return tel_celular;
	}

	public void setTel_celular(String tel_celular) {
		this.tel_celular = tel_celular;
	}

	public String getTel_whatsapp() {
		return tel_whatsapp;
	}

	public void setTel_whatsapp(String tel_whatsapp) {
		this.tel_whatsapp = tel_whatsapp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
