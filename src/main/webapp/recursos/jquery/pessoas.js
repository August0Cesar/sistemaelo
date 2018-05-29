$(document).ready(function() {

	$("#btn_salvar_membro").click(function() {
		//var string = [];
		var obj = new Object();
		obj.nome = $("#nome_pessoa").val();
		obj.endereco = $("#endereco").val();
		obj.phoneWhats = $("#tel_whatsapp").val();
		obj.phoneRedidencia = $("#tel_residencia").val();
		obj.casado = $("input:radio[name=casado]:checked").val();
		obj.nomeConjugue = $("#nome_conjugue").val();
		obj.naturalidade = $("#naturalidade").val();
		obj.dataNascimento = $("#data_nascimento").val();
		obj.nomePai = $("#nome_pai").val();
		obj.nomeMae = $("#nome_mae").val();
		obj.pertenceCelula = $("input:radio[name=status_celula]:checked").val();
		obj.chegadaIgreja = $("#id_chegada_igreja").val();	
		obj.batizadoPor = $("#batizado_por").val();	
		var checkbox = $('input:checkbox[name^=cargos]:checked');
	    //verifica se existem checkbox selecionados
	    if(checkbox.length > 0){
	        //array para armazenar os valores
	        var val = [];
	        //função each para pegar os selecionados
	        checkbox.each(function(){
	            val.push($(this).val());
	        });
	     }else{
	    	 val = [];
	     }
	    obj.cargo = val;
		
		var tt = JSON.stringify(obj) + val;
		
		
		$.ajax({
			url : "salvaPessoa",
			type : "POST",
			contentType : "application/json; charset=utf-8",
			data : tt ,
			dataType : "text",
			success : function(data) {
				alert("Cadastrado com Sucesso");
				window.location.reload();
				
			}
		});		
	});
	/*function montaJson(){
		
		
		var obj2 = new Object();
		obj2.lider = $("input:checkbox[name=0]").is(':checked');
		obj2.lider_Treinamento = $("input:checkbox[name=1]").is(':checked');
		obj2.supervisorSetor = $("input:checkbox[name=2]").is(':checked');
		obj2.supervisorArea = $("input:checkbox[name=3]").is(':checked');
		obj2.discipulador = $("input:checkbox[name=4]").is(':checked');
		var teste = JSON.stringify(obj2);
		var lista = [];	
		
		lista.push(text);
		return lista;
	}*/

});