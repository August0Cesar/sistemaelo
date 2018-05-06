package br.com.augusto.controller.entidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "chegada_igreja")
public class ChegadaIgreja {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_chegada_igreja;
	@Column(name = "nome_chegada")
	private String nome_chegada;

	// relacionamento com a tabela chegada igreja
	@OneToMany(mappedBy = "chegadaIgreja")
	private List<Pessoa> pessoa;

	public ChegadaIgreja() {
		super();
	}

	public List<Pessoa> getPessoa() {
		return pessoa;
	}

	public void setPessoa(List<Pessoa> pessoa) {
		this.pessoa = pessoa;
	}

	public Integer getId() {
		return id_chegada_igreja;
	}

	public void setId(Integer id) {
		this.id_chegada_igreja = id;
	}

	public String getNome_chegada() {
		return nome_chegada;
	}

	public void setNome_chegada(String nome_chegada) {
		this.nome_chegada = nome_chegada;
	}

}
