package br.com.augusto.controller.entidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "modulo_escola")
public class ModuloEscola {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_modulo_escola;
	@Column(name = "nome_modulo", nullable = false)
	private String nome_modulo;
	@Column(name = "comentario", nullable = false)
	private String comentario;

	@OneToMany(mappedBy = "moduloEscola")
	private List<AlunoModulo> alunoModulo;

	public ModuloEscola() {
		super();
	}

	public List<AlunoModulo> getAlunoModulo() {
		return alunoModulo;
	}

	public void setAlunoModulo(List<AlunoModulo> alunoModulo) {
		this.alunoModulo = alunoModulo;
	}

	public Integer getId_modulo_escola() {
		return id_modulo_escola;
	}

	public void setId_modulo_escola(Integer id_modulo_escola) {
		this.id_modulo_escola = id_modulo_escola;
	}

	public String getNome_modulo() {
		return nome_modulo;
	}

	public void setNome_modulo(String nome_modulo) {
		this.nome_modulo = nome_modulo;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}
