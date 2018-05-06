package br.com.augusto.dao.jpa;

import java.io.PrintStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.augusto.controller.entidade.Pessoa;
import br.com.augusto.controller.entidade.Usuario;
import br.com.augusto.dao.DAOUsuario;

@Repository("daoUsuario")
public class JPAUsuario extends JPADAO<Usuario> implements DAOUsuario {

	public List<Usuario> list() {
		return manager.createQuery("select t from Usuario t").getResultList();
	}

	public boolean buscaLogin(String login, String senha) {
		String consulta = "select b from Usuario b where b.login = :login  and b.senha = :senha";

		try {
			TypedQuery<Usuario> query = manager.createQuery(consulta, Usuario.class);
			query.setParameter("senha", senha);
			query.setParameter("login", login);

			Usuario usuario = query.getSingleResult();
			if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
				return true;
			} else {
				return false;
			}

		} catch (NoResultException e) {
			return false;
		}

	}

	public Usuario get(Integer id) {
		return manager.find(Usuario.class, id);
	}

	public boolean buscaUsuario(String login) {
		String consulta = "select b from Usuario b where b.login = :login ";
		TypedQuery<Usuario> query = manager.createQuery(consulta, Usuario.class);
		query.setParameter("login", login);
		try {
			query.getSingleResult();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
