package br.com.augusto.controller.entidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "celulas")
public class Celulas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_celula;
	@Column(name = "nome_celula", nullable = false)
	private String nome_celula;
	@Column(name = "nome_anfitriao", nullable = false)
	private String nome_anfitriao;
	@Column(name = "endereco_celula", nullable = false)
	private String endereco_celula;
	@Column(name = "celula_kids", nullable = false)
	private boolean kids;

	@ManyToOne
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa;
	
	@OneToMany(mappedBy = "celula")
	private List<PessoasCelulas> pessoasCelulas;

	@OneToMany(mappedBy = "celula1")
	private List<MembroCelula> membroCelula;	

	/*@OneToMany(mappedBy = "celula2")
	private List<CelulaSemana> celulaSemana;*/

	public Celulas() {
		super();
	}

	public List<PessoasCelulas> getPessoasCelulas() {
		return pessoasCelulas;
	}

	public void setPessoasCelulas(List<PessoasCelulas> pessoasCelulas) {
		this.pessoasCelulas = pessoasCelulas;
	}

	public boolean isKids() {
		return kids;
	}

	public void setKids(boolean kids) {
		this.kids = kids;
	}

	/*public List<CelulaSemana> getCelulaSemana() {
		return celulaSemana;
	}

	public void setCelulaSemana(List<CelulaSemana> celulaSemana) {
		this.celulaSemana = celulaSemana;
	}
*/
	public List<MembroCelula> getMembroCelula() {
		return membroCelula;
	}

	public void setMembroCelula(List<MembroCelula> membroCelula) {
		this.membroCelula = membroCelula;
	}

	public Integer getId_celula() {
		return id_celula;
	}

	public void setId_celula(Integer id_celula) {
		this.id_celula = id_celula;
	}

	public String getNome_celula() {
		return nome_celula;
	}

	public void setNome_celula(String nome_celula) {
		this.nome_celula = nome_celula;
	}

	public String getNome_anfitriao() {
		return nome_anfitriao;
	}

	public void setNome_anfitriao(String nome_anfitriao) {
		this.nome_anfitriao = nome_anfitriao;
	}

	public String getEndereco_celula() {
		return endereco_celula;
	}

	public void setEndereco_celula(String endereco_celula) {
		this.endereco_celula = endereco_celula;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
