package br.com.augusto.controller.entidade;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "pessoa_celula")
public class PessoaCelula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_pessoa_celula;
	@Column(name = "nome_pessoa", nullable = false)
	private String nome_pessoa;
	@Column(name = "endereco", nullable = true)
	private String endereco;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_nascimento", nullable = true)
	private Date data_nascimento;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_cadastro", nullable = false)
	private Date data_cadastro;
	@Column(name = "membro", nullable = false)
	private boolean membro;

	@OneToMany(mappedBy = "pessoaCelula")
	private List<MembroCelula> membroCelula;
	
	/*@OneToMany(mappedBy = "pessoaCelula")
	private List<CelulaSemana> celulaSemana;
	*/
	public PessoaCelula() {
		super();
	}
	
/*
	public List<CelulaSemana> getCelulaSemana() {
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

	public Integer getId_pessoa_celula() {
		return id_pessoa_celula;
	}

	public void setId_pessoa_celula(Integer id_pessoa_celula) {
		this.id_pessoa_celula = id_pessoa_celula;
	}

	public String getNome_pessoa() {
		return nome_pessoa;
	}

	public void setNome_pessoa(String nome_pessoa) {
		this.nome_pessoa = nome_pessoa;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public Date getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public boolean isMembro() {
		return membro;
	}

	public void setMembro(boolean membro) {
		this.membro = membro;
	}

}
