package br.com.augusto.controller.entidade;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "pessoa")
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_pessoa;
	@Column(name = "nome_pessoa", nullable = false)
	private String nome_pessoa;
	@Column(name = "casado", nullable = false)
	private boolean casado;
	@Column(name = "endereco", nullable = false)
	private String endereco;
	@Column(name = "nome_conjugue")
	private String nome_conjugue;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_nascimento", nullable = false)
	private Date data_nascimento;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_cadastro", nullable = false)
	private Date data_cadastro;
	@Column(name = "naturalidade", nullable = false)
	private String naturalidade;
	@Column(name = "membro", nullable = false)
	private boolean membro;
	@Column(name = "visitante", nullable = false)
	private boolean visitante;
	@Column(name = "nome_pai")
	private String nome_pai;
	@Column(name = "nome_mae")
	private String nome_mae;
	@Column(name = "status_celula", nullable = false)
	private boolean status_celula;
	@Column(name = "discipulado_inicial", nullable = false)
	private boolean discipulado_inicial;
	@Column(name = "termino_discipulado_inicial", nullable = false)
	private boolean termino_discipulado_inicial;

	// relacionamento com a tabela Pessoa
	@ManyToOne
	@JoinColumn(name = "id_chegada_igreja")
	private ChegadaIgreja chegadaIgreja;

	// relacionamento com a tabela Telefons
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_telefone")
	private Telefones telefones;

	// relacionamento com a tabela Batismo
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_batismo")
	private Batismo batismo;

	@ManyToMany
	@JoinTable(name = "pessoa_cargo")
	@JoinColumn(name = "id_pessoa")
	private List<Cargo> cargo;
	
	@ManyToMany(mappedBy="pessoa")
	private List<DizimoOferta> dizimoOrfeta;

	@ManyToMany
	@JoinTable(name = "trilho_lideranca_pessoa")
	private List<TrilhoLideranca> trilhoLideranca;


	@OneToMany(mappedBy = "pessoa3",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<ListTrilho> listTrilho;

	@OneToMany(mappedBy = "pessoa4")
	private List<PessoasCelulas> pessoasCelulas;

	@OneToMany(mappedBy = "pessoa")
	private List<Celulas> celulas;

	public Pessoa() {
		super();
	}



	public List<DizimoOferta> getDizimoOrfeta() {
		return dizimoOrfeta;
	}



	public void setDizimoOrfeta(List<DizimoOferta> dizimoOrfeta) {
		this.dizimoOrfeta = dizimoOrfeta;
	}



	public List<PessoasCelulas> getPessoasCelulas() {
		return pessoasCelulas;
	}

	public void setPessoasCelulas(List<PessoasCelulas> pessoasCelulas) {
		this.pessoasCelulas = pessoasCelulas;
	}

	public List<Celulas> getCelulas() {
		return celulas;
	}

	public void setCelulas(List<Celulas> celulas) {
		this.celulas = celulas;
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

	public List<ListTrilho> getListTrilho() {
		return listTrilho;
	}

	public void setListTrilho(List<ListTrilho> listTrilho) {
		this.listTrilho = listTrilho;
	}

	public List<Cargo> getCargo() {
		return cargo;
	}

	public void setCargo(List<Cargo> cargo) {
		this.cargo = cargo;
	}
	public List<TrilhoLideranca> getTrilhoLideranca() {
		return trilhoLideranca;
	}

	public void setTrilhoLideranca(List<TrilhoLideranca> trilhoLideranca) {
		this.trilhoLideranca = trilhoLideranca;
	}

	public Batismo getBatismo() {
		return batismo;
	}

	public void setBatismo(Batismo batismo) {
		this.batismo = batismo;
	}

	public Telefones getTelefones() {
		return telefones;
	}

	public void setTelefones(Telefones telefones) {
		this.telefones = telefones;
	}

	public ChegadaIgreja getChegadaIgreja() {
		return chegadaIgreja;
	}

	public void setChegadaIgreja(ChegadaIgreja chegadaIgreja) {
		this.chegadaIgreja = chegadaIgreja;
	}

	public Integer getId_pessoa() {
		return id_pessoa;
	}

	public void setId_pessoa(Integer id_pessoa) {
		this.id_pessoa = id_pessoa;
	}

	public String getNome_pessoa() {
		return nome_pessoa;
	}

	public void setNome_pessoa(String nome_pessoa) {
		this.nome_pessoa = nome_pessoa;
	}

	public boolean isCasado() {
		return casado;
	}

	public void setCasado(boolean casado) {
		this.casado = casado;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome_conjugue() {
		return nome_conjugue;
	}

	public void setNome_conjugue(String nome_conjugue) {
		this.nome_conjugue = nome_conjugue;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public boolean isMembro() {
		return membro;
	}

	public void setMembro(boolean membro) {
		this.membro = membro;
	}

	public boolean isVisitante() {
		return visitante;
	}

	public void setVisitante(boolean visitante) {
		this.visitante = visitante;
	}

	public String getNome_pai() {
		return nome_pai;
	}

	public void setNome_pai(String nome_pai) {
		this.nome_pai = nome_pai;
	}

	public String getNome_mae() {
		return nome_mae;
	}

	public void setNome_mae(String nome_mae) {
		this.nome_mae = nome_mae;
	}

	public boolean isStatus_celula() {
		return status_celula;
	}

	public void setStatus_celula(boolean status_celula) {
		this.status_celula = status_celula;
	}

	public boolean isDiscipulado_inicial() {
		return discipulado_inicial;
	}

	public void setDiscipulado_inicial(boolean discipulado_inicial) {
		this.discipulado_inicial = discipulado_inicial;
	}

	public boolean isTermino_discipulado_inicial() {
		return termino_discipulado_inicial;
	}

	public void setTermino_discipulado_inicial(boolean termino_discipulado_inicial) {
		this.termino_discipulado_inicial = termino_discipulado_inicial;
	}

}
