<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
					<li><a href="fazCheckList">cadastro pessoas no Trilho de
							Liderança</a></li>
					
					<li><a href="statusPorPessoa">Status Pessoa no Trilho</a></li>
					
				</ul>
			</div>
			<div class="col-sm-9 main">
				<h2>Geral todos as Pessoas no Trilho</h2>

				<table class="table table-striped">
					<tr>
						<th>NOME PESSOA</th>
						<th>TRILHO</th>
						<th>STATUS</th>
						<th>DATA</th>
					</tr>
					<c:forEach items="${listTrilho}" var="tt">
						<tr>
							<td>${tt.pessoa.nome_pessoa}</td>
							<td>${tt.trilhoLideranca.nome_trilho_lideranca}</td>
							<td><c:choose>
									<c:when test="${trilho.status eq false}">NÃO
								Concluído
									</c:when>
									<c:otherwise> Concluído
									</c:otherwise>
								</c:choose></td>
							<td><fmt:formatDate value="${tt.listTrilho.data_cadastro}"
									pattern="dd/MM/yyyy" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>