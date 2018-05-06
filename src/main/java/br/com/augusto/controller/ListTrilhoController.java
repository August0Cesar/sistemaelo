package br.com.augusto.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.augusto.controller.entidade.ListTrilho;
import br.com.augusto.controller.entidade.Pessoa;
import br.com.augusto.controller.entidade.TrilhoLideranca;
import br.com.augusto.dao.jpa.JPAListTrilho;
import br.com.augusto.dao.jpa.JPAPessoa;
import br.com.augusto.dao.jpa.JPATrilhoLideranca;
import br.com.augusto.model.AuxListTrilho;

@Transactional
@Controller
public class ListTrilhoController {
	@Autowired
	JPAPessoa daoPessoa;
	@Autowired
	JPATrilhoLideranca daoTrilhoLideranca;
	@Autowired
	JPAListTrilho daoListTrilho;

	@RequestMapping("/fazCheckList")
	public String fazCheckList(Model model) {
		model.addAttribute("pessoas", daoPessoa.list());
		model.addAttribute("trilhos", daoTrilhoLideranca.list());
		return "listTrilho/formCheckList";
	}

	@RequestMapping("/statusPorTrilho")
	public String statusPorTrilho(Model model) {
		model.addAttribute("pessoas", daoPessoa.list());
		model.addAttribute("trilhos", daoTrilhoLideranca.list());
		return "listTrilho/formPessoaPorTrilho";
	}

	@RequestMapping("/salvaCheckList")
	public String salvaCheckList(ListTrilho listTrilho, @RequestParam Integer id_pessoa,
			@RequestParam Integer id_trilho_lideranca) {
		Pessoa pessoa = new Pessoa();
		TrilhoLideranca t = new TrilhoLideranca();
		pessoa.setId_pessoa(id_pessoa);
		t.setId_trilho_lideranca(id_trilho_lideranca);
		listTrilho.setPessoa3(pessoa);
		listTrilho.setTrilhoLideranca(t);
		listTrilho.setData_cadastro(Calendar.getInstance().getTime());
		daoListTrilho.persistir(listTrilho);
		return "redirect:fazCheckList";
	}

	@RequestMapping("/geralTrilho")
	public String geralTrilho(Model model) {

		List<ListTrilho> lista = new ArrayList<ListTrilho>();
		List<AuxListTrilho> listaAux = new ArrayList<AuxListTrilho>();
		lista = daoListTrilho.list();
		for (ListTrilho l : lista) {
			TrilhoLideranca t = new TrilhoLideranca();
			Pessoa p = new Pessoa();
			AuxListTrilho ax = new AuxListTrilho();
			p = daoPessoa.get(l.getPessoa3().getId_pessoa());
			t = daoTrilhoLideranca.get(l.getTrilhoLideranca().getId_trilho_lideranca());
			ax.setListTrilho(l);
			ax.setPessoa(p);
			ax.setTrilhoLideranca(t);
			listaAux.add(ax);
		}

		Collections.sort(listaAux);
		model.addAttribute("listTrilho", listaAux);
		return "listTrilho/listGeral";
	}

	@RequestMapping("/statusPorPessoa")
	public String statusPorPessoa(Model model) {
		model.addAttribute("pessoas", daoPessoa.list());
		return "listTrilho/formTrilhoPessoa";
	}

	@RequestMapping("/bucsaPessoaId")
	public String bucsaId(Model model, Integer id_pessoa) {
		// System.out.println(id_pessoa);

		List<ListTrilho> lista = new ArrayList<ListTrilho>();
		List<AuxListTrilho> listaAux = new ArrayList<AuxListTrilho>();
		lista = daoListTrilho.list();
		for (ListTrilho l : lista) {
			TrilhoLideranca t = new TrilhoLideranca();
			Pessoa p = new Pessoa();
			AuxListTrilho ax = new AuxListTrilho();
			if (l.getPessoa3().getId_pessoa().equals(id_pessoa)) {
				p = daoPessoa.get(l.getPessoa3().getId_pessoa());
				t = daoTrilhoLideranca.get(l.getTrilhoLideranca().getId_trilho_lideranca());
				ax.setListTrilho(l);
				ax.setPessoa(p);
				ax.setTrilhoLideranca(t);
				listaAux.add(ax);
			}
		}

		Collections.sort(listaAux);
		model.addAttribute("listTrilho", listaAux);
		return "listTrilho/listaDetalhe";
	}

	@RequestMapping(value = "/detalhesTrilho", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody String detalhesTrilho(@RequestBody Integer id) {
		Pessoa pessoa = new Pessoa();
		pessoa.setId_pessoa(id);
		pessoa = daoPessoa.get(id);
		System.out.println(pessoa.getListTrilho().size());
		JSONArray b = new JSONArray();
		for (int i = 0; i < pessoa.getListTrilho().size(); i++) {
			JSONObject obj = new JSONObject();
			obj.put("id", pessoa.getListTrilho().get(i).getTrilhoLideranca().getId_trilho_lideranca());
			obj.put("status", pessoa.getListTrilho().get(i).isStatus());
			obj.put("trilho", pessoa.getListTrilho().get(i).getTrilhoLideranca().getNome_trilho_lideranca());
			b.put(obj);
		}

		return b.toString();
	}

	// Metodo que atualiza o Trilho de Liderança
	@RequestMapping(value = "/updateTrilho", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody String updateTrilho(@RequestBody String string) {
		JSONObject json = new JSONObject(string);
		String idPessoa = json.getString("id");
       
		JSONArray array = new JSONArray(json.getJSONArray("trilho").toString());
		Pessoa p = daoPessoa.get(Integer.parseInt(idPessoa));
		for (int i = 0; i < array.length(); i++) {
			JSONObject obj = (JSONObject) array.get(i);

			if (p.getListTrilho().get(i).getTrilhoLideranca().getId_trilho_lideranca() == obj.getInt("id")) {
				
				if ((Boolean) obj.get("status")) {
					p.getListTrilho().get(i).setStatus(true);
				} else {
					p.getListTrilho().get(i).setStatus(false);
				}
			}
		}
		return "ok";
	}

	@RequestMapping("/teste2")
	public String teste2(Integer id) {
		Pessoa pessoa = new Pessoa();
		pessoa.setId_pessoa(id);
		pessoa = daoPessoa.get(id);
		for (int i = 0; i < pessoa.getListTrilho().size() - 1; i++) {
			System.out.println("*******************\n");
			System.out.println(pessoa.getListTrilho().get(i).getTrilhoLideranca().getNome_trilho_lideranca() + "    ");
			System.out.println(pessoa.getListTrilho().get(i).isStatus() + "\n");
		}

		return "ttt";
	}

}
