package br.com.augusto.dao.jpa;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.augusto.controller.entidade.Batismo;
import br.com.augusto.controller.entidade.Cargo;
import br.com.augusto.controller.entidade.ListTrilho;
import br.com.augusto.controller.entidade.Tadeu;
import br.com.augusto.controller.entidade.Telefones;
import br.com.augusto.controller.entidade.TrilhoLideranca;
import br.com.augusto.dao.DAOBatismo;
import br.com.augusto.dao.DAOCargo;
import br.com.augusto.dao.DAOListTrilho;
import br.com.augusto.dao.DAOTadeu;
import br.com.augusto.dao.DAOTrilhoLideranca;

@Repository("dao<Cargo")
public class JPACargo extends JPADAO<Cargo> implements DAOCargo {

	public List<Cargo> list() {
		return manager.createQuery("select b from Cargo b").getResultList();
	}

	public Cargo get(Integer id) {
		return manager.find(Cargo.class, id);
	}

	public Batismo buscaBatismo(String batizado_por) {
		String consulta = "select b from Batismo b where b.batizado_por = :batizado_por";
		TypedQuery<Batismo> query = manager.createQuery(consulta, Batismo.class);
		query.setParameter("batizado_por", batizado_por);
		return query.getSingleResult();
	}

}
