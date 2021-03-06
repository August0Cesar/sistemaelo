<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<script src="<c:url value="/recursos/js/jquery.bootstrap.js" />"></script>
<script src="<c:url value="/recursos/js/bootstrap.js" />"></script>
<script src="<c:url value="/recursos/js/jquery.tabletojson.js" />"></script>
<script src="<c:url value="/recursos/jquery/jquery-ui.js" />"></script>
<script src="<c:url value="/recursos/jquery/index.js" />"></script>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Culto</title>
<link rel="stylesheet" href="<c:url value="/recursos/css/main.css "/> ">
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Sistema Elo</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="home">Home</a></li>
				<li><a href="membrosVisitantes">Membros e Visitantes</a></li>
				<li><a href="tadel">Tadel</a></li>
				<li><a href="celula">C�lula</a></li>
				<li><a href="trilhoLideranca">Trilho de Lideran�a</a></li>
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
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li><a href="cadastroCelulas">Cadastro de C�lulas</a></li>
					<li><a href="cadastroCelulaSemana">Cadastrar a C�lula da
							Semana</a></li>
					<li><a href="cadastroPessoaCelula">Cadastrar Pessoa na
							C�lula</a></li>
					<li><a href="listaCelulas">Lista C�lulas Existentes</a></li>
					<li><a href="listCelulasSemana">Lista C�lulas Semanais</a></li>
				</ul>
			</div>
			<div class="col-sm-9 main">
				<h2>Lista C�lulas Existentes</h2>

				<table class="table table-striped">
					<tr>

						<th>Nome</th>
						<th>Anfitri�o</th>
						<th>Endereco</th>
						<th>Lider</th>
						<th>Editar</th>
						<th>Remover</th>
					</tr>
					<c:forEach items="${celulas}" var="celula">
						<tr>
							<td>${celula.nome_celula}</td>
							<td>${celula.nome_anfitriao}</td>
							<td>${celula.endereco_celula}</td>
							<%-- <td><c:if test="${celula.celula_kids eq true} ">NAO KIDS</c:if></td> --%>
							<td>${celula.pessoa.nome_pessoa}</td>
							<td><a href="editCelulas?id=${celula.id_celula}"><i class="glyphicon glyphicon-edit"></i></a></td>
							<td><a href="removeCelulas?id=${celula.id_celula}"><i class="glyphicon glyphicon-remove"></i></a></td>


						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>