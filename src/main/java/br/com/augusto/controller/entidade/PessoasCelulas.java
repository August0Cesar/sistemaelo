package br.com.augusto.controller.entidade;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pessoas_celulas")
public class PessoasCelulas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa4;
	
	@ManyToOne
	@JoinColumn(name = "id_celula")
	private Celulas celula;
	

	public PessoasCelulas() {
		super();
	}

	public Celulas getCelula() {
		return celula;
	}

	public void setCelula(Celulas celula) {
		this.celula = celula;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pessoa getPessoa4() {
		return pessoa4;
	}

	public void setPessoa4(Pessoa pessoa4) {
		this.pessoa4 = pessoa4;
	}

}
