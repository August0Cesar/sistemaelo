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
					<li><a href="cadastroMembro">Cadastro de Membros <span
							class="sr-only">(current)</span>
					</a></li>
					<li><a href="cadastroVisitante">Cadastro de Visitantes</a></li>
					<li><a href="cadastroCargo">Cadastro de Cargos</a></li>
					<li><a href="todosMembros">Todos os membros</a></li>
					<li><a href="todosVisitantes">Todos os Visitantes</a></li>
					<li><a href="visitantesPorPeriodo">Visitantes Por período</a></li>
					<li><a href="membrosPorPeriodo">Membros Por período</a></li>
				</ul>

			</div>
			<div class="col-sm-9 main">
				<form class="well form-horizontal" id="" action="salvaPessoaCargo">
					<fieldset>
						<legend>Cadastro de Cargos</legend>
						<!-- MEMBROS -->
						<div class="form-group">
							<label class="col-md-4 control-label">Membro</label>
							<div class="col-md-4 selectContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-list"></i></span> <select id="nome_membro"
										name="id_pessoa" class="form-control selectpicker">
										<option value="">Selecione o Membro</option>
										<c:forEach items="${pessoas}" var="pessoa">
											<%-- <option><c:out value="${pessoa.id_pessoa}">${pessoa.nome_pessoa}</c:out></option> --%>
											<option id="membro" value="${pessoa.id_pessoa}">${pessoa.nome_pessoa}</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Cargos</label>
							<div class="col-md-4 selectContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-list"></i></span> <select id="nome_membro"
										name="id_cargo" class="form-control selectpicker">
										<option value="">Selecione o Cargo</option>
										<c:forEach items="${cargos}" var="cargo">
											<option id="cargo" value="${cargo.id_cargo}">${cargo.nome_cargo}</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>

						<!-- Button -->
						<div class="form-group">
							<label class="col-md-4 control-label"></label>
							<div class="col-md-4">
								<button type="submit" class="btn btn-warning" id="button">
									Cadastrar<span class="glyphicon glyphicon-send"></span>
								</button>
							</div>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>