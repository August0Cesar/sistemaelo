package br.com.augusto.dao.jpa;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.augusto.controller.entidade.Batismo;
import br.com.augusto.controller.entidade.ListTrilho;
import br.com.augusto.controller.entidade.Telefones;
import br.com.augusto.controller.entidade.TrilhoLideranca;
import br.com.augusto.dao.DAOBatismo;
import br.com.augusto.dao.DAOListTrilho;
import br.com.augusto.dao.DAOTrilhoLideranca;

@Repository("daoListTrilho")
public class JPAListTrilho extends JPADAO<ListTrilho> implements DAOListTrilho {

	public List<ListTrilho> list() {
		return manager.createQuery("select b from ListTrilho b").getResultList();
	}

	public ListTrilho get(Integer id) {
		return manager.find(ListTrilho.class, id);
	}

	public List<ListTrilho> listP(Integer id) {
		String consulta = "select b from ListTrilho b where b.id_pessoa = :id";
		Query query = manager.createQuery(consulta);
		query.setParameter("id", id);
		return query.getResultList();
	}
}
