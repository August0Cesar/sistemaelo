<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trilho lideran�a</title>
<link rel="stylesheet" href="<c:url value="/recursos/css/main.css "/> ">
<link rel="stylesheet"
	href="<c:url value="/recursos/css/jquery-ui.css "/> ">
<link rel="stylesheet"
	href="<c:url value="/recursos/css/jquery-ui.theme.css "/> ">
<script src="<c:url value="/recursos/jquery/jquery-3.1.1.min.js" />"></script>
<script src="<c:url value="/recursos/js/bootstrap.js" />"></script>
<script src="<c:url value="/recursos/js/jquery.tabletojson.js" />"></script>
<script src="<c:url value="/recursos/jquery/jquery-ui.js" />"></script>
<script src="<c:url value="/recursos/jquery/trilho.js" />"></script>
<script src="<c:url value="/recursos/js/jquery.tabletojson.min.js" />"></script>

<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<!-- <script type="text/javascript">
	
	
</script> -->
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
						Sair</a></li>
			</ul>
		</div>
	</nav>
	<!-- Menu Vertical -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li><a href="statusPorPessoa">Status Pessoa no Trilho</a></li>

				</ul>
			</div>
			<div class="col-sm-9 main">
				<div class="well form-horizontal">
					<fieldset>
						<legend>Busca Status da Pessoa no Trilho</legend>
						<div class="form-group">
							<label class="col-md-4 control-label">Membro</label>
							<div class="col-md-4 selectContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-list"></i></span> <select name="id_pessoa"
										class="form-control selectpicker">
										<option value="">Selecione o Membro</option>
										<c:forEach items="${pessoas}" var="pessoa">
											<option value="${pessoa.id_pessoa}">${pessoa.nome_pessoa}</option>

										</c:forEach>
									</select>
								</div>
							</div>
							<button class="btn" id="btn_busca">Buscar Membro</button>
							<button class="btn" id="btn_novaBusca">Nova Busca</button>
						</div>
						<div class="row">
							<div class="col-sm-6 main">
								<h3 id="nome_pessoa">Membro</h3>
								<!-- Tabela do trilho -->
								<table class="table table-striped" id="tabela_trilho">
									<tr>
										<th>ID</th>
										<th>NOME TRILHO</th>	
										<th>STATUS</th>
									</tr>
								</table>


							</div>
							<div id="grafico" class="col-sm-6 main">
								<h3 style="text-align: left">Status no Trilho</h3>
								<div id="chart_div" style="background-color: #FFFAFA">
								</div>
							</div>
						</div>
						<hr>
						<!-- Button -->
						<div class="form-group">
							<label class="col-md-4 control-label"></label>
							<div class="col-md-4">
								<button type="submit" class="btn btn-warning" id="btn-update">
									Cadastrar Altera��es<span class="glyphicon glyphicon-send"></span>
								</button>
							</div>
						</div>
					</fieldset>
				</div>
			</div>
		</div>
	</div>
</body>


</html>