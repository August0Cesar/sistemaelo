package br.com.augusto.controller.entidade;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "aula")
public class Aula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_aula;
	@Column(name = "nome_aula", nullable = false)
	private String nome_aula;
	@Column(name = "comentario", nullable = false)
	private String comentario;
	@Column(name = "status_presente", nullable = false)
	private boolean status_presente;
	@Column(name = "data_aula", nullable = false)
	private Date data_aula;

	@ManyToOne
	@JoinColumn(name = "id_aluno")
	private Alunos aluno;

	public Aula() {
		super();
	}

	public Integer getId_aula() {
		return id_aula;
	}

	public void setId_aula(Integer id_aula) {
		this.id_aula = id_aula;
	}

	public String getNome_aula() {
		return nome_aula;
	}

	public void setNome_aula(String nome_aula) {
		this.nome_aula = nome_aula;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public boolean isStatus_presente() {
		return status_presente;
	}

	public void setStatus_presente(boolean status_presente) {
		this.status_presente = status_presente;
	}

	public Date getData_aula() {
		return data_aula;
	}

	public void setData_aula(Date data_aula) {
		this.data_aula = data_aula;
	}

	public Alunos getAluno() {
		return aluno;
	}

	public void setAluno(Alunos aluno) {
		this.aluno = aluno;
	}
	

}
