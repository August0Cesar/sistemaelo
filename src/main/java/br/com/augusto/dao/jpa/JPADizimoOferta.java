package br.com.augusto.dao.jpa;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.augusto.controller.entidade.Batismo;
import br.com.augusto.controller.entidade.DizimoOferta;
import br.com.augusto.controller.entidade.Telefones;
import br.com.augusto.dao.DAOBatismo;
import br.com.augusto.dao.DAODizimoOferta;

@Repository("daoDizimoOferta")
public class JPADizimoOferta extends JPADAO<DizimoOferta> implements DAODizimoOferta {

	public List<DizimoOferta> list() {
		return manager.createQuery("select b from DizimoOferta b").getResultList();
	}

	public List<Object[]> listCompleta() {
		return manager
				.createQuery(
						"select b.id_dizimo_oferta,b.data_dizimo_oferta,b.dizimo,b.valor,p.nome_pessoa from DizimoOferta b INNER JOIN b.pessoa p")
				.getResultList();
	}

	public DizimoOferta get(Integer id) {
		return manager.find(DizimoOferta.class, id);
	}

}
