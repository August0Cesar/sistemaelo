package br.com.augusto.dao.jpa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.augusto.controller.entidade.Batismo;
import br.com.augusto.controller.entidade.Pessoa;
import br.com.augusto.dao.DAOPessoa;

@Repository("daoPessoa")
public class JPAPessoa extends JPADAO<Pessoa> implements DAOPessoa {

	public List<Pessoa> list() {
		return manager.createQuery("select p from Pessoa p").getResultList();
	}

	public List<Pessoa> todosmenbros() {
		List<Pessoa> p = new ArrayList<Pessoa>();
		String consulta = "select b from Pessoa b where b.membro = :membro";
		TypedQuery<Pessoa> query = manager.createQuery(consulta, Pessoa.class);
		query.setParameter("membro", true);
		p = query.getResultList();
		return p;
	}

	public List<Pessoa> todosVisitantes() {
		List<Pessoa> p = new ArrayList<Pessoa>();
		String consulta = "select b from Pessoa b where b.membro = :membro";
		TypedQuery<Pessoa> query = manager.createQuery(consulta, Pessoa.class);
		query.setParameter("membro", false);
		p = query.getResultList();
		return p;
	}

	public Pessoa get(Integer id) {
		return manager.find(Pessoa.class, id);
	}

	public List<Pessoa> visitantesPorPeriodo(String dataInicio, String dataFinal) {
		System.out.println(dataInicio + dataFinal);
		try {

			// SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy");
			Calendar cal = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();
			cal.setTime(formato2.parse(dataInicio));
			cal2.setTime(formato2.parse(dataFinal));
			List<Pessoa> p = new ArrayList<Pessoa>();
			String consulta = "select b from Pessoa b where b.membro = :v and b.data_cadastro between :data_inicio and :data_final";
			TypedQuery<Pessoa> query = manager.createQuery(consulta, Pessoa.class);
			query.setParameter("v", false);
			query.setParameter("data_inicio", cal.getTime());
			query.setParameter("data_final", cal2.getTime());
			System.out.println("tamanho do retorno query  "+query.getResultList().size());
			p = query.getResultList();
			return p;

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<Pessoa> membrosPorPeriodo(String dataInicio, String dataFinal) {
		System.out.println(dataInicio + dataFinal);
		try {

			// SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy");
			Calendar cal = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();
			cal.setTime(formato2.parse(dataInicio));
			cal2.setTime(formato2.parse(dataFinal));
			List<Pessoa> p = new ArrayList<Pessoa>();
			String consulta = "select b from Pessoa b where b.membro = :v and b.data_cadastro between :data_inicio and :data_final";
			TypedQuery<Pessoa> query = manager.createQuery(consulta, Pessoa.class);
			query.setParameter("v", true);
			query.setParameter("data_inicio", cal.getTime());
			query.setParameter("data_final", cal2.getTime());
			p = query.getResultList();
			return p;

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<Pessoa> listPessoaSemCelula() {
		return manager.createQuery("select p from Pessoa p where p.status_celula = false").getResultList();
	}

	public List<Pessoa> nomeMenbros() {
		List<Pessoa> p = new ArrayList<Pessoa>();
		String consulta = "select b from Pessoa b where b.membro = :membro";
		TypedQuery<Pessoa> query = manager.createQuery(consulta, Pessoa.class);
		query.setParameter("membro", true);
		p = query.getResultList();
		return p;
	}

	public List<Pessoa> buscaAniversariantes(int numberMes) {
		System.out.println("2º" + numberMes);
		String consulta = "select p from Pessoa p where Month(p.data_nascimento) = :mes";
		TypedQuery<Pessoa> query = manager.createQuery(consulta, Pessoa.class);
		query.setParameter("mes", numberMes);
		return query.getResultList();
	}

	public Pessoa encontraPessoa(Pessoa pessoa) {
		String consulta = "select p from Pessoa p where p.data_nascimento = :data_nascimento and p.nome_pessoa = :nome_pessoa";
		TypedQuery<Pessoa> query = manager.createQuery(consulta, Pessoa.class);
		query.setParameter("data_nascimento", pessoa.getData_nascimento());
		query.setParameter("nome_pessoa", pessoa.getNome_pessoa());
		return query.getSingleResult();
	}

	/*
	 * public Pessoa listaMembroDetalhes() { String consulta =
	 * "select b from Pessoa b where b.membro = :v"; TypedQuery<Pessoa> query =
	 * manager.createQuery(consulta, Pessoa.class); query.setParameter("v",
	 * true); return null; }
	 */
}
