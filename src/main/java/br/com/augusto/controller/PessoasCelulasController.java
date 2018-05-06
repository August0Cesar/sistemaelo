package br.com.augusto.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.augusto.controller.entidade.CelulaSemana;
import br.com.augusto.controller.entidade.Celulas;
import br.com.augusto.controller.entidade.Pessoa;
import br.com.augusto.controller.entidade.PessoaCelula;
import br.com.augusto.controller.entidade.PessoasCelulas;
import br.com.augusto.controller.entidade.Tadeu;
import br.com.augusto.dao.jpa.JPACelulaSemana;
import br.com.augusto.dao.jpa.JPACelulas;
import br.com.augusto.dao.jpa.JPAPessoa;
import br.com.augusto.dao.jpa.JPAPessoasCelulas;

@Transactional
@Controller
public class PessoasCelulasController {
	@Autowired
	JPACelulaSemana daoCelulaSemana;
	@Autowired
	JPACelulas daoCelulas;
	@Autowired
	JPAPessoasCelulas daoPessoaCelula;

	@RequestMapping("/buscaSemanaData")
	public String buscaSemanaData() {
		return "celula/buscaCeslulaSemana";
	}

	@RequestMapping("/listPessoasPorCelulaSemana")
	public String listPessoasCelulas(String data, Model model) {
		System.out.println("entrando Dao");
		System.out.println(data);

		List<PessoaCelula> pessoas = new ArrayList<PessoaCelula>();
		List<Object[]> list = daoCelulaSemana.trazMembrosDaCelula(data);
		for (Object[] object : list) {
			PessoaCelula p = new PessoaCelula();
			Celulas c = new Celulas();
			CelulaSemana cs = new CelulaSemana();
			p.setNome_pessoa((String) object[0]);
			p.setMembro((Boolean) object[1]);
			cs.setId((Integer) object[2]);
			pessoas.add(p);

		}
		

		model.addAttribute("pessoas", pessoas);
		return "celula/pessoasPorCelulas";
	}

}
