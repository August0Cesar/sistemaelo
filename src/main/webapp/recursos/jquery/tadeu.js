$(document).ready(
		function() {
$("#btn_tadeu").click(
					function() {

						var id_membro = $('#id_pessoa').val();
						var coment = $('#comentario').val();
						var data = $('#data_nasc').val();
						var total_dizimo = $('#total_dizimo').val();
						var total_pessoas = $('#total_pessoas').val();
						var total_oferta = $('#total_oferta').val();
						var valida = true;
						
						var arrayObj = new Array();
						var obj = new Object();

						
						obj.total_dizimo = total_dizimo;
						obj.total_pessoas = total_pessoas;
						obj.data_nascimento = data;
						obj.comentario = coment;
						obj.total_oferta = total_oferta;
						if(total_dizimo == ""){
							valida = false;
							alert("CAMPO Total de dizimo nao pode estar VAZIO");
						}
						if(total_oferta == ""){
							valida = false;
							alert("CAMPO Total de oferta nao pode estar VAZIO");
						}
						if(total_pessoas == ""){
							valida = false;
							alert("CAMPO Total de pessoas nao pode estar VAZIO");							
						}
						
						
						var text = JSON.stringify(obj);
						if(valida){
							$.ajax({
								url : "salvaTadeu",
								type : "POST",
								contentType : "application/json; charset=utf-8",
								data : text,
								dataType : "text",
								success : function(data) {
									alert("Cadastrado com sucesso");
								}
							});
						}
					});

		});