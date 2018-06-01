package br.com.augusto.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.servlet.ModelAndView;

import com.mchange.v2.lang.StringUtils;

import br.com.augusto.controller.entidade.Batismo;
import br.com.augusto.controller.entidade.Cargo;
import br.com.augusto.controller.entidade.ChegadaIgreja;
import br.com.augusto.controller.entidade.ListTrilho;
import br.com.augusto.controller.entidade.Pessoa;
import br.com.augusto.controller.entidade.Telefones;
import br.com.augusto.controller.entidade.TrilhoLideranca;
import br.com.augusto.dao.jpa.JPABatismo;
import br.com.augusto.dao.jpa.JPACargo;
import br.com.augusto.dao.jpa.JPAListTrilho;
import br.com.augusto.dao.jpa.JPAPessoa;
import br.com.augusto.dao.jpa.JPATelefones;
import br.com.augusto.dao.jpa.JPATrilhoLideranca;
import br.com.augusto.dto.MembroDTO;
import br.com.augusto.excell.MembrosExcell;
import br.com.augusto.tools.ToolsDate;
import ch.qos.logback.classic.Logger;

@Transactional
@Controller
public class PessoaController {
	List<Pessoa> pessoas = new ArrayList<Pessoa>();

	@Autowired
	JPAPessoa daoPessoa;
	@Autowired
	JPACargo daoCargo;
	@Autowired
	JPABatismo daoBatismo;
	@Autowired
	JPATelefones daoTelefones;
	JPATrilhoLideranca daoTrilhoLideranca;
	@Autowired
	JPAListTrilho daoListTrilho;
	
	 @RequestMapping(value="/membroExcell",method=RequestMethod.GET)
     public ModelAndView getExcel(){
           pessoas = daoPessoa.list();            
            return new ModelAndView(new MembrosExcell(), "studentList", pessoas);
     }

	@RequestMapping("/cadastroMembro")
	public String homepage(Model model) {// Model model
		model.addAttribute("cargos", daoCargo.list());
		return "pessoa/formMembro";
	}

	@RequestMapping("/cadastroVisitante")
	public String homevisite() {// Model model

		return "pessoa/formVisitante";
	}

