package br.com.augusto.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.augusto.controller.entidade.ListTrilho;
import br.com.augusto.controller.entidade.Pessoa;
import br.com.augusto.controller.entidade.Tadeu;
import br.com.augusto.controller.entidade.TrilhoLideranca;
import br.com.augusto.dao.jpa.JPACelulas;
import br.com.augusto.dao.jpa.JPAListTrilho;
import br.com.augusto.dao.jpa.JPAPessoa;
import br.com.augusto.dao.jpa.JPATadeu;
import br.com.augusto.dao.jpa.JPATrilhoLideranca;
import br.com.augusto.dto.TadeuDTO;
import br.com.augusto.model.AuxTadeu;
import br.com.augusto.tools.ToolsDate;

@Transactional
@Controller
public class TadeuController {
	@Autowired
	JPAPessoa daoPessoa;
	@Autowired
	JPATrilhoLideranca daoTrilhoLideranca;
	@Autowired
	JPAListTrilho daoListTrilho;
	@Autowired
	JPATadeu daoTadeu;

	@RequestMapping(value = "/cadastroTadeu")
	public String cadastroTadeu() {

		return "tadeu/formTadeu";
	}

	// @ModelAttribute(value = "minhaLista")
	@RequestMapping(value = "salvaTadeu", method = RequestMethod.POST)
	public @ResponseBody String salvaCheckList(@RequestBody String text) {
		float total_oferta = 0;
		float total_dizimo = 0;
		int total_pessoas = 0;
		String comentario = "";
		String data = "";
		JSONObject obj = new JSONObject(text);
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		try {
			data = obj.getString("data_nascimento") == null ? Calendar.getInstance().toString():obj.getString("data_nascimento");
			total_oferta = obj.getString("total_oferta") == null ? 0 : Float.parseFloat(obj.getString("total_oferta"));
			total_dizimo = obj.getString("total_dizimo") == null ? 0 : Float.parseFloat(obj.getString("total_dizimo"));
			total_pessoas = obj.getString("total_pessoas") == null ? 0 : obj.getInt("total_pessoas");
			comentario = obj.getString("comentario")==null ? "vazio":obj.getString("comentario");
			
			Tadeu tadeu = TadeuDTO.convertTadeu(new TadeuDTO(ToolsDate.stringForDate(data),comentario,total_dizimo,total_oferta,total_pessoas));
			daoTadeu.persistir(tadeu);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "sucesso";
	}

	@RequestMapping("/listaTadel")
	public String todosMembros(Model model) {
		List<Tadeu> tadels = new ArrayList<Tadeu>();
		tadels = daoTadeu.list();
		model.addAttribute("tadels", tadels);
		return "tadeu/listTadel";
	}

	@RequestMapping("/tadelbuscaData")
	public String tadeuBusca() {
		return "tadeu/membrosPorTadeu";
	}

	@RequestMapping("/tadelPorPeriodo")
	public String tadelPorPeri() {
		return "tadeu/form-tadeu-periodo";
	}

	@RequestMapping("/tadelData")
	public String todosMembros(@RequestParam String data, Model model) {

		List<Object[]> list = daoTadeu.porPeriodo(data);
		if (list.isEmpty()) {
			return "vazio/naoDados";
		} else {
			// lista que vai ser retornada pelo método
			List<Pessoa> pessoas = new ArrayList<Pessoa>();
			List<Tadeu> tadels = new ArrayList<Tadeu>();
			Pessoa p = new Pessoa();
			Tadeu t = new Tadeu();

			for (Object[] object : list) {
				Pessoa p1 = new Pessoa();
				Tadeu t1 = new Tadeu();
				t1.setId_tadeu((Integer) object[0]);
				t1.setComentario((String) object[1]);
				p1.setNome_pessoa((String) object[2]);
				t1.setData((Date) object[3]);
				pessoas.add(p1);
				tadels.add(t1);
			}
			t = tadels.get(0);

			model.addAttribute("pessoas", pessoas);
			model.addAttribute("t", t);
			return "tadeu/listTadelMembros";
		}
	}

	@RequestMapping("/todosMembrosTadeuPeriodo")
	public String todosVisitantesPeriodo(@RequestParam String dataInicio, @RequestParam String dataFinal, Model model) {
		List<Object[]> list = daoTadeu.visitantesPorPeriodo(dataInicio, dataFinal);
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		List<Tadeu> tadels = new ArrayList<Tadeu>();

		for (Object[] object : list) {

			Pessoa p = new Pessoa();
			Tadeu t = new Tadeu();
			t.setId_tadeu((Integer) object[0]);
			t.setComentario((String) object[1]);
			p.setNome_pessoa((String) object[2]);
			System.out.println(p.getNome_pessoa());
			t.setData((Date) object[3]);
			pessoas.add(p);
			tadels.add(t);
		}
		for (Pessoa p1 : pessoas) {
			System.out.println(p1.getNome_pessoa());
		}
		model.addAttribute("pessoas", pessoas);
		return "tadeu/listTadelMembrosPeriodo";
	}
}
