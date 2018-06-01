$(document).ready(
		function() {
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