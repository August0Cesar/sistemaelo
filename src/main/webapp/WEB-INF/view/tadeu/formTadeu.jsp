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
<script src="<c:url value="/recursos/jquery/tadeu.js" />"></script>
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
					<li><a href="cadastroTadeu">Cadastro de Tadel</a></li>
					<li><a href="listaTadel">Lista todos os Tadel</a></li>
				</ul>
			</div>
			<div class="col-sm-9 main">
				<form:form class="well form-horizontal" id="formulario">
					<fieldset>
						<legend>Cadastro TADEL</legend>
						<div class="form-group">
							<label class="col-md-4 control-label">Data</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-calendar"></i></span> <input
										name="data_nascimento" id="data_nasc"
										placeholder="dd/MM/yyyy" class="form-control dateP"
										type="text">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Comentario</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-pencil"></i></span>
									<textarea class="form-control" rows="5" id="comentario"
										name="comentario" placeholder="Escreva aqui um comentario"></textarea>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-4 control-label">Total de Pessoas</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> <input
										name="total_pessoas" id="total_pessoas"
										placeholder="Digite número de pessoas" class="form-control"
										type="text" required>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Total de Dízimo</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-usd"></i></span> <input
										name="total_dizimo" id="total_dizimo"
										placeholder="00.00" class="form-control"
										type="text" required>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-4 control-label">Total de Oferta</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-usd"></i></span> <input
										name="total_oferta" id="total_oferta"
										placeholder="00.00" class="form-control"
										type="text" required>
								</div>
							</div>
						</div>



						<!-- Button -->
						<div class="form-group">
							<label class="col-md-4 control-label"></label>
							<div class="col-md-4">
								<button  class="btn btn-warning" id="btn_tadeu">
									Cadastrar<span class="glyphicon glyphicon-send"></span>
								</button>
							</div>
						</div>
					</fieldset>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>