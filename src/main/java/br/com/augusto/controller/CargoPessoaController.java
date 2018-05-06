package br.com.augusto.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.augusto.controller.entidade.Cargo;
import br.com.augusto.controller.entidade.Pessoa;
import br.com.augusto.dao.jpa.JPACargo;
import br.com.augusto.dao.jpa.JPAPessoa;

@Transactional
@Controller
public class CargoPessoaController {
	@Autowired
	JPAPessoa daoPessoa;
	@Autowired
	JPACargo daoCargo;

	@RequestMapping("/cadastroCargo")
	public String cadastroTadeu(Model model) {
		model.addAttribute("pessoas", daoPessoa.list());
		model.addAttribute("cargos", daoCargo.list());

		return "pessoa/formCargoPessoa";
	}

	@RequestMapping("/salvaPessoaCargo")
	public String salvaPessoaCargo(Integer id_pessoa, Integer id_cargo) {
		List<Cargo> cargos = new ArrayList<Cargo>();
		Pessoa p = new Pessoa();
		p = daoPessoa.get(id_pessoa);
		if (p.getCargo().isEmpty()) {
			Cargo c = new Cargo();
			c.setId_cargo(id_cargo);
			cargos.add(c);
			p.setCargo(cargos);
			daoPessoa.persistir(p);
		} else {
			cargos.addAll(p.getCargo());
			Cargo c = new Cargo();
			c=daoCargo.get(id_cargo);
			if(cargos.contains(c)){
				return "vazio/dadosCargos";
			}else{
				cargos.add(c);
				p.setCargo(cargos);
				daoPessoa.persistir(p);
			}
			
		}

		return "pessoa/formCargoPessoa";
	}

}
