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
					<li><a href="cadastroCelulas">Cadastro de Células</a></li>
					<li><a href="cadastroCelulaSemana">Cadastrar a Célula da
							Semana</a></li>
					<li><a href="cadastroPessoaCelula">Cadastrar Pessoa na
							Célula</a></li>
					<li><a href="listaCelulas">Lista Células Existentes</a></li>
					<li><a href="listCelulasSemana">Lista Células Semanais</a></li>
				</ul>
			</div>
			<div class="col-sm-9 main">
				<form class="well form-horizontal" action="salvaCelulaSemana" method = "post">
					<fieldset>
						<legend>Cadastro Célula da Semana</legend>
						<div class="form-group">
							<label class="col-md-4 control-label">Semana</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-list-alt"></i></span> <input name="semana"
										id="semana" placeholder="Digite número da semana"
										class="form-control" type="text">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Data</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-calendar"></i></span> <input
										name="data_celula" id="data_celula" placeholder="dd/MM/yyyy"
										class="form-control dateP" type="text">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Total de Adultos</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> <input
										name="tot_pessoas" id="tot_pessoas"
										placeholder="Digite número de pessoas" class="form-control"
										type="text">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Total de Crianças</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> <input
										name="tot_criancas" id="tot_criancas"
										placeholder="Digite número de crianças" class="form-control"
										type="text">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Total de
								Visistantes</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> <input
										name="tot_visitantes" id="tot_visitantes"
										placeholder="Digite total de visitantes" class="form-control"
										type="text">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Total de Oferta da
								Célula</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-usd"></i></span> <input name="ofertas"
										id="ofertas" placeholder="Digite total de oferta 00.00"
										class="form-control" type="text">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Total de Pessoas no
								Culto</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> <input name="tot_pessoas_culto"
										id="tot_pessoas_culto"
										placeholder="Digite total de pessoas no culto"
										class="form-control" type="text">
								</div>
							</div>
						</div>

						<!-- CELULAS -->
						<div class="form-group">
							<label class="col-md-4 control-label">Célula</label>
							<div class="col-md-4 selectContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-list"></i></span> <select id="id_celula"
										name="id_celula" class="form-control selectpicker">
										<option value="">Selecione a Célula</option>
										<c:forEach items="${celulas}" var="celula">
											<option id="celula" value="${celula.id_celula}">${celula.nome_celula}</option>
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