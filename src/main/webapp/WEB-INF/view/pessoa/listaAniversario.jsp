<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de usuarios</title>
<link rel="stylesheet" href="<c:url value="/recursos/css/main.css "/> ">
<link rel="stylesheet"
	href="<c:url value="/recursos/css/jquery-ui.css "/> ">
<link rel="stylesheet"
	href="<c:url value="/recursos/css/jquery-ui.theme.css "/> ">
<script src="<c:url value="/recursos/jquery/jquery-3.1.1.min.js" />"></script>
<script src="<c:url value="/recursos/js/bootstrap.js" />"></script>
<script src="<c:url value="/recursos/js/jquery.tabletojson.js" />"></script>
<script src="<c:url value="/recursos/jquery/jquery-ui.js" />"></script>
<script src="<c:url value="/recursos/jquery/index.js" />"></script>
<script src="<c:url value="/recursos/jquery/pesquisa.js" />"></script>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Culto</title>
<link rel="stylesheet" href="<c:url value="/recursos/css/main.css "/> ">
</head>
<body>
	<!-- onLoad="myFunction()" -->
	<div id="pp" class="principal"
		style="display: none; width: 600px; height: 100%;">
		<div class="row">
			<div class="col-sm-4 image-perfil text-center">
				<img alt="imagem_perfil"
					src="<c:url value="/recursos/imagens/images.png" />"
					id="foto-perfil" class="text-center">
				<h2 class="text-center grey">Membro</h2>
			</div>

			<div class="col-sm-8">
				<h2 id="nome_pessoa">Augusto César da Cunha Matos</h2>
				<hr>
				<h4 class="grey">Dados</h4>
				<div class="row">
					<div class="col-sm-3">
						<label>Data de Nascimento:</label><br> <label>Endereço:</label><br>
						<label>Tel.Whats:</label><br> <label>Tel.Residencia:</label>
					</div>
					<div class="col-xs-8 text-left">
						<p id="dt_nas">09/01/1990</p>
						<p id="endereco">Rua São Mateus 511</p>
						<p id="tel_whats">98888-8888</p>
						<p id="tel_resid">3333-3333</p>
						<br>
					</div>
				</div>
				<hr>
				<h4 class="grey">Filiação</h4>
				<div class="row">
					<div class="col-sm-3">
						<label>Nome Pai:</label><br> <label>Nome Mãe:</label> <br>
						<label>Nome Conjugue:</label>
					</div>
					<div class="col-xs-8 text-left">
						<p id="pai">Sebastião Donizetti de Matos</p>
						<p id="mae">Maria de Lourdes Ferreira da Cunha</p>
						<p id="conjugue">Ana Paula Potente Cunha Matos</p>
						<br>
					</div>
				</div>
				<hr>
				<h4 class="grey">Cargos</h4>
				<div class="row">
					<div class="col-sm-3">
						<label>Nome Cargo:</label> <label>Chegada a Igreja:</label>
					</div>
					<div class="col-xs-8 text-left">
						<p id="cargo">Lider de Célula</p>
						<p id="chegada"></p>
					</div>
				</div>

				<hr>
				<h4 class="grey">Batismo</h4>
				<div class="row">
					<div class="col-sm-3">
						<label>Batizado por:</label><br> <label>Pertence
							alguma Célula:</label>
					</div>
					<div class="col-xs-8 text-left">
						<p id="bPor">Carlos</p>
						<p id="celula">Sim</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Sistema Elo</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="home">Home</a></li>
				<li><a href="membrosVisitantes">Membros e Visitantes</a></li>
				<li><a href="cadastroCargo">Cadastro de Cargos</a></li>
				<li><a href="tadel">Tadel</a></li>
				<li><a href="celula">Célula</a></li>
				<li><a href="trilhoLideranca">Trilho de Liderança</a></li>
				<li><a href="culto">Culto</a></li>
				<li><a href="dizOferta">Dizimos e Ofertas</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="logout"><span class="glyphicon glyphicon-user"></span>
						Sign Up</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
						Login</a></li>
			</ul>
		</div>
	</nav>
	<!-- Menu Vertical -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-12 main">
				<span class="glyphicon glyphicon-menu-hamburger"
					data-toggle="collapse" data-target="#demo" style="font-size: 35px"></span>
			</div>
			<div class="col-sm-3 col-md-2 sidebar collapse" id="demo">
				<ul class="nav nav-sidebar">
					<li><a href="cadastroMembro">Cadastro de Membros <span
							class="sr-only">(current)</span>
					</a></li>
					<li><a href="cadastroVisitante">Cadastro de Visitantes</a></li>
					<li><a href="todosMembros">Todos os membros</a></li>
					<li><a href="todosVisitantes">Todos os Visitantes</a></li>
					<li><a href="visitantesPorPeriodo">Visitantes Por período</a></li>
					<li><a href="membrosPorPeriodo">Membros Por período</a></li>
				</ul>

			</div>

			<div class="col-sm-12 main">
				<h2>Todos os Aniversariantes</h2>
				<div class="input-group">
					<span class="input-group-addon" id="p_complete"><i
						class="glyphicon glyphicon-search"></i></span> <input name="nome_pessoa"
						id="completaNome" placeholder="Pesquisa Nome" class="form-control"
						type="text">
				</div>
				<table class="table table-striped" id="tabelaMembros">
					<tr class="sub">
						<th>Nome</th>
						<th>Data-Nascimento</th>
					</tr>
					<c:forEach items="${pessoas}" var="pessoa">
						<tr>
							<td id="nomes">${pessoa.nome_pessoa}</td>
							<td><fmt:formatDate value="${pessoa.data_nascimento}"
									pattern="dd/MM/yyyy" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		//DEFER="DEFER"

		// Chamada da função
		//myFunction();
	</script>
</body>
</html>