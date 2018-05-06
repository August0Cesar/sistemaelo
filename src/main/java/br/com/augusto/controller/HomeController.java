package br.com.augusto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String homepage() {

		return "home/login";
	}

	@RequestMapping("/home")
	public String home() {
		System.out.println("Logado com Sucesso");
		return "home/memb_visit";
	}

	@RequestMapping("/culto")
	public String culto() {

		return "culto/formCulto";
	}

	@RequestMapping("/dizOferta")
	public String dizOferta() {

		return "home/dizOferta";
	}

	@RequestMapping("/membrosVisitantes")
	public String membrosVisitantes() {
		return "home/memb_visit";
	}

	@RequestMapping("/celula")
	public String celula() {
		return "home/celula";
	}

	@RequestMapping("/tadel")
	public String tadel() {
		return "home/menuTadel";
	}

	@RequestMapping("/trilhoLideranca")
	public String trilhoLideranca() {
		return "home/trilhoLideranca";
	}

}
