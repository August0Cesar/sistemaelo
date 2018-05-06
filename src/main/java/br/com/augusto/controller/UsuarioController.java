package br.com.augusto.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.augusto.controller.entidade.Usuario;
import br.com.augusto.dao.jpa.JPAUsuario;

@Transactional
@Controller
public class UsuarioController {
	@Autowired
	JPAUsuario daoUsuario;

	@RequestMapping("/cadastroUsuario")
	public String homepage() {
		return "usuario/formUsuario";
	}

	@RequestMapping("/salvaUsuario")
	public String salvaUsuario(Usuario usuario) {
		daoUsuario.persistir(usuario);
		return "usuario/listaUsuario";
	}

	@RequestMapping("/listaUsuarios")
	public String listaUsuario(Model model) {
		model.addAttribute("usuarios", daoUsuario.list());
		return "usuario/listaUsuario";
	}

	@RequestMapping("/mostraUsuarios")
	public String mostraUsuario(Long id, Model model) {
		model.addAttribute("usuarios", daoUsuario.list());
		return "usuario/listaUsuario";
	}

	@RequestMapping("/alteraUsuarios")
	public String alteraUsuario() {
		// model.addAttribute("tarefa", dao.buscaPorId(id));
		return "usuario/listaUsuario";
	}

	@RequestMapping("/removeUsuarios")
	public String removeUsuario(int id) {
		System.out.print("passei aqui /n");
		Usuario usuario = daoUsuario.get(id);
		System.out.print(usuario.getId_usuario() + usuario.getNome_usuario());
		daoUsuario.excluir(usuario);
		return "redirect:listaUsuarios";

	}
}
