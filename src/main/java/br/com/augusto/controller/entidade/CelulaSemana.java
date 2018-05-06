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

@Entity
@Table(name = "celula_semana")
public class CelulaSemana {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "semana", nullable = false)
	private Integer semana;
	@Column(name = "data_celula", nullable = false)
	private Date data_celula;
	@Column(name = "tot_criancas", nullable = false)
	private int tot_criancas;
	@Column(name = "tot_visitantes", nullable = false)
	private int tot_visitantes;
	@Column(name = "tot_adultos", nullable = false)
	private int tot_adultos;
	@Column(name = "oferta", nullable = false)
	private float oferta;
	@Column(name = "tot_pessoas_culto", nullable = false)
	private int tot_pessoas_culto;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "id_pessoa_celula") private PessoaCelula pessoaCelula;
	 */
	@ManyToOne
	@JoinColumn(name = "id_celula")
	private Celulas celula2;

	public CelulaSemana() {
		super();
	}

	/*
	 * public PessoaCelula getPessoaCelula() { return pessoaCelula; }
	 * 
	 * 
	 * public void setPessoaCelula(PessoaCelula pessoaCelula) {
	 * this.pessoaCelula = pessoaCelula; }
	 */

	public Celulas getCelula2() {
		return celula2;
	}

	public void setCelula2(Celulas celula2) {
		this.celula2 = celula2;
	}

	public int getTot_visitantes() {
		return tot_visitantes;
	}

	public void setTot_visitantes(int tot_visitantes) {
		this.tot_visitantes = tot_visitantes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSemana() {
		return semana;
	}

	public void setSemana(Integer semana) {
		this.semana = semana;
	}

	public Date getData_celula() {
		return data_celula;
	}

	public void setData_celula(Date data_celula) {
		this.data_celula = data_celula;
	}

	public int getTot_criancas() {
		return tot_criancas;
	}

	public void setTot_criancas(int tot_criancas) {
		this.tot_criancas = tot_criancas;
	}

	public int getTot_adultos() {
		return tot_adultos;
	}

	public void setTot_adultos(int tot_adultos) {
		this.tot_adultos = tot_adultos;
	}

	public float getOferta() {
		return oferta;
	}

	public void setOferta(float oferta) {
		this.oferta = oferta;
	}

	public int getTot_pessoas_culto() {
		return tot_pessoas_culto;
	}

	public void setTot_pessoas_culto(int tot_pessoas_culto) {
		this.tot_pessoas_culto = tot_pessoas_culto;
	}

}
