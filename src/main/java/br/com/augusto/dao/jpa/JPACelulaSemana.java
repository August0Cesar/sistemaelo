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

import br.com.augusto.controller.entidade.CelulaSemana;
import br.com.augusto.controller.entidade.Celulas;
import br.com.augusto.controller.entidade.Pessoa;
import br.com.augusto.controller.entidade.PessoaCelula;
import br.com.augusto.dao.DAOCelulaSemana;
import br.com.augusto.dao.DAOCelulas;
import br.com.augusto.dao.DAOPessoa;

@Repository("daoCelulaSemana")
public class JPACelulaSemana extends JPADAO<CelulaSemana> implements DAOCelulaSemana {

	public List<CelulaSemana> list() {
		return manager.createQuery("select c from CelulaSemana c").getResultList();
	}

	public CelulaSemana get(Integer id) {
		return manager.find(CelulaSemana.class, id);
	}

	public List<CelulaSemana> lista() {
		return manager.createQuery("select c from CelulaSemana c").getResultList();
	}

	public List<Object[]> trazMembrosDaCelula(String data) {
		System.out.println(data);
		try {
			SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy");
			Date dt = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(formato2.parse(data));
			System.out.println(cal.getTime());
			System.out.println("entrando na consulta");
			String consulta = "select p.nome_pessoa,p.membro,b.id from CelulaSemana b INNER JOIN b.pessoaCelula p where b.data_celula = :data";
			Query query = manager.createQuery(consulta);
			query.setParameter("data", cal.getTime());

			System.out.println("sai da consulta");
			return query.getResultList();
		} catch (

		ParseException e) {
			e.printStackTrace();

		}
		return null;

	}

}