	@RequestMapping(value = "/salvaPessoa", method = RequestMethod.POST,produces = "application/json")
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody String salvaPessoa(@RequestBody MembroDTO membro) {
		String[] teste = membro.getCargo();
		
		Pessoa p = new Pessoa();
		Batismo batismo = new Batismo();
		Telefones tel = new Telefones();
		
		if(membro.getBatizadoPor().equals("")||membro.getBatizadoPor() == null){
			batismo.setBatizado_por("nao sabe");
			batismo.setStatus_batismo(true);
		}else{
			batismo.setBatizado_por(membro.getBatizadoPor());
			batismo.setStatus_batismo(true);
		}
		p.setBatismo(batismo);
		//telefone
		if(membro.getPhoneWhats().equals("")||membro.getPhoneWhats() == null){
			tel.setTel_celular("nao tem");
			tel.setTel_whatsapp("nao tem");
			tel.setStatus("nao tem telefone");
			if(membro.getPhoneRedidencia().equals("")||membro.getPhoneRedidencia() == null){
			}else{
				tel.setTel_residencia(membro.getPhoneRedidencia());
			}
		}else{
			tel.setTel_celular(membro.getPhoneWhats());
			tel.setTel_whatsapp(membro.getPhoneWhats());
			if(membro.getPhoneRedidencia().equals("")||membro.getPhoneRedidencia() == null){
				tel.setTel_residencia("nao tem");
			}else{
				tel.setTel_residencia(membro.getPhoneRedidencia());
			}
			
		}
		p.setTelefones(tel);
		
		
		if(membro.getNome().equals("")||membro.getNome() == null){
			p.setNome_pessoa("nao tem nome");
		}else{
			p.setNome_pessoa(membro.getNome());
		}
		
		if(membro.getEndereco().equals("")||membro.getEndereco() == null){
			p.setEndereco("nao tem endereco");
		}else{
			p.setEndereco(membro.getEndereco());
		}
		
		if(membro.getCasado().equals("yes")){
			p.setCasado(true);
		}else{
			p.setCasado(false);
		}
		
		if(membro.getPertenceCelula().equals("true")){
			p.setStatus_celula(true);
		}else{
			p.setStatus_celula(false);
		}
		ChegadaIgreja ch = new ChegadaIgreja();
		if(membro.getChegadaIgreja().equals("1")){
			ch.setId(1);
		}else{
			ch.setId(2);
		}
		p.setChegadaIgreja(ch);
		if(membro.getNomeConjugue().equals("")||membro.getNomeConjugue() == null){
			p.setNome_conjugue("nao é casado");
		}else{
			p.setNome_conjugue(membro.getNomeConjugue());
		}
		
		if(membro.getNaturalidade().equals("")||membro.getNaturalidade() == null){
			p.setNaturalidade("nao tem");
		}else{
			p.setNaturalidade(membro.getNaturalidade());
		}
		
		if(membro.getNomeMae().equals("")||membro.getNomeMae() == null){
			p.setNome_conjugue("vazio");
		}else{
			p.setNome_mae(membro.getNomeMae());
		}
		
		if(membro.getNomePai().equals("")||membro.getNomePai() == null){
			p.setNome_pai("vazio");
		}else{
			p.setNome_pai(membro.getNomePai());
		}
		
		if(membro.getDataNascimento().equals("")||membro.getDataNascimento() == null){
			p.setData_nascimento(Calendar.getInstance().getTime());
		}else{
			try {
				p.setData_nascimento(ToolsDate.stringForDate(membro.getDataNascimento()));
			} catch (ParseException e) {
				e.getMessage();
			}
		}
		p.setData_cadastro(Calendar.getInstance().getTime());
		
		int id_cargo = 1;
		p.setMembro(true);
		if(!org.springframework.util.StringUtils.isEmpty(teste)) {
			List<Cargo> cargosList = new ArrayList<Cargo>();
			for(int i=0;i<teste.length;i++){
				Cargo car = new Cargo();
				car.setId_cargo(Integer.parseInt(teste[i]));
				cargosList.add(car);
				id_cargo ++;
			}
			p.setCargo(cargosList);
			
		}else {
			p.setCargo(null);
		}
		try {
			daoPessoa.persistir(p);
		} catch (Exception e) {
			e.getMessage();
		}
		
		
		for (int i = 1; i <= 19; i++) {
			ListTrilho trilho = new ListTrilho();
			TrilhoLideranca tr = new TrilhoLideranca();
			tr.setId_trilho_lideranca(i);
			trilho.setPessoa3(p);
			trilho.setStatus(false);
			trilho.setTrilhoLideranca(tr);
			trilho.setData_cadastro(Calendar.getInstance().getTime());
			daoListTrilho.persistir(trilho);
		}
		
		return "ok";
	}

