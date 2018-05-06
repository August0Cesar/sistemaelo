package br.com.augusto.dao.jpa;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.augusto.controller.entidade.Batismo;
import br.com.augusto.controller.entidade.Telefones;
import br.com.augusto.dao.DAOBatismo;

@Repository("daoBatismo")
public class JPABatismo extends JPADAO<Batismo> implements DAOBatismo {

	public List<Batismo> list() {
		return manager.createQuery("select b from Batismo b").getResultList();
	}

	public Batismo get(Integer id) {
		return manager.find(Batismo.class, id);
	}

	public Batismo buscaBatismo(String batizado_por) {
		String consulta = "select b from Batismo b where b.batizado_por = :batizado_por";
		TypedQuery<Batismo> query = manager.createQuery(consulta, Batismo.class);
		query.setParameter("batizado_por", batizado_por);
		return query.getSingleResult();
	}

}
