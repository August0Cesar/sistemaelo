package br.com.augusto.controller.entidade;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "dizimo_oferta")
public class DizimoOferta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_dizimo_oferta;
	@Column(name = "dizimo", nullable = false)
	private boolean dizimo;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_dizimo_oferta", nullable = false)
	private Date data_dizimo_oferta;
	@Column(name = "valor", nullable = false)
	private float valor;

	@ManyToMany
	@JoinTable(name = "pessoa_dizimo_oferta")
	private List<Pessoa> pessoa;

	public DizimoOferta() {
		super();
	}

	public Integer getId_dizimo_oferta() {
		return id_dizimo_oferta;
	}

	public void setId_dizimo_oferta(Integer id_dizimo_oferta) {
		this.id_dizimo_oferta = id_dizimo_oferta;
	}

	public boolean isDizimo() {
		return dizimo;
	}

	public void setDizimo(boolean dizimo) {
		this.dizimo = dizimo;
	}

	public Date getData_dizimo_oferta() {
		return data_dizimo_oferta;
	}

	public void setData_dizimo_oferta(Date data_dizimo_oferta) {
		this.data_dizimo_oferta = data_dizimo_oferta;
	}

	public List<Pessoa> getPessoa() {
		return pessoa;
	}

	public void setPessoa(List<Pessoa> pessoa) {
		this.pessoa = pessoa;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

}
