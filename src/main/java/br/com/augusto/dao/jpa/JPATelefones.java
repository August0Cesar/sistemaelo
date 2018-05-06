package br.com.augusto.dao.jpa;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.augusto.controller.entidade.Telefones;
import br.com.augusto.controller.entidade.Usuario;
import br.com.augusto.dao.DAOTelefones;
import br.com.augusto.dao.DAOUsuario;

@Repository("daoTelefones")
public class JPATelefones extends JPADAO<Telefones> implements DAOTelefones {

	public List<Telefones> list() {
		return manager.createQuery("select t from Telefones t").getResultList();
	}

	public Telefones get(Integer id) {
		return manager.find(Telefones.class, id);
	}

	public Telefones buscaTelefone(String tel_whatsapp) {
		String consulta = "select t from Telefones t where t.tel_whatsapp = :tel_whatsap";
		TypedQuery<Telefones> query = manager.createQuery(consulta, Telefones.class);
		query.setParameter("tel_whatsap", tel_whatsapp);
		return query.getSingleResult();
	}

}