	@RequestMapping("/salvaPessoaAntigo")
	public String salvaPessoaAntigo(Pessoa pessoa, String tel_whatsapp, String tel_residencia, Batismo batismo,
			@RequestParam Integer id_chegada_igreja, Integer id_cargo) {
		System.out.println(tel_residencia + tel_whatsapp);
		// seta batismo
		if (batismo.getBatizado_por().isEmpty()) {
			batismo = daoBatismo.get(2);
			pessoa.setBatismo(batismo);
		} else {
			batismo.setStatus_batismo(true);
			daoBatismo.persistir(batismo);
			Batismo bat = daoBatismo.buscaBatismo(batismo.getBatizado_por());
			pessoa.setBatismo(bat);
		}

		Telefones t = new Telefones();
		if (tel_residencia != null && tel_residencia != "") {
			t.setTel_residencia(tel_residencia);
			t.setStatus("possui telefone");
		} else {
			t.setTel_residencia(" ");
		}
		if (tel_whatsapp != null && tel_whatsapp != "") {
			t.setTel_celular(tel_whatsapp);
			t.setStatus("possui telefone");
		} else {
			t.setTel_celular(" ");
			t.setStatus("não possui telefone");
		}

		// pessoa.setChegadaIgreja(chegadaigreja);
		pessoa.setData_cadastro(Calendar.getInstance().getTime());
		pessoa.setTelefones(t);
		pessoa.setDiscipulado_inicial(false);
		pessoa.setMembro(true);
		pessoa.setTermino_discipulado_inicial(false);
		ChegadaIgreja chegadaIgreja = new ChegadaIgreja();
		chegadaIgreja.setId(id_chegada_igreja);
		pessoa.setChegadaIgreja(chegadaIgreja);
		Cargo c = new Cargo();
		if (id_cargo != null) {
			c.setId_cargo(id_cargo);
			List<Cargo> cargos = new ArrayList<Cargo>();
			cargos.add(c);
			pessoa.setCargo(cargos);
		}

		daoPessoa.persistir(pessoa);
		Pessoa p = daoPessoa.encontraPessoa(pessoa);
		System.out.print(p.getId_pessoa());
		for (int i = 1; i <= 19; i++) {
			ListTrilho trilho = new ListTrilho();
			TrilhoLideranca tr = new TrilhoLideranca();
			tr.setId_trilho_lideranca(i);
			trilho.setPessoa3(p);
			trilho.setStatus(false);
			trilho.setTrilhoLideranca(tr);
			trilho.setData_cadastro(Calendar.getInstance().getTime());
			daoListTrilho.persistir(trilho);
		}
		return "redirect:/membrosVisitantes";
	}

	@RequestMapping("/salvaVisitante")
	public String salvaVisitante(Pessoa pessoa, Telefones telefone, @RequestParam Integer id_chegada_igreja) {

		System.out.print(id_chegada_igreja);
		if (telefone.getTel_whatsapp().isEmpty() && telefone.getTel_residencia().isEmpty()) {
			telefone.setId_telefone(1);
			pessoa.setTelefones(telefone);
			System.out.print("nao tem telefone");
		} else {
			// set o status e salva o telefone
			telefone.setStatus("tem telefone");
			daoTelefones.persistir(telefone);
			// busca o tele fone e set no objeto pessoa
			Telefones tel = daoTelefones.buscaTelefone(telefone.getTel_whatsapp());
			pessoa.setTelefones(tel);
		}
		// seta batismo
		Batismo batismo = new Batismo();
		batismo = daoBatismo.get(1);
		pessoa.setBatismo(batismo);

		// pessoa.setChegadaIgreja(chegadaigreja);
		pessoa.setData_cadastro(Calendar.getInstance().getTime());
		pessoa.setDiscipulado_inicial(false);
		pessoa.setMembro(false);
		pessoa.setVisitante(true);
		pessoa.setTermino_discipulado_inicial(false);
		ChegadaIgreja chegadaIgreja = new ChegadaIgreja();
		chegadaIgreja.setId(id_chegada_igreja);
		pessoa.setChegadaIgreja(chegadaIgreja);
		// System.out.print(pessoa.getTelefones().getStatus());

		daoPessoa.persistir(pessoa);
		return "redirect:/membrosVisitantes";
	}

	@RequestMapping("/removePessoa")
	public String removeUsuario(int id) {
		System.out.print("passei aqui /n" + id); // Usuario usuario =
		Pessoa p = daoPessoa.get(id);
		
		daoPessoa.excluir(p);
		return "redirect:nomeMembros";

	}

	@RequestMapping("/todosMembros")
	public String todosMembros(Model model) {
		pessoas = daoPessoa.todosmenbros();
		model.addAttribute("pessoas", pessoas);
		return "pessoa/listaMembros";
	}

	@RequestMapping("/nomeMembros")
	public String nomeMembros(Model model) {
		pessoas = daoPessoa.nomeMenbros();
		model.addAttribute("pessoas", pessoas);
		return "pessoa/listaMembros";
	}

	@RequestMapping("/todosVisitantes")
	public String todosVisitantes(Model model) {
		pessoas = daoPessoa.todosVisitantes();
		model.addAttribute("pessoas", pessoas);
		return "pessoa/listaVisitantes";
	}

