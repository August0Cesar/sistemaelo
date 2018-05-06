package br.com.augusto.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import br.com.augusto.controller.entidade.Celulas;
import br.com.augusto.controller.entidade.Pessoa;
import br.com.augusto.dao.DAOCelulas;
import br.com.augusto.dao.DAOPessoa;

@Repository("daoCelulas")
public class JPACelulas extends JPADAO<Celulas> implements DAOCelulas {

	public List<Celulas> list() {
		return manager.createQuery("select c from Celulas c").getResultList();
	}

	public List<Celulas> listComplet() {
		/*
		 * String consulta = "select c,p from Celulas c " +
		 * "INNER JOIN c.pessoa p"; Query query = manager.createQuery(consulta,
		 * Celulas.class); List lista = query.getResultList();
		 */
		return manager
				.createQuery(
						"select c.nome_celula,c.endereco_celula,p.nome_pessoa from Celulas c INNER JOIN c.pessoa p")
				.getResultList();

	}

	public List<Celulas> listCompleta() {
		String consulta = "select c.id_celula,c.nome_celula,c.nome_anfitriao,c.endereco_celula,p.nome_pessoa from Celulas c INNER JOIN c.pessoa p";
		Query query = manager.createQuery(consulta);

		List<Object[]> list = query.getResultList();
		// lista que vai ser retornada pelo método
		List<Celulas> celulas = new ArrayList<Celulas>();
		System.out.println("oi");
		for (Object[] object : list) {
			Pessoa p = new Pessoa();
			Celulas celula2 = new Celulas();
			celula2.setId_celula((Integer) object[0]);
			celula2.setNome_celula((String) object[1]);
			celula2.setNome_anfitriao((String) object[2]);
			celula2.setEndereco_celula((String) object[3]);
			p.setNome_pessoa((String) object[4]);
			celula2.setPessoa(p);
			celulas.add(celula2);
		}

		return celulas;
	}

	public Celulas get(Integer id) {
		return manager.find(Celulas.class, id);
	}

	

}
