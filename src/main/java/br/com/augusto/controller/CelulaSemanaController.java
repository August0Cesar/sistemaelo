package br.com.augusto.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.impl.Log4JLogger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.augusto.controller.entidade.CelulaSemana;
import br.com.augusto.controller.entidade.Celulas;
import br.com.augusto.controller.entidade.Pessoa;
import br.com.augusto.controller.entidade.PessoaCelula;
import br.com.augusto.controller.entidade.PessoasCelulas;
import br.com.augusto.controller.entidade.Tadeu;
import br.com.augusto.dao.jpa.JPACelulaSemana;
import br.com.augusto.dao.jpa.JPACelulas;
import br.com.augusto.dao.jpa.JPAPessoa;
import br.com.augusto.dao.jpa.JPAPessoaCelula;
import br.com.augusto.dao.jpa.JPAPessoasCelulas;
import br.com.augusto.excell.MembrosExcell;
import br.com.augusto.model.AuxCelulaSemana;
import ch.qos.logback.classic.Logger;

@Transactional
@Controller
public class CelulaSemanaController {
	@Autowired
	JPAPessoa daoPessoa;
	@Autowired
	JPACelulas daoCelulas;
	@Autowired
	JPACelulaSemana daoCelulaSemana;
	@Autowired
	JPAPessoasCelulas daoPessoasCelulas;
	@Autowired
	JPAPessoaCelula daoPessoaCelula;
	
	@RequestMapping(value="/mediasCelulasExcell",method=RequestMethod.GET)
    public void mediasCelulasExcell(){//ModelAndView
		            
           //return new ModelAndView(new MembrosExcell(), "studentList", pessoas);
    }

	@RequestMapping(value = "/cadastroCelulaSemana")
	public String cadastroTadeu(Model model) {

		model.addAttribute("membros", daoPessoaCelula.listMembros());
		model.addAttribute("visitantes", daoPessoaCelula.listVisitantes());
		model.addAttribute("celulas", daoCelulas.list());
		return "celula/formCelulaSemana";
	}

	@RequestMapping(value = "/cadastroPessoaCelula")
	public String cadastroPessoaCelula(Model model) {
		model.addAttribute("pessoas", daoPessoa.listPessoaSemCelula());
		model.addAttribute("celulas", daoCelulas.list());
		return "celula/formPessoasNaCelula";
	}

	@RequestMapping(value = "salvaCelulaSemana", method = RequestMethod.POST)
	public String salvaCelulaSemana(Integer id_celula,int semana, String data_celula,int tot_membros,int tot_visitantes,
			int tot_criancas,int tot_pessoas_celula,int tot_pessoas_culto,int tot_pessoas_tadel, int tot_pessoas_ge,BigDecimal ofertas) {
		Celulas c = new Celulas();
		CelulaSemana cs = new CelulaSemana();
		PessoaCelula p = new PessoaCelula();
		
		c.setId_celula(id_celula);		
		cs.setOferta(ofertas);
		cs.setSemana(semana);
		cs.setCelula2(c);
		cs.setTot_criancas(tot_criancas);
		cs.setTot_membros(tot_membros);
		cs.setTot_visitantes(tot_visitantes);
		cs.setTot_pessoas_celula(tot_pessoas_celula);
		cs.setTot_pessoas_culto(tot_pessoas_culto);
		cs.setTot_pessoas_tadel(tot_pessoas_tadel);
		cs.setTot_ge(tot_pessoas_ge);
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date data2 = formato.parse(data_celula);
			cs.setData_celula(data2);
			daoCelulaSemana.persistir(cs);
		} catch (ParseException e) { 
			e.printStackTrace();
		}

		//final String sucess1 = "<h1>Gravado com sucesso </h1><br />";
		//final String sucesso = sucess1 + "<a href='home'>Home</a>";
		return "redirect:/cadastroCelulaSemana	";
	}

	// cadastra pessoa ma celula
	@RequestMapping(value = "salvaPessoaNaCelula", method = RequestMethod.POST)
	public @ResponseBody String salvaPessoaNaCelula(@RequestBody String text) {
		Celulas c = new Celulas();
		Pessoa p = new Pessoa();
		PessoasCelulas pc = new PessoasCelulas();
		JSONObject obj = new JSONObject(text);

		p = daoPessoa.get(obj.getInt("idMembro"));
		p.setStatus_celula(true);
		daoPessoa.altera(p);
		c = daoCelulas.get(obj.getInt("idCelula"));
		pc.setCelula(c);
		pc.setPessoa4(p);

		daoPessoasCelulas.persistir(pc);
		String pessoa = p.getNome_pessoa();
		return pessoa;
	}

	/*@RequestMapping(value = "salvaCelulaSemanaVisitante", method = RequestMethod.POST)
	public @ResponseBody String salvaCelulaSemanaVisitante(@RequestBody String text) {
		System.out.println(text);

		Celulas c = new Celulas();
		CelulaSemana cs = new CelulaSemana();
		PessoaCelula p = new PessoaCelula();
		JSONObject obj = new JSONObject(text);
		String d = obj.getString("data_celula");
		String nome_pessoa = obj.getString("nome_visitante");
		System.out.println(nome_pessoa);
		p.setNome_pessoa(nome_pessoa);
		p.setMembro(false);
		p.setData_cadastro(Calendar.getInstance().getTime());
		p.setData_nascimento(Calendar.getInstance().getTime());
		p.setEndereco("");
		daoPessoaCelula.persistir(p);
		p = (PessoaCelula) daoPessoaCelula.buscaNome(nome_pessoa);
		c.setId_celula(obj.getInt("id_celula"));
		// cs.setCelula2(c);
		// cs.setPessoaCelula(p);

		String oferta = obj.getString("ofertas");
		float off = Float.parseFloat(oferta);
		cs.setOferta(off);
		cs.setSemana(obj.getInt("semana"));
		cs.setTot_adultos(obj.getInt("tot_pessoas"));
		cs.setTot_criancas(obj.getInt("tot_criancas"));
		cs.setTot_pessoas_culto(obj.getInt("tot_pessoas_culto"));

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formato2 = new SimpleDateFormat("yyyy/MM/dd");

		try {
			Date data2 = formato.parse(d);
			System.out.println(data2);
			cs.setData_celula(data2);
			daoCelulaSemana.persistir(cs);
		} catch (ParseException e) { // TODO
			// Auto-generated
			e.printStackTrace();
		}

		final String sucess = p.getNome_pessoa();
		System.out.println(sucess);
		return sucess;
	}
*/
	@RequestMapping("/listCelulasSemana")
	public String listCelulasSemana(Model model) {
		List<AuxCelulaSemana> lista = new ArrayList<AuxCelulaSemana>();
		for (CelulaSemana cs : daoCelulaSemana.lista()) {
			Celulas c = new Celulas();
			c.setNome_celula(cs.getCelula2().getNome_celula());
			CelulaSemana cc = new CelulaSemana();
			// c = daoCelulas.get(cs.getCelula2().getId_celula());
			cc = cs;
			AuxCelulaSemana acs = new AuxCelulaSemana();
			acs.setCelula(c);
			acs.setCelulaSemana(cc);
			lista.add(acs);
		}
		Collections.sort(lista);
		model.addAttribute("celulas", lista);

		return "celula/listaCelulaSemana";
	}
}
