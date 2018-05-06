package br.com.augusto.controller.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "aluno_modulo")
public class AlunoModulo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nota_modulo", nullable = false)
	private Integer nota_modulo;
	
	@ManyToOne
	@JoinColumn(name = "id_aluno")
	private Alunos aluno;

	@ManyToOne
	@JoinColumn(name = "id_modulo_escola")
	private ModuloEscola moduloEscola;
	

	public AlunoModulo() {
		super();
	}
	

	public Integer getNota_modulo() {
		return nota_modulo;
	}


	public void setNota_modulo(Integer nota_modulo) {
		this.nota_modulo = nota_modulo;
	}


	public Alunos getAluno() {
		return aluno;
	}

	public void setAluno(Alunos aluno) {
		this.aluno = aluno;
	}

	public ModuloEscola getModuloEscola() {
		return moduloEscola;
	}

	public void setModuloEscola(ModuloEscola moduloEscola) {
		this.moduloEscola = moduloEscola;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
