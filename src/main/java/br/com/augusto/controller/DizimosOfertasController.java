package br.com.augusto.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.augusto.controller.entidade.DizimoOferta;
import br.com.augusto.controller.entidade.Pessoa;
import br.com.augusto.controller.entidade.Tadeu;
import br.com.augusto.controller.entidade.Telefones;
import br.com.augusto.dao.jpa.JPADizimoOferta;
import br.com.augusto.dao.jpa.JPAPessoa;
import br.com.augusto.model.AuxCelulaSemana;
import br.com.augusto.model.AuxDizimoOferta;

@Transactional
@Controller
public class DizimosOfertasController {
	@Autowired
	JPAPessoa daoPessoa;
	@Autowired
	JPADizimoOferta daoDizimoOferta;

	@RequestMapping("/cadastroDizimoOfertas")
	public String cadastroDizimoOfertas(Model model) {
		model.addAttribute("pessoas", daoPessoa.list());

		return "dizimo/formDizimoOferta";
	}

	@RequestMapping("/listaDizimoOfertas")
	public String listaDizimoOfertas(Model model) {
		List<DizimoOferta> lista;
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		List<AuxDizimoOferta> listaAux = new ArrayList<AuxDizimoOferta>();
		for (Object[] object : daoDizimoOferta.listCompleta()) {
			DizimoOferta df = new DizimoOferta();
			Pessoa p = new Pessoa();
			df.setId_dizimo_oferta((Integer) object[0]);
			df.setData_dizimo_oferta((Date) object[1]);
			boolean diz = (Boolean) object[2];
			df.setDizimo(diz);
			float vv = (Float) object[3];
			df.setValor(vv);
			p.setNome_pessoa((String) object[4]);
			AuxDizimoOferta auxOferta = new AuxDizimoOferta();
			auxOferta.setPessoa(p);
			auxOferta.setDizimoOferta(df);
			listaAux.add(auxOferta);
		}
		//Collections.sort(listaAux);
		model.addAttribute("listaDizimo", listaAux);

		return "dizimo/listDizimo";
	}

	@RequestMapping(value = "/salvaDizimoOferta", method = RequestMethod.POST)
	public @ResponseBody String salvaDizimoOferta(@RequestBody String text) {
		JSONObject obj = new JSONObject(text);
		Pessoa p = daoPessoa.get(obj.getInt("id_membro"));
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(p);
		DizimoOferta df = new DizimoOferta();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		df.setDizimo(obj.getBoolean("dizimo"));
		df.setPessoa(pessoas);
		String valor = obj.getString("valor");
		float off = Float.parseFloat(valor);
		df.setValor(off);
		try {
			Date data2 = formato.parse(obj.getString("data_dizimo_oferta"));
			df.setData_dizimo_oferta(data2);
			daoDizimoOferta.persistir(df);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// System.out.println(data_dizimo_oferta + valor + id_membro + dizimo);
		return p.getNome_pessoa();
	}

}
