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
@Table(name = "turma")
public class Turma {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_turma;
	@Column(name = "nome_turma", nullable = false)
	private String nome_turma;
	@Column(name = "data_inicio", nullable = false)
	private Date data_inicio;
	
	@ManyToOne
	@JoinColumn(name = "id_aluno")
	private Alunos aluno;

	public Turma() {
		super();
	}

	public Integer getId_turma() {
		return id_turma;
	}

	public void setId_turma(Integer id_turma) {
		this.id_turma = id_turma;
	}

	public String getNome_turma() {
		return nome_turma;
	}

	public void setNome_turma(String nome_turma) {
		this.nome_turma = nome_turma;
	}

	public Date getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}

	public Alunos getAluno() {
		return aluno;
	}

	public void setAluno(Alunos aluno) {
		this.aluno = aluno;
	}

}
