package br.com.augusto.dto;

import java.util.Date;

import br.com.augusto.controller.entidade.Tadeu;


public class TadeuDTO {
	private Integer id_tadeu;
	private Date data;
	private String comentario;
	private float total_dizimo;
	private float total_oferta;
	private int total_pessoas;
	public TadeuDTO( Date data, String comentario, float total_dizimo, float total_oferta,
			int total_pessoas) {
		super();
		this.data = data;
		this.comentario = comentario;
		this.total_dizimo = total_dizimo;
		this.total_oferta = total_oferta;
		this.total_pessoas = total_pessoas;
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
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
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
	public int getTotal_pessoas() {
		return total_pessoas;
	}
	public void setTotal_pessoas(int total_pessoas) {
		this.total_pessoas = total_pessoas;
	}
	public static Tadeu convertTadeu(TadeuDTO tadeuDTO) {
		Tadeu tadeu = new Tadeu();
		tadeu.setData(tadeuDTO.getData());
		tadeu.setComentario(tadeuDTO.getComentario());
		tadeu.setTotal_dizimo(tadeuDTO.getTotal_dizimo());
		tadeu.setTotal_oferta(tadeuDTO.getTotal_oferta());
		tadeu.setTotal_pessoas(tadeuDTO.getTotal_pessoas());		
		return tadeu;
	}
	

}
