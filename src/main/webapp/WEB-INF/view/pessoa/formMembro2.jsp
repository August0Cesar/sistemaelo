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

				<form class="well form-horizontal" action=" " method="post"
					id="contact_form">
					<fieldset>

						Form Name
						<legend>Cadastro</legend>

						Text input

						<div class="form-group">
							<label class="col-md-4 control-label">Nome</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> <input
										name="nome_usuario" placeholder="Nome Completo"
										class="form-control" type="text">
								</div>
							</div>
						</div>

						Text input

						<div class="form-group">
							<label class="col-md-4 control-label">Last Name</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> <input name="last_name"
										placeholder="Last Name" class="form-control" type="text">
								</div>
							</div>
						</div>

						Text input
						<div class="form-group">
							<label class="col-md-4 control-label">E-Mail</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-envelope"></i></span> <input name="email"
										placeholder="E-Mail Address" class="form-control" type="text">
								</div>
							</div>
						</div>


						Text input

						<div class="form-group">
							<label class="col-md-4 control-label">Phone #</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-earphone"></i></span> <input name="phone"
										placeholder="(845)555-1212" class="form-control" type="text">
								</div>
							</div>
						</div>

						Text input

						<div class="form-group">
							<label class="col-md-4 control-label">Address</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-home"></i></span> <input name="address"
										placeholder="Address" class="form-control" type="text">
								</div>
							</div>
						</div>

						Text input

						<div class="form-group">
							<label class="col-md-4 control-label">City</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-home"></i></span> <input name="city"
										placeholder="city" class="form-control" type="text">
								</div>
							</div>
						</div>

						Select Basic

						<div class="form-group">
							<label class="col-md-4 control-label">State</label>
							<div class="col-md-4 selectContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-list"></i></span> <select name="state"
										class="form-control selectpicker">
										<option value=" ">Please select your state</option>
										<option>Alabama</option>
										<option>Alaska</option>
										<option>Arizona</option>
										<option>Arkansas</option>
										<option>California</option>
										<option>Colorado</option>
										<option>Connecticut</option>
										<option>Delaware</option>
										<option>District of Columbia</option>
										<option>Florida</option>
										<option>Georgia</option>
										<option>Hawaii</option>
										<option>daho</option>
										<option>Illinois</option>
										<option>Indiana</option>
										<option>Iowa</option>
										<option>Kansas</option>
										<option>Kentucky</option>
										<option>Louisiana</option>
										<option>Maine</option>
										<option>Maryland</option>
										<option>Mass</option>
										<option>Michigan</option>
										<option>Minnesota</option>
										<option>Mississippi</option>
										<option>Missouri</option>
										<option>Montana</option>
										<option>Nebraska</option>
										<option>Nevada</option>
										<option>New Hampshire</option>
										<option>New Jersey</option>
										<option>New Mexico</option>
										<option>New York</option>
										<option>North Carolina</option>
										<option>North Dakota</option>
										<option>Ohio</option>
										<option>Oklahoma</option>
										<option>Oregon</option>
										<option>Pennsylvania</option>
										<option>Rhode Island</option>
										<option>South Carolina</option>
										<option>South Dakota</option>
										<option>Tennessee</option>
										<option>Texas</option>
										<option>Uttah</option>
										<option>Vermont</option>
										<option>Virginia</option>
										<option>Washington</option>
										<option>West Virginia</option>
										<option>Wisconsin</option>
										<option>Wyoming</option>
									</select>
								</div>
							</div>
						</div>

						Text input

						<div class="form-group">
							<label class="col-md-4 control-label">Zip Code</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-home"></i></span> <input name="zip"
										placeholder="Zip Code" class="form-control" type="text">
								</div>
							</div>
						</div>

						Text input
						<div class="form-group">
							<label class="col-md-4 control-label">Website or domain
								name</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-globe"></i></span> <input name="website"
										placeholder="Website or domain name" class="form-control"
										type="text">
								</div>
							</div>
						</div>

						radio checks
						<div class="form-group">
							<label class="col-md-4 control-label">Do you have
								hosting?</label>
							<div class="col-md-4">
								<div class="radio">
									<label> <input type="radio" name="hosting" value="yes" />
										Yes
									</label>
								</div>
								<div class="radio">
									<label> <input type="radio" name="hosting" value="no" />
										No
									</label>
								</div>
							</div>
						</div>

						Text area

						<div class="form-group">
							<label class="col-md-4 control-label">Project Description</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-pencil"></i></span>
									<textarea class="form-control" name="comment"
										placeholder="Project Description"></textarea>
								</div>
							</div>
						</div>

						Success message
						<div class="alert alert-success" role="alert" id="success_message">
							Success <i class="glyphicon glyphicon-thumbs-up"></i> Thanks for
							contacting us, we will get back to you shortly.
						</div>

						Button
						<div class="form-group">
							<label class="col-md-4 control-label"></label>
							<div class="col-md-4">
								<button type="submit" class="btn btn-warning">
									Send <span class="glyphicon glyphicon-send"></span>
								</button>
							</div>
						</div>

					</fieldset>
				</form>
			</div>
		</div>
	</div>