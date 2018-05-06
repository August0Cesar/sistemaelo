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
				<form class="well form-horizontal" action="salvaCheckList"
					method="post" id="foumlario_celulas">
					<fieldset>
						<legend>Cadastro de Pessoas no Trilho de Liderança</legend>
						<div class="form-group">
							<label class="col-md-4 control-label">Membro</label>
							<div class="col-md-4 selectContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-list"></i></span> <select name="id_pessoa"
										class="form-control selectpicker">
										<option value="">Selecione o Membro</option>
										<c:forEach items="${pessoas}" var="pessoa">
											<%-- <option><c:out value="${pessoa.id_pessoa}">${pessoa.nome_pessoa}</c:out></option> --%>
											<option value="${pessoa.id_pessoa}">${pessoa.nome_pessoa}</option>

										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Trilho de
								Liderancça</label>
							<div class="col-md-4 selectContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-list"></i></span> <select
										name="id_trilho_lideranca" class="form-control selectpicker">
										<option value="">Selecione o Trilho de Liderança</option>
										<c:forEach items="${trilhos}" var="t">
											<%-- <option><c:out value="${pessoa.id_pessoa}">${pessoa.nome_pessoa}</c:out></option> --%>
											<option value="${t.id_trilho_lideranca}">${t.nome_trilho_lideranca}</option>

										</c:forEach>
									</select>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label">Concluido?</label>
							<div class="col-md-4">
								<div class="radio">
									<label> <input type="radio" name="status" value="true" />
										Yes
									</label>
								</div>
								<div class="radio">
									<label> <input type="radio" name="status" value="false" />
										No
									</label>
								</div>
							</div>
						</div>
						<!-- Button -->
						<div class="form-group">
							<label class="col-md-4 control-label"></label>
							<div class="col-md-4">
								<button type="submit" class="btn btn-warning">
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