<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="<c:url value="recursos/css/main.css "/> "> 
<link rel="stylesheet" href="<c:url value="/recursos/css/jquery-ui.css "/> ">
<link rel="stylesheet" href="<c:url value="/recursos/css/jquery-ui.theme.css "/> ">
<script src="<c:url value="/recursos/jquery/jquery-3.1.1.min.js" />"></script>
<script src="<c:url value="/recursos/js/bootstrap.js" />"></script>
<script src="<c:url value="/recursos/js/jquery.tabletojson.js" />"></script>
<script src="<c:url value="/recursos/jquery/jquery-ui.js" />"></script>
<script src="<c:url value="/recursos/jquery/index.js" />"></script>
<script src="<c:url value="/recursos/jquery/pessoas.js" />"></script>
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
					<li><a href="mesAniver">Aniversariantes do Mes</a></li>
				</ul>
			</div>
			<div class="col-sm-9 main">

				<form class="well form-horizontal">
					<fieldset>
						<legend>Cadastro de Membros</legend>
						<div class="form-group">
							<label class="col-md-4 control-label">Nome</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> <input
										name="nome_pessoa" id="nome_pessoa" placeholder="Nome Completo"
										class="form-control" type="text">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Endereço</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-home"></i></span> <input name="endereco" id="endereco"
										placeholder="Endereço" class="form-control" type="text">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Phone WhatsApp</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-earphone"></i></span> <input
										name="tel_whatsapp" id="tel_whatsapp" placeholder="988000000"
										class="form-control" type="text">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Phone Residencial</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-earphone"></i></span> <input
										name="tel_residencia" id="tel_residencia" placeholder="988000000"
										class="form-control" type="text">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Casado?</label>
							<div class="col-md-4">
								<div class="radio">
									<label> <input type="radio" name="casado" value="yes" />
										Yes
									</label>
								</div>
								<div class="radio">
									<label> <input type="radio" name="casado" checked="checked" value="no" />
										No
									</label>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Nome do Conjugue</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> <input
										name="nome_conjugue" id="nome_conjugue" placeholder="Nome Completo"
										class="form-control" type="text">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Naturalidade</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-globe"></i></span> <input
										name="naturalidade" id="naturalidade" placeholder="Natural" class="form-control"
										type="text">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Data de Nascimento</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-calendar"></i></span> <input
										name="data_nascimento" id="data_nascimento" placeholder="Data Nascimento"
										class="form-control dateP" type="text">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Nome do Pai</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> <input name="nome_pai" id="nome_pai"
										placeholder="Nome Completo" class="form-control" type="text">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Nome da Mãe</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> <input name="nome_mae" id="nome_mae"
										placeholder="Nome Completo" class="form-control" type="text">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Ja pertence á
								alguma célula?</label>
							<div class="col-md-4">
								<div class="radio">
									<label> <input type="radio" name="status_celula"
										value="true" /> Yes
									</label>
								</div>
								<div class="radio">
									<label> <input type="radio" name="status_celula"
										value="false" checked="checked" /> No
									</label>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Chegada a Igreja</label>
							<div class="col-md-4 selectContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-list"></i></span> <select
										name="id_chegada_igreja" id="id_chegada_igreja" class="form-control selectpicker">
										<option value="1">Igreja</option>
										<option value="2">Encontro de Vencedores</option>
									</select>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-4 control-label">Batizado por</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> <input
										name="batizado_por" id="batizado_por" placeholder="Primeiro Nome"
										class="form-control" type="text">
								</div>
							</div>
						</div>
			
						<div class="form-group">
							<label class="col-md-4 control-label">Cargo</label>
							<div class="col-md-4">
								<div class="radio">
									<label> <input type="checkbox" name="cargos"  value="1"  />
										Lider
									</label>
								</div>
								<div class="radio">
									<label> <input type="checkbox" name="cargos"  value="2" />
										Lider_Treinamento
									</label>
								</div>
								<div class="radio">
									<label> <input type="checkbox" name="cargos"   value="3" />
										Supervisor de setor
									</label>
								</div>
								<div class="radio">
									<label> <input type="checkbox" name="cargos"  value="4"/>
										Supervisor de área
									</label>
								</div>
								<div class="radio">
									<label> <input type="checkbox" name="cargos" value="5" />
										Discipulador
									</label>
								</div>
								<div class="radio">
									<label> <input type="checkbox" name="cargos" value="6" />
										Anfitrião
									</label>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label"></label>
							<div class="col-md-4">
								<button type="button" id="btn_salvar_membro" class="btn btn-warning">
									Cadastrar <span class="glyphicon glyphicon-send"></span>
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