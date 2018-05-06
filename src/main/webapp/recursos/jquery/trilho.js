$(document).ready(
		function() {
			var id_pessoa;
			var lista;
			var dados;
			$("#btn_novaBusca").hide();
			$("#btn_novaBusca").click(function(){
				$("#btn_novaBusca").hide();
				$("#btn_busca").show();
				$("select").val("");
				$.each($('#tabela_trilho tr'),function(o, index) {
					$('#tabela_trilho tr[class]').remove();
				});
			});
			
			
			$("#btn-update").click(function() {
				var string = [];
				string = enviaUpdate();
				string = '{"id":'+'"'+id_pessoa+'"'+','+'"trilho":['+string+']}';
				
				$.ajax({
					url : "updateTrilho",
					type : "POST",
					contentType : "application/json; charset=utf-8",
					data : string.toString(),
					dataType : "text",
					success : function(data) {
						alert("Atualizado");
						window.location.reload();
					}
				});

			});		
			
			$("#btn_busca").click(function() {
				id_pessoa = $("select").val();
				enviaId(id_pessoa);
			});
			//funçao que converte tabela para json
			function enviaUpdate() {
				var json=[];
				$("#tabela_trilho tr:has(td)").each(function() {
					var $td =  $('td', this);
					var obj = new Object();
					var stat = $td.eq(2).find("input");
					
					obj.id= $td.eq(0).text();
					obj.nome= $td.eq(1).text();
					obj.status= stat.is(":checked");
										
				  var text = JSON.stringify(obj);
				  json.push(text);
                  
				});
				return json;
			}

			function comparar() {
			}

			function enviaId(id) {
				$.ajax({
					url : "detalhesTrilho",
					type : "POST",
					contentType : "application/json; charset=utf-8",
					data : id,
					dataType : "text",
					success : function(data) {
						var obj = JSON.parse(data);
						// alert(obj.toString());
						var status = "<input type='checkbox' checked='checked'>";
						var noStatus ="<input type='checkbox' >";
						obj.forEach(function(o, index) {
							
							$("#btn_busca").hide();
							$("#btn_novaBusca").show();
							if (o.status) {
								$('#tabela_trilho').append(
										'<tr class="remove"><td>' + o.id + '</td><td>'
												+ o.trilho + '</td><td>'
												+ status + '</td></tr>');
							} else {
								$('#tabela_trilho').append(
										'<tr class="remove"><td>' + o.id + '</td><td>'
												+ o.trilho + '</td><td>'
												+ noStatus+ '</td></tr>');
							}

						});
					}
				});
			}

		});