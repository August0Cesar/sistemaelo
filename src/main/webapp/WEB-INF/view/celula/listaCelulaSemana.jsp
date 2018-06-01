<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Celulas</title>
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
				<li><a href="celula">Célula</a></li>
				<li><a href="trilhoLideranca">Trilho de Liderança</a></li>
				<li><a href="culto">Culto</a></li>
				<li><a href="dizOferta">Dizimos e Ofertas</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="logout"><span class="glyphicon glyphicon-user"></span>
						Sair</a></li>
			</ul>
		</div>
	</nav>
	<!-- Menu Vertical -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2 sidebar">
				<ul class="nav nav-sidebar">
					<li><a href="cadastroCelulas">Cadastro de Células</a></li>
					<li><a href="cadastroCelulaSemana">Cadastrar a Célula da
							Semana</a></li>
					<li><a href="cadastroPessoaCelula">Cadastrar Pessoa na
							Célula</a></li>
					<li><a href="listaCelulas">Lista Células Existentes</a></li>
					<li><a href="listCelulasSemana">Lista Células Semanais</a></li>
				</ul>
			</div>
			<div class="col-sm-10 main">
				<h2>Lista Células Semanais</h2>

				<table class="table table-striped">
					<tr>

						<th>Nome da célula</th>
						<th>Semana</th>
						<th>Data da Célula</th>
						<th>Total Crianças</th>
						<th>Total Membros</th>
						<th>Total Visitantes</th>
						<th>Total Pessoas na Célula</th>
						<th>Total Pessoas no Culto</th>
						<th>Total Pessoas no Tadel</th>
						<th>Total Pessoas no GE</th>
						<th>Oferta</th>
					</tr>
					<c:forEach items="${celulas}" var="celula">
						<tr>
							<td>${celula.celula.nome_celula}</td>
							<td>${celula.celulaSemana.semana}</td>
							<td><a href="#"><fmt:formatDate
										value="${celula.celulaSemana.data_celula}"
										pattern="dd/MM/yyyy" /></a></td>
							<td>${celula.celulaSemana.tot_criancas}</td>
							<td>${celula.celulaSemana.tot_membros}</td>
							<td>${celula.celulaSemana.tot_visitantes}</td>
							<td>${celula.celulaSemana.tot_pessoas_celula}</td>
							<td>${celula.celulaSemana.tot_pessoas_culto}</td>
							<td>${celula.celulaSemana.tot_pessoas_tadel}</td>
							<td>${celula.celulaSemana.tot_ge}</td>
							<td><fmt:formatNumber value="${celula.celulaSemana.oferta}" minFractionDigits="2" type="currency" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>