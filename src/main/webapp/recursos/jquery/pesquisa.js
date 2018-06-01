$(document).ready(function() {
	//$("#pp").hide();
	var lista = [];
	var bb = false;
	// carrega todos os nomes da tabela na lista
	function myFunction() {
		$("#tabelaMembros td[id]").each(function() {
			var nomes = $(this).text();
			lista.push(nomes);
		});
	}
	function formatDate(value)
	{
	   return value.getMonth()+1 + "/" + value.getDate() + "/" + value.getYear();
	}
	
	$(".det").click(function() {
		var campo = $(this);
		var pai = $(this).parent();
		var id = pai.find("td[class=ident]").text();
		buscaDetalhesMembros(id);
	});
	
	function buscaDetalhesMembros(id) {// funcao de busca detalhes de Membros no banco
		var data;
		$.ajax({
			url : "detalhesMembros",
			type : "POST",
			contentType : "application/json; charset=utf-8",
			data : id,
			dataType : "text",
			success : function(data) {
				
				var obj = new Object();
				obj = JSON.parse(data);
				$("#nome_pessoa").text(obj.nome);
				$("#dt_nas").text(obj.data_nascimento);
				$("#endereco").text(obj.endereco);
				$("#tel_whats").text(obj.telWhats);
				$("#tel_resid").text(obj.telRes);
				$("#pai").text(obj.pai);
				$("#mae").text(obj.mae);
				$("#conjugue").text(obj.nome_conjugue);
				$("#bPor").text(obj.batizado_por);
				$("#chegada").text(obj.chegaIgreja);
				$("#cargo").text(obj.cargos);
				if(obj.celula == true){
					$("#celula").text("Sim");
				}else{
					$("#celula").text("Sim");
				}
				
				$("#pp").dialog({
					width : 1200,
					height : 600,
					modal : true,
					title: 'Detalhes do Membro',
					buttons : {
						"Fechar" : function() {
							$(this).dialog("close");
							
						}
					}				
				});
				
				$('.ui-dialog-titlebar-close').hide();

			}
		});
	}
	
	$(".edit").click(function() {
		var campo = $(this);
		var pai = $(this).parent();
		var id = pai.find("td[class=ident]").text();
		editaMembros(id);
	});
	
	function editaMembros(id) {//funcao para chamar modal de edicao
		var data;
		$.ajax({
			url : "detalhesMembros",
			type : "POST",
			contentType : "application/json; charset=utf-8",
			data : id,
			dataType : "text",
			success : function(data) {
				 	
				var obj = new Object();
				obj = JSON.parse(data);
				$("#nome_pessoaEdit").val(obj.nome);
				$("#dt_nasEdit").val(obj.data_nascimento);
				$("#enderecoEdit").val(obj.endereco);
				$("#tel_whatsEdit").val(obj.telWhats);
				$("#tel_residEdit").val(obj.telRes);
				$("#paiEdit").val(obj.pai);
				$("#maeEdit").val(obj.mae);
				$("#conjugueEdit").val(obj.nome_conjugue);
				$("#bPorEdit").val(obj.batizado_por);
				$("#chegadaEdit").val(obj.chegaIgreja);
				//$("#cargoEdit").val(obj.cargos);
				if(obj.celula == true){
					$("#celulaEdit").val("Sim");
				}else{
					$("#celulaEdit").val("Sim");
				}
				console.log(obj);
				$("#edicao").dialog({
					width : 1200,
					height : 600,
					modal : true,
					title: 'Edicao de Membro',
					buttons : {
						"Salvar Mudancas": function(){
							console.log("salvar mudancas");
						},
						"Fechar" : function() {
							$(this).dialog("close");
							
						}
						
					}				
				});
				
				$('.ui-dialog-titlebar-close').hide();

			}
		});
	}

	
	$(document).keyup(function(e) {
		if (e.keyCode == 27) {
			$("#tabelaMembros tr:not(.sub)").show();	
			$("#tabelaMembros tr").removeClass("sub");
			$("#completaNome").val("");

		}
	});
	
	$("#p_complete").click(function() {// quando apertar na lupa
		var nome = $("#completaNome").val();
		$("#tabelaMembros td[id]").each(function() {
			var nomes = $(this).text();
			var pai = $(this).parent();
			
			if (nomes == nome) {
				pai.addClass("sub");
				
			}
		});
		$("#tabelaMembros tr:first").addClass("sub");
		$("#tabelaMembros tr:not(.sub)").hide();
	});
	myFunction();
	$("#completaNome").autocomplete({
		source : lista
	});
	
	
	

});