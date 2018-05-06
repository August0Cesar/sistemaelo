package br.com.augusto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.augusto.controller.entidade.Celulas;
import br.com.augusto.controller.entidade.Pessoa;
import br.com.augusto.controller.entidade.Usuario;
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

		// System.out.println(nome_celula + id_pessoa);
		System.out.println("salvando no banco");
		daoCelulas.persistir(celula);
		return "redirect:cadastroCelulas";
	}

	@RequestMapping("/listaCelulas")
	public String listaCelulas(Model model) {
		System.out.println("passando no Controller ListaCelulas");
		celulas = daoCelulas.listCompleta();
		model.addAttribute("celulas", celulas);
		return "celula/listaCelulas";
	}

	@RequestMapping("/mostraCelulas")
	public String mostraCelulas(Long id, Model model) {
		model.addAttribute("celulas", daoCelulas.list());
		return "celula/listaCelulas";
	}

	@RequestMapping("/alteraCelulas")
	public String alteraUsuario() {
		// model.addAttribute("tarefa", dao.buscaPorId(id));
		return "celulas/listaCelulas";
	}

	@RequestMapping("/removeCelulas")
	public String removeCelulas(int id) {
		System.out.print("passei aqui /n");
		Celulas celula = daoCelulas.get(id);
		// System.out.print(celula.getId_usuario() + usuario.getNome_usuario());
		daoCelulas.excluir(celula);
		return "redirect:listaUsuarios";

	}
}
