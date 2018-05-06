package br.com.augusto.controller.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "membro_celula")
public class MembroCelula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "id_pessoa_celula")
	private PessoaCelula pessoaCelula;

	@ManyToOne
	@JoinColumn(name = "id_celula")
	private Celulas celula1;

	public MembroCelula() {
		super();
	}

	public PessoaCelula getPessoaCelula() {
		return pessoaCelula;
	}

	public void setPessoaCelula(PessoaCelula pessoaCelula) {
		this.pessoaCelula = pessoaCelula;
	}

	public Celulas getCelula1() {
		return celula1;
	}

	public void setCelula1(Celulas celula1) {
		this.celula1 = celula1;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
