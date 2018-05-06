package br.com.augusto.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import br.com.augusto.controller.entidade.Celulas;
import br.com.augusto.controller.entidade.Culto;
import br.com.augusto.controller.entidade.Pessoa;
import br.com.augusto.dao.DAOCelulas;
import br.com.augusto.dao.DAOCulto;
import br.com.augusto.dao.DAOPessoa;

@Repository("daoCulto")
public class JPACulto extends JPADAO<Culto> implements DAOCulto {

	public List<Culto> list() {
		return manager.createQuery("select c from Culto c").getResultList();
	}

	public Culto get(Integer id) {
		return manager.find(Culto.class, id);
	}

}
