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
import br.com.augusto.controller.entidade.PessoaCelula;
import br.com.augusto.controller.entidade.PessoasCelulas;
import br.com.augusto.controller.entidade.Tadeu;
import br.com.augusto.controller.entidade.Telefones;
import br.com.augusto.controller.entidade.TrilhoLideranca;
import br.com.augusto.dao.DAOBatismo;
import br.com.augusto.dao.DAOListTrilho;
import br.com.augusto.dao.DAOPessoaCelula;
import br.com.augusto.dao.DAOPessoasCelulas;
import br.com.augusto.dao.DAOTadeu;
import br.com.augusto.dao.DAOTrilhoLideranca;

@Repository("daoPessoaCelula")
public class JPAPessoaCelula extends JPADAO<PessoaCelula> implements DAOPessoaCelula {

	public List<PessoaCelula> list() {
		return manager.createQuery("select b from PessoaCelula b").getResultList();
	}

	public List<PessoaCelula> listMembros() {
		return manager.createQuery("select b from PessoaCelula b where b.membro = true").getResultList();
	}

	public List<PessoaCelula> listVisitantes() {
		return manager.createQuery("select b from PessoaCelula b where b.membro = false").getResultList();
	}

	public PessoaCelula get(Integer id) {
		return manager.find(PessoaCelula.class, id);
	}


	public PessoaCelula buscaNome(String nome_pessoa) {
		System.out.println(nome_pessoa);
		String consulta = "select b from PessoaCelula b where b.nome_pessoa = :nome_pessoa";
		Query query = manager.createQuery(consulta);
		query.setParameter("nome_pessoa", nome_pessoa);
		return (PessoaCelula) query.getSingleResult();
	}
}
