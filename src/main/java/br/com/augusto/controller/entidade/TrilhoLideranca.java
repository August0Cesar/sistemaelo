package br.com.augusto.controller.entidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "trilho_lideranca")
public class TrilhoLideranca {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_trilho_lideranca;
	@Column(name = "nome_trilho_lideranca", nullable = false)
	private String nome_trilho_lideranca;
	@Column(name = "trilho", nullable = false)
	private String trilho;

	@ManyToMany(mappedBy = "trilhoLideranca")
	private List<Pessoa> pessoa;
	
	@OneToMany(mappedBy = "trilhoLideranca")
	private List<ListTrilho> listTrilho;

	public TrilhoLideranca() {
		super();
	}

	public List<ListTrilho> getListTrilho() {
		return listTrilho;
	}

	public void setListTrilho(List<ListTrilho> listTrilho) {
		this.listTrilho = listTrilho;
	}

	public List<Pessoa> getPessoa() {
		return pessoa;
	}

	public void setPessoa(List<Pessoa> pessoa) {
		this.pessoa = pessoa;
	}

	public Integer getId_trilho_lideranca() {
		return id_trilho_lideranca;
	}

	public void setId_trilho_lideranca(Integer id_trilho_lideranca) {
		this.id_trilho_lideranca = id_trilho_lideranca;
	}

	public String getNome_trilho_lideranca() {
		return nome_trilho_lideranca;
	}

	public void setNome_trilho_lideranca(String nome_trilho_lideranca) {
		this.nome_trilho_lideranca = nome_trilho_lideranca;
	}

	public String getTrilho() {
		return trilho;
	}

	public void setTrilho(String trilho) {
		this.trilho = trilho;
	}

}
