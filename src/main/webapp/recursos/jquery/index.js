$(document).ready(
		function() {
			/*// celulaSemana
			$("#adicionaMembro").click(
					function() {
						var obj = new Object();
						var nome_membro = $('#membro').text();
						var id_membro = $('#id_membro').val();
						var nome_visitante = $('#visitante').text();
					
						obj.data_celula = $('#data_celula').val();
						obj.semana = $('#semana').val();
						obj.tot_criancas = $('#tot_criancas').val();
						obj.tot_pessoas = $('#tot_pessoas').val();
						obj.ofertas = $('#ofertas').val();
						obj.tot_pessoas_culto = $('#tot_pessoas_culto').val();
						obj.id_membro = $('#id_membro').val();
						obj.id_celula = $('#id_celula').val();
						var text = JSON.stringify(obj);
												$.ajax({
							url : "salvaCelulaSemana",
							type : "POST",
							contentType : "application/json; charset=utf-8",
							data : text,
							dataType : "text",
							success : function(data) {
								$('#membrosAdicionados').append(
										'<tr><td>' + id_membro + '</td><td>'
												+ data + '</td></tr>');
							}
						});

					});
			 adicionaVisitante 
			// celulaSemana
			$("#adicionaVisitante").click(
					function() {
						var obj = new Object();
						var nome_membro = $('#membro').text();
						var nome_visitante = $('#nome_visitante').val();

						obj.data_celula = $('#data_celula').val();
						obj.semana = $('#semana').val();
						obj.tot_criancas = $('#tot_criancas').val();
						obj.tot_pessoas = $('#tot_pessoas').val();
						obj.ofertas = $('#ofertas').val();
						obj.tot_pessoas_culto = $('#tot_pessoas_culto').val();
						obj.nome_visitante = $('#nome_visitante').val();
						obj.id_celula = $('#id_celula').val();
						var text = JSON.stringify(obj);
						$.ajax({
							url : "salvaCelulaSemanaVisitante",
							type : "POST",
							contentType : "application/json; charset=utf-8",
							data : text,
							dataType : "text",
							success : function(data) {
								
								$('#visitantesAdicionados').append(
										'<tr><td>' + data + '</td></tr>');
							}
						});

					});*/
			
			/*adicionaDizimoOferta */
			$("#adicionaDizimoOferta").click(
					function() {
						var obj = new Object();
						var valor = $('#valor').val();
						var datas = $('#data_dizimo_oferta').val();

						obj.data_dizimo_oferta = $('#data_dizimo_oferta').val();
						obj.valor = $('#valor').val();
						obj.id_membro = $('#id_membro').val();
						obj.dizimo = $("input[name='dizimo']:checked").val();
						var text = JSON.stringify(obj);
					
						$.ajax({
							url : "salvaDizimoOferta",
							type : "POST",
							contentType : "application/json; charset=utf-8",
							data : text,
							dataType : "text",
							success : function(data) {
								
								
								$('#membrosAdicionados').append(
										'<tr><td>' + data + '</td><td>'
												+ datas + '</td><td>' + valor + '</td></tr>');
							}
						});

					});

			
			var contador = 1;

			$('#pessoaCelula').click(
					function() {
						var id_membro = $('#id_pessoa').val();
						var id_celula = $('#id_celula').val();

						var arrayObj = new Array();
						var obj = new Object();

						obj.idMembro = id_membro;
						obj.idCelula = id_celula;

						// var text=jQuery.parseJSON(arrayObj);
						var text = JSON.stringify(obj);
					$.ajax({
							url : "salvaPessoaNaCelula",
							type : "POST",
							contentType : "application/json; charset=utf-8",
							data : text,
							dataType : "text",
							success : function(data) {
								$('#membrosAdicionados').append(
										'<tr><td>' + id_membro + '</td><td>'
												+ data + '</td></tr>');
							}
						});
					});

			// Remove o item da tabela
			function removeLinha(row) {
				$(row).parent().parent().remove();
			}
			$(function() {
				$(".dateP").datepicker({
					dateFormat : 'dd/mm/yy',
					changeMonth : true,
					changeYear : true,
					minDate: new Date(1900,1-1,1)
				});
			});
			

		});