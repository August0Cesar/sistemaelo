<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de usuarios</title>
<link rel="stylesheet" href="<c:url value="/recursos/css/main.css "/> ">
<link rel="stylesheet" href="<c:url value="/recursos/css/index.css "/> ">
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Sistema Elo</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="#">Cadastros</a></li>
				<li><a href="#">Listas</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-user"></span>
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
					<li class="active"><a href="cadastroUsuario">Cadastro de
							Usuario <span class="sr-only">(current)</span>
					</a></li>
					<li><a href="listaUsuarios">Lista de Usuarios</a></li>
					<li><a href="#">Analytics</a></li>
					<li><a href="#">Export</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="">Nav item</a></li>
					<li><a href="">Nav item again</a></li>
					<li><a href="">One more nav</a></li>
					<li><a href="">Another nav item</a></li>
					<li><a href="">More navigation</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="">Nav item again</a></li>
					<li><a href="">One more nav</a></li>
					<li><a href="">Another nav item</a></li>
				</ul>
			</div>
			<div class="col-sm-9 main">
				<h2>Lista de Usuarios Cadastrados no sistema</h2>

				<table class="table table-striped">
					<tr>
						<th>Id</th>
						<th>Nome</th>
						<th>Usuario</th>
						<th>Senha</th>
						<th>Alterar</th>
						<th>Remover</th>
					</tr>
					<c:forEach items="${usuarios}" var="usuario">
						<tr>
							<td>${usuario.id_usuario}</td>
							<td>${usuario.nome_usuario}</td>
							<td>${usuario.login}</td>
							<td>${usuario.senha}</td>
							<td><a href="mostraUsuarios=${usuario.id_usuario}">Alterar</a></td>
							<td><a href="removeUsuarios?id=${usuario.id_usuario}">Remover</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>