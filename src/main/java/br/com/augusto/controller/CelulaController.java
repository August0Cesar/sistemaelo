package br.com.augusto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.augusto.controller.entidade.CelulaSemana;
import br.com.augusto.controller.entidade.Celulas;
import br.com.augusto.controller.entidade.Pessoa;
import br.com.augusto.controller.entidade.Usuario;
import br.com.augusto.dao.DAOCelulaSemana;
import br.com.augusto.dao.jpa.JPACelulaSemana;
import br.com.augusto.dao.jpa.JPACelulas;
import br.com.augusto.dao.jpa.JPAPessoa;
import br.com.augusto.dao.jpa.JPAUsuario;

@Transactional
@Controller
public class CelulaController {
	public Celulas celula = new Celulas();
	public Pessoa pessoa = new Pessoa();
	List<Celulas> celulas = new ArrayList<Celulas>();

	@Autowired
	JPACelulas daoCelulas;
	@Autowired
	JPAPessoa daoPessoa;
	@Autowired
	JPACelulaSemana daoCelulaSemana;

	@RequestMapping("/cadastroCelulas")
	public String homepage(Model model) {
		System.out.println("passei aqui no cel");
		model.addAttribute("pessoas", daoPessoa.list());
		
		return "celula/formCelulas";
	}

	@RequestMapping("/salvaCelulas")
	public String salvaCelulas(@RequestParam String nome_celula, @RequestParam String nome_anfitriao,
			@RequestParam String endereco_celula, @RequestParam boolean celula_kids, @RequestParam Integer id_pessoa) {
		Celulas celula = new Celulas();
		celula.setEndereco_celula(endereco_celula);
		celula.setNome_celula(nome_celula);
		celula.setNome_anfitriao(nome_anfitriao);
		celula.setKids(celula_kids);
		Pessoa pessoa = new Pessoa();
		pessoa = daoPessoa.get(id_pessoa);
		celula.setPessoa(pessoa);

		daoCelulas.persistir(celula);
		return "redirect:cadastroCelulas";
	}

	@RequestMapping("/listaCelulas")
	public String listaCelulas(Model model) {
		celulas = daoCelulas.listCompleta();
		model.addAttribute("celulas", celulas);
		return "celula/listaCelulas";
	}

	@RequestMapping("/mostraCelulas")
	public String mostraCelulas(Long id, Model model) {
		model.addAttribute("celulas", daoCelulas.list());
		return "celula/listaCelulas";
	}

	@RequestMapping(value="/editCelulas",method=RequestMethod.GET)
	public ModelAndView editCelulas(Integer id) {
		ModelAndView model = new ModelAndView();
		Celulas celula = daoCelulas.get(id);
		model.addObject("celula", celula);
		model.addObject("pessoas", daoPessoa.list());
		model.setViewName("celula/formEditCelulas");
		return model;
	}
	
	@RequestMapping(value="/salvaEdicaoCelulas",method=RequestMethod.POST)
	public String salvaEdicaoCelulas(@RequestParam Integer id_celula,@RequestParam String nome_celula, @RequestParam String nome_anfitriao,
			@RequestParam String endereco_celula, @RequestParam boolean celula_kids, @RequestParam Integer id_pessoa) {
		
		Celulas celulaAtual = daoCelulas.get(id_celula);
		Pessoa pessoa = daoPessoa.get(id_pessoa);
		celulaAtual.setEndereco_celula(endereco_celula);
		celulaAtual.setNome_celula(nome_celula);
		celulaAtual.setKids(celula_kids);
		celulaAtual.setNome_anfitriao(nome_anfitriao);
		celulaAtual.setPessoa(pessoa);
		
		daoCelulas.altera(celulaAtual);
		return "redirect:listaCelulas";
	}
	

	@RequestMapping("/removeCelulas")
	public String removeCelulas(int id) throws Exception { 
		Celulas celula = daoCelulas.get(id);
		
		List<CelulaSemana> celulas = daoCelulaSemana.listaPorCelula(id);
		if(celulas.size()>0)
			return "error/celulaError";
		
		celula.setPessoa(null);
		daoCelulas.excluir(celula);
		return "redirect:listaCelulas";

	}
}
