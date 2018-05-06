package br.com.augusto.model;

import java.util.List;

import br.com.augusto.controller.entidade.CelulaSemana;
import br.com.augusto.controller.entidade.Celulas;

public class AuxCelulaSemana implements Comparable<AuxCelulaSemana> {
	private CelulaSemana celulaSemana;
	private Celulas celula;
	public AuxCelulaSemana() {
		super();
	}
	public CelulaSemana getCelulaSemana() {
		return celulaSemana;
	}
	public void setCelulaSemana(CelulaSemana celulaSemana) {
		this.celulaSemana = celulaSemana;
	}
	public Celulas getCelula() {
		return celula;
	}
	public void setCelula(Celulas celula) {
		this.celula = celula;
	}
	
	public int compareTo(AuxCelulaSemana o) {
		/*if(this.celula.getId_celula()<o.getCelula().getId_celula()){
			return -1;
		}
*/
		if(this.celulaSemana.getData_celula().before(o.getCelulaSemana().getData_celula())){
			return -1;
		}
		if(this.celulaSemana.getData_celula().after(o.getCelulaSemana().getData_celula())){
			return 1;
		}
		return 0;
	}
	
	
	

}
