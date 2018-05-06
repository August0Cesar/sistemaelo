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
	// funcao de busca detalhes de Membros no banco
	function buscaDetalhesMembros(id) {
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
	
	function editaMembros(id) {
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
				
				$("#manutencao").dialog({
					width : 1200,
					height : 600,
					modal : true,
					buttons : {
						"Fechar" : function() {
							$(this).dialog("close");
							
						}
					}				
				});
				
				/*$("#edicao").dialog({
					width : 1200,
					height : 600,
					modal : true,
					buttons : {
						"Fechar" : function() {
							$(this).dialog("close");
							
						}
					}				
				});*/
				
				$('.ui-dialog-titlebar-close').hide();

			}
		});
	}

	
	$(document).keyup(function(e) {
		if (e.keyCode == 27) {
			// alert('escape');.removeClass( "sub" );
			$("#tabelaMembros tr:not(.sub)").show();
			$("#tabelaMembros tr").removeClass("sub");
			$("#completaNome").val("");

		}
	});
	// quando apertar na lupa
	$("#p_complete").click(function() {
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
	// função chamar o dialog de
	// editar cadastro de membro
	$(".det").click(function() {
		var campo = $(this);
		var pai = $(this).parent();
		var id = pai.find("td[class=ident]").text();
		buscaDetalhesMembros(id);
	});
	$(".edit").click(function() {
		var campo = $(this);
		var pai = $(this).parent();
		var id = pai.find("td[class=ident]").text();
		editaMembros(id);
	});

});