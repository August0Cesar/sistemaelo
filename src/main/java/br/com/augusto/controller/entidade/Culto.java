package br.com.augusto.controller.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "culto")
public class Culto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_culto;
	@Column(name = "tema_culto", nullable = false)
	private String tema_culto;
	@Column(name = "data_culto", nullable = false)
	private Date data_culto;
	@Column(name = "membros", nullable = false)
	private int membros;
	@Column(name = "visitantes", nullable = false)
	private int visitantes;
	public Culto() {
		super();
	}
	public Integer getId_culto() {
		return id_culto;
	}
	public void setId_culto(Integer id_culto) {
		this.id_culto = id_culto;
	}
	public String getTema_culto() {
		return tema_culto;
	}
	public void setTema_culto(String tema_culto) {
		this.tema_culto = tema_culto;
	}
	public Date getData_culto() {
		return data_culto;
	}
	public void setData_culto(Date data_culto) {
		this.data_culto = data_culto;
	}
	public int getMembros() {
		return membros;
	}
	public void setMembros(int membros) {
		this.membros = membros;
	}
	public int getVisitantes() {
		return visitantes;
	}
	public void setVisitantes(int visitantes) {
		this.visitantes = visitantes;
	}
	
	
	

}
