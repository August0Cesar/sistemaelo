package br.com.augusto.controller.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tadeu")
public class Tadeu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_tadeu;
	@Column(name = "data", nullable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date data;
	@Column(name = "comentario", nullable = false)
	private String comentario;
	@Column(name = "total_dizimo")
	private float total_dizimo;
	@Column(name = "total_oferta")
	private float total_oferta;
	@Column(name = "total_pessoas")
	private int total_pessoas;


	public Tadeu() {
		super();
	}
	

	public int getTotal_pessoas() {
		return total_pessoas;
	}


	public void setTotal_pessoas(int total_pessoas) {
		this.total_pessoas = total_pessoas;
	}


	public float getTotal_dizimo() {
		return total_dizimo;
	}


	public void setTotal_dizimo(float total_dizimo) {
		this.total_dizimo = total_dizimo;
	}


	public float getTotal_oferta() {
		return total_oferta;
	}


	public void setTotal_oferta(float total_oferta) {
		this.total_oferta = total_oferta;
	}


	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Integer getId_tadeu() {
		return id_tadeu;
	}

	public void setId_tadeu(Integer id_tadeu) {
		this.id_tadeu = id_tadeu;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
