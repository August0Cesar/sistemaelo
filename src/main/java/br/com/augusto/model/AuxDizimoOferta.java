package br.com.augusto.model;

import br.com.augusto.controller.entidade.DizimoOferta;
import br.com.augusto.controller.entidade.Pessoa;

public class AuxDizimoOferta implements Comparable<AuxDizimoOferta>{
	private Pessoa pessoa;
	private DizimoOferta dizimoOferta;

	public AuxDizimoOferta() {
		super();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public DizimoOferta getDizimoOferta() {
		return dizimoOferta;
	}

	public void setDizimoOferta(DizimoOferta dizimoOferta) {
		this.dizimoOferta = dizimoOferta;
	}

	public int compareTo(AuxDizimoOferta o) {
		if (this.pessoa.getId_pessoa() < o.getPessoa().getId_pessoa()) {
			return -1;
		}
		if (this.pessoa.getId_pessoa() > o.getPessoa().getId_pessoa()) {
			return 1;
		}
		return 0;
	}

}
