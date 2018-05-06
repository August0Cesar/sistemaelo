package br.com.augusto.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import br.com.augusto.dao.DAOBase;

public abstract class JPADAO<T> implements DAOBase<T> {
	@PersistenceContext
	protected EntityManager manager;

	public void persistir(T objeto) {
		manager.persist(objeto);
	}

	public void excluir(T objeto) {
		manager.remove(objeto);
	}

	public void altera(T objeto) {
		manager.merge(objeto);
	}

}
