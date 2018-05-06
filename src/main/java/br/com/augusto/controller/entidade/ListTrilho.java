package br.com.augusto.controller.entidade;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "list_trilha")
public class ListTrilho {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "status", nullable = false)
	private boolean status;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_cadastro", nullable = false)
	private Date data_cadastro;

	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa3;

	@ManyToOne
	@JoinColumn(name = "id_trilho_lideranca")
	private TrilhoLideranca trilhoLideranca;

	public ListTrilho() {
		super();
	}

	public Date getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Pessoa getPessoa3() {
		return pessoa3;
	}

	public void setPessoa3(Pessoa pessoa3) {
		this.pessoa3 = pessoa3;
	}

	public TrilhoLideranca getTrilhoLideranca() {
		return trilhoLideranca;
	}

	public void setTrilhoLideranca(TrilhoLideranca trilhoLideranca) {
		this.trilhoLideranca = trilhoLideranca;
	}
	
	
	

}
