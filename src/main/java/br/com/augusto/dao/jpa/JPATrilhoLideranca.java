package br.com.augusto.dao.jpa;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.augusto.controller.entidade.Batismo;
import br.com.augusto.controller.entidade.Telefones;
import br.com.augusto.controller.entidade.TrilhoLideranca;
import br.com.augusto.dao.DAOBatismo;
import br.com.augusto.dao.DAOTrilhoLideranca;

@Repository("daoTrilhoLideranca")
public class JPATrilhoLideranca extends JPADAO<TrilhoLideranca> implements DAOTrilhoLideranca {

	public List<TrilhoLideranca> list() {
		return manager.createQuery("select b from TrilhoLideranca b").getResultList();
	}

	public TrilhoLideranca get(Integer id) {
		return manager.find(TrilhoLideranca.class, id);
	}

	public Batismo buscaBatismo(String batizado_por) {
		String consulta = "select b from Batismo b where b.batizado_por = :batizado_por";
		TypedQuery<Batismo> query = manager.createQuery(consulta, Batismo.class);
		query.setParameter("batizado_por", batizado_por);
		return query.getSingleResult();
	}

}