	@RequestMapping("/visitantesPorPeriodo")
	public String visitantesPeriodo() {
		return "pessoa/form-vit-periodo";
	}

	@RequestMapping("/membrosPorPeriodo")
	public String membrosPeriodo() {
		return "pessoa/form-memb-periodo";
	}

	@RequestMapping("/todosVisitantesPeriodo")
	public String todosVisitantesPeriodo(@RequestParam String dataInicio, @RequestParam String dataFinal, Model model) {
		pessoas = daoPessoa.visitantesPorPeriodo(dataInicio, dataFinal);
		model.addAttribute("pessoas", pessoas);
		return "pessoa/lista-vit-periodo";
	}

	@RequestMapping("/todosMembrosPeriodo")
	public String todosMembrosPeriodo(@RequestParam String dataInicio, @RequestParam String dataFinal, Model model) {
		pessoas = daoPessoa.membrosPorPeriodo(dataInicio, dataFinal);
		model.addAttribute("pessoas", pessoas);
		return "pessoa/lista-memb-periodo";
	}

	@RequestMapping("/teste")
	public String teste() {
		Pessoa p = new Pessoa();
		p = daoPessoa.get(3);
		System.out.print(p.getNome_pessoa());
		Cargo c = new Cargo();
		c.setId_cargo(1);
		List<Cargo> cargos = new ArrayList<Cargo>();
		cargos.add(c);
		p.setCargo(cargos);
		daoPessoa.persistir(p);
		return "succes";
	}

	@RequestMapping("/busca")
	public String buscaTeste() {
		Pessoa p = new Pessoa();
		p = daoPessoa.get(3);
		return "succes";
	}

	@RequestMapping(value = "/detalhesMembros", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody String detalhesMembros(@RequestBody Integer id) {//detalhes dos membros
		System.out.println(id);
		// Integer ids = Integer.parseInt(id);
		Pessoa p = daoPessoa.get(id);
		JSONObject obj = new JSONObject();
		obj.put("nome", p.getNome_pessoa());
		obj.put("id", p.getId_pessoa());
		obj.put("casado", p.isCasado());
		if (p.isCasado()) {
			obj.put("nome_conjugue", p.getNome_conjugue());
		} else {
			obj.put("nome_conjugue", "nao é casado(a)");
		}
		SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy");

		String d = formato2.format(p.getData_nascimento());
		obj.put("chegaIgreja", p.getChegadaIgreja().getNome_chegada());
		obj.put("data_nascimento", d);
		obj.put("endereco", p.getEndereco());
		obj.put("nauralidade", p.getNaturalidade());
		obj.put("pai", p.getNome_pai());
		obj.put("mae", p.getNome_mae());
		obj.put("celula", p.isStatus_celula());
		obj.put("chegada_igreja", p.getChegadaIgreja().getId());

		if (p.getTelefones().getTel_celular()==null) {
			obj.put("telWhats", "não possui");
			obj.put("telRes", "não possui");
		} else {
			obj.put("telWhats", p.getTelefones().getTel_celular());
			obj.put("telRes", p.getTelefones().getTel_residencia());
		}

		obj.put("batizado_por", p.getBatismo().getBatizado_por());
		List<String> ll = new ArrayList<String>();
		for (Cargo c : p.getCargo()) {
			System.out.println(c.getNome_cargo());
			ll.add(c.getNome_cargo());
		}
		if (ll.size() == 0) {
			obj.put("cargos", "não possui cargo");
		} else {
			obj.put("cargos", ll);

		}
		String json = obj.toString();
		System.out.print(json);
		return json;
	}

	// abre o formulario para buscar aniversariantes do mês
	@RequestMapping("/mesAniver")
	public String mesAniver() {
		return "pessoa/formAniver";
	}

	// retorna a lista de aniversariantes do mês
	@RequestMapping(value = "/listaAniversariantes", method = RequestMethod.POST)
	public String listaAniversariantes(int numberMes, Model model) {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas = daoPessoa.buscaAniversariantes(numberMes);
		model.addAttribute("pessoas", pessoas);
		return "pessoa/listaAniversario";
	}

}
