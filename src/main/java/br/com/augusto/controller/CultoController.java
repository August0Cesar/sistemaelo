package br.com.augusto.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.augusto.controller.entidade.Culto;
import br.com.augusto.controller.entidade.Tadeu;
import br.com.augusto.dao.jpa.JPACulto;
@Transactional
@Controller
public class CultoController {
	@Autowired
	JPACulto daoCulto;

	@RequestMapping("cadastroCulto")
	public String cadastroCulto() {
		return "culto/formCulto";
	}

	@RequestMapping(value = "saveCulto", method = RequestMethod.POST)
	public String saveCulto(String data_culto, int membros, int visitantes, String tema_culto) {
		Culto c = new Culto();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
		try {
			c.setMembros(membros);
			c.setVisitantes(visitantes);
			c.setTema_culto(tema_culto);
			Date data2 = formato.parse(data_culto);
			System.out.println(data2);
			c.setData_culto(data2);
			daoCulto.persistir(c);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "vazio/falhaDados";
		}

		return "culto/formCulto";
	}

	@RequestMapping("/listaCulto")
	public String listaCulto(Model model) {
		System.out.println("passei lista");
		model.addAttribute("cultos", daoCulto.list());
		return "culto/listCulto";
	}
}
