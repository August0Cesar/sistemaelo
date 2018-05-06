package br.com.augusto.controller.entidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity

@Table(name = "batismo")
public class Batismo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_batismo;
	@Column(name = "batizado_por", updatable = false)
	private String batizado_por;
	@Column(name = "status_batismo", nullable = false)
	private boolean status_batismo;

	// relacionamento com a tabela Pessoa
	@OneToMany(mappedBy = "batismo")
	private List<Pessoa> pessoa;

	public Batismo() {
		super();
	}

	public Integer getId_batismo() {
		return id_batismo;
	}

	public void setId_batismo(Integer id_batismo) {
		this.id_batismo = id_batismo;
	}

	public String getBatizado_por() {
		return batizado_por;
	}

	public void setBatizado_por(String batizado_por) {
		this.batizado_por = batizado_por;
	}

	public boolean isStatus_batismo() {
		return status_batismo;
	}

	public void setStatus_batismo(boolean status_batismo) {
		this.status_batismo = status_batismo;
	}

	public List<Pessoa> getPessoa() {
		return pessoa;
	}

	public void setPessoa(List<Pessoa> pessoa) {
		this.pessoa = pessoa;
	}

}
