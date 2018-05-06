package br.com.augusto.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import br.com.augusto.controller.entidade.Usuario;
import br.com.augusto.dao.jpa.JPAUsuario;

@Transactional
@Controller
public class AutenticacaoController {
	@Autowired
	JPAUsuario daoUsuario;

	@RequestMapping("/login")
	public String autentic() {

		return "home/login";
	}

	@RequestMapping(value = "/autenticacao", method = RequestMethod.POST)
	public String autentic(String login, String senha, HttpSession session) {
		System.out.println(login + senha);
		Usuario usuario = new Usuario();
		if (!daoUsuario.buscaUsuario(login)) {
			return "/vazio/errorLogin";
		}

		if (!daoUsuario.buscaLogin(login, senha)) {
			return "/vazio/errorLogin";
		} else {
			session.setAttribute("usuarioLogado", usuario);
			return "redirect:/membrosVisitantes";
		}
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

}
