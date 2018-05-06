package br.com.augusto.model;

public class AuxTadeu {
	private Integer id;
	private String nome;
	private String comentario;
	
	public AuxTadeu(Integer id, String nome, String comentario) {
		super();
		this.id = id;
		this.nome = nome;
		this.comentario = comentario;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	

}
