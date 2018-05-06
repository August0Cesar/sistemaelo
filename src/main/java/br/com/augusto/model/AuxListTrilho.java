package br.com.augusto.model;

import br.com.augusto.controller.entidade.ListTrilho;
import br.com.augusto.controller.entidade.Pessoa;
import br.com.augusto.controller.entidade.TrilhoLideranca;

public class AuxListTrilho implements Comparable<AuxListTrilho> {
	private ListTrilho listTrilho;
	private Pessoa pessoa;
	private TrilhoLideranca trilhoLideranca;

	public AuxListTrilho() {
		super();
	}

	public ListTrilho getListTrilho() {
		return listTrilho;
	}

	public void setListTrilho(ListTrilho listTrilho) {
		this.listTrilho = listTrilho;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public TrilhoLideranca getTrilhoLideranca() {
		return trilhoLideranca;
	}

	public void setTrilhoLideranca(TrilhoLideranca trilhoLideranca) {
		this.trilhoLideranca = trilhoLideranca;
	}

	public int compareTo(AuxListTrilho o) {
		if (this.pessoa.getId_pessoa() < o.getPessoa().getId_pessoa()) {
			return -1;
		}
		if (this.pessoa.getId_pessoa() > o.getPessoa().getId_pessoa()) {
			return 1;
		}
		return 0;
	}

}
