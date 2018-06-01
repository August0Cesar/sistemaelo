package br.com.augusto.controller.entidade;

import java.math.BigDecimal;
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

	@Column(name = "tot_membros", nullable = false)
	private int tot_membros;

	@Column(name = "tot_criancas", nullable = false)
	private int tot_criancas;

	@Column(name = "tot_visitantes", nullable = false)
	private int tot_visitantes;

	@Column(name = "tot_pessoas_celula", nullable = false)
	private int tot_pessoas_celula;

	@Column(name = "oferta", nullable = false, precision = 8, scale = 4)
	private BigDecimal oferta;

	@Column(name = "tot_pessoas_culto", nullable = false)
	private int tot_pessoas_culto;

	@Column(name = "tot_pessoas_tadel", nullable = false)
	private int tot_pessoas_tadel;

	@Column(name = "tot_ge", nullable = false)
	private int tot_ge;

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

	public int getTot_membros() {
		return tot_membros;
	}

	public void setTot_membros(int tot_membros) {
		this.tot_membros = tot_membros;
	}

	public int getTot_criancas() {
		return tot_criancas;
	}

	public void setTot_criancas(int tot_criancas) {
		this.tot_criancas = tot_criancas;
	}

	public int getTot_visitantes() {
		return tot_visitantes;
	}

	public void setTot_visitantes(int tot_visitantes) {
		this.tot_visitantes = tot_visitantes;
	}

	public int getTot_pessoas_celula() {
		return tot_pessoas_celula;
	}

	public void setTot_pessoas_celula(int tot_pessoas_celula) {
		this.tot_pessoas_celula = tot_pessoas_celula;
	}

	public BigDecimal getOferta() {
		return oferta;
	}

	public void setOferta(BigDecimal oferta) {
		this.oferta = oferta;
	}

	public int getTot_pessoas_culto() {
		return tot_pessoas_culto;
	}

	public void setTot_pessoas_culto(int tot_pessoas_culto) {
		this.tot_pessoas_culto = tot_pessoas_culto;
	}

	public int getTot_pessoas_tadel() {
		return tot_pessoas_tadel;
	}

	public void setTot_pessoas_tadel(int tot_pessoas_tadel) {
		this.tot_pessoas_tadel = tot_pessoas_tadel;
	}

	public int getTot_ge() {
		return tot_ge;
	}

	public void setTot_ge(int tot_ge) {
		this.tot_ge = tot_ge;
	}

	public Celulas getCelula2() {
		return celula2;
	}

	public void setCelula2(Celulas celula2) {
		this.celula2 = celula2;
	}


}
