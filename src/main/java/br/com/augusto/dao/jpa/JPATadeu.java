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
import br.com.augusto.controller.entidade.Tadeu;
import br.com.augusto.controller.entidade.Telefones;
import br.com.augusto.controller.entidade.TrilhoLideranca;
import br.com.augusto.dao.DAOBatismo;
import br.com.augusto.dao.DAOListTrilho;
import br.com.augusto.dao.DAOTadeu;
import br.com.augusto.dao.DAOTrilhoLideranca;

@Repository("daoTadeu")
public class JPATadeu extends JPADAO<Tadeu> implements DAOTadeu {

	public List<Tadeu> list() {
		return manager.createQuery("select b from Tadeu b").getResultList();
	}

	public List<Tadeu> listAgrupadas() {
		return manager.createQuery("select b from Tadeu b group by b.data").getResultList();
	}

	public Tadeu get(Integer id) {
		return manager.find(Tadeu.class, id);
	}

	public List<Object[]> porPeriodo(String data) {
		System.out.println(data);
		try {
			SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy");
			Date dt = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(formato2.parse(data));
			System.out.println(cal.getTime());
			

			String consulta = "select b.id_tadeu,b.comentario,p.nome_pessoa,b.data from Tadeu b INNER JOIN b.pessoa p where b.data = :data group by p.nome_pessoa";
			Query query = manager.createQuery(consulta);
			query.setParameter("data", cal.getTime());//cal.getTime()
			System.out.println(query.getResultList().size());
			System.out.println("Já pesquisei");
			return query.getResultList();
		} catch (ParseException e) {
			e.printStackTrace();
			
		}
		return null;
	}

	public List<Object[]> visitantesPorPeriodo(String dataInicio, String dataFinal) {
		System.out.println(dataInicio + dataFinal);
		try {

			// SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy");
			Calendar cal = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();
			cal.setTime(formato2.parse(dataInicio));
			cal2.setTime(formato2.parse(dataFinal));
			List<Pessoa> p = new ArrayList<Pessoa>();
			String consulta = "select b.id_tadeu,b.comentario,p.nome_pessoa,b.data from Tadeu b INNER JOIN b.pessoa p where b.data between :data_inicio and :data_final group by p.nome_pessoa";
			Query query = manager.createQuery(consulta);
			query.setParameter("data_inicio", cal.getTime());
			query.setParameter("data_final", cal2.getTime());

			return query.getResultList();

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;

	}

}
