package br.com.augusto.dao.jpa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.augusto.controller.entidade.Batismo;
import br.com.augusto.controller.entidade.Celulas;
import br.com.augusto.controller.entidade.ListTrilho;
import br.com.augusto.controller.entidade.Pessoa;
import br.com.augusto.controller.entidade.PessoasCelulas;
import br.com.augusto.controller.entidade.Tadeu;
import br.com.augusto.controller.entidade.Telefones;
import br.com.augusto.controller.entidade.TrilhoLideranca;
import br.com.augusto.dao.DAOBatismo;
import br.com.augusto.dao.DAOListTrilho;
import br.com.augusto.dao.DAOPessoasCelulas;
import br.com.augusto.dao.DAOTadeu;
import br.com.augusto.dao.DAOTrilhoLideranca;

@Repository("daoPessoasCelulas")
public class JPAPessoasCelulas extends JPADAO<PessoasCelulas> implements DAOPessoasCelulas {

	public List<PessoasCelulas> list() {
		return manager.createQuery("select b from PessoasCelulas b").getResultList();
	}

	public PessoasCelulas get(Integer id) {
		return manager.find(PessoasCelulas.class, id);
	}

	public List<PessoasCelulas> trazMembrosPorCelula(Integer id) {
		System.out.println("consulta");
		String consulta = "select b from PessoasCelulas b";
		Query query = manager.createQuery(consulta);
		//query.setParameter("id", id);
		return query.getResultList();
	}

}
