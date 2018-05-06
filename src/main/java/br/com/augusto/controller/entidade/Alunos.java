package br.com.augusto.controller.entidade;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "alunos")
public class Alunos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_aluno;

	@OneToOne
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa;

	@OneToMany(mappedBy = "aluno")
	private List<Aula> aula;

	@OneToMany(mappedBy = "aluno")
	private List<Turma> turma;

	@OneToMany(mappedBy = "aluno")
	private List<AlunoModulo> alunoModulo;

	public Alunos() {
		super();
	}

	public List<AlunoModulo> getAlunoModulo() {
		return alunoModulo;
	}

	public void setAlunoModulo(List<AlunoModulo> alunoModulo) {
		this.alunoModulo = alunoModulo;
	}

	public List<Aula> getAula() {
		return aula;
	}

	public void setAula(List<Aula> aula) {
		this.aula = aula;
	}

	public List<Turma> getTurma() {
		return turma;
	}

	public void setTurma(List<Turma> turma) {
		this.turma = turma;
	}

	public Integer getId_aluno() {
		return id_aluno;
	}

	public void setId_aluno(Integer id_aluno) {
		this.id_aluno = id_aluno;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
