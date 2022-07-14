<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html"%>
<meta charset="ISO-8859-1">
<title>Registrazione utente</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<div class="container">
		<!-- <div class="page-header">
			<h3>Inserire i dati per la registrazione</h3>
		</div> -->

		<form action="/<%=application.getServletContextName()%>/aggiungiCorsista"
			method="post" class="form-horizontal" id="userForm">
			
			

			<!-- ----------------------- NOME -->
			<div class="form-group">
				<label class="col-lg-4 control-label">Nome</label>
				<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input type="text"
							name="nome" placeholder="Inserire nome" id="nome"
							class="form-control">
					</div>
				</div>
				<div class="col-md-7 control-label" id="infoNome"></div>
			</div>

			<!-- ----------------------- COGNOME -->
			<div class="form-group">
				<label class="col-lg-4 col-md-4 col-sm-4 col-xs-4 control-label">Cognome</label>
				<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input type="text"
							name="cognome" placeholder="Inserire cognome" id="cognome"
							class="form-control">
					</div>
				</div>
				<div class="col-md-7 control-label" id="infoCognome"></div>
			</div>
			
				<!-- ----------------------- PRECEDENTI FORMATIVI -->
			<div class="form-group">
				<label class="col-lg-4 col-md-4 col-sm-4 col-xs-4 control-label">Precedenti Formativi</label>
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 inputGroupContainer">
						<input class="form-check-input" type="radio" name="precedentiFormativi" 
					id="precedentiFormativiT" 
					value="T"> <label 
					class="form-check-label"
					for="precedentiFormativiT">Sì</label>
					
					<input class="form-check-input" type="radio" name="precedentiFormativi"
					id="precedentiFormativiF" checked> <label
					class="form-check-label" for="precedentiFormativiF">No</label>
					
					</div>

				<div class="col-md-7 control-label" id="infoCognome"></div>
			</div>
			
			<div class="row">
				<div class="col-lg-4 col-lg-offset-4">
					<button type="submit" class="btn btn-warning">
						aggiungi nuovo corsista&nbsp;&nbsp; <span
							class="glyphicon glyphicon-send"></span>
					</button>
				</div>
				
				</form>

			</div>
		
		<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6"
			data-mdb-toggle="animation" data-mdb-animation-reset="true"
			data-mdb-animation="slide-out-right">
			<span>Corséma</span>
			<p>Il gestionale dei corsi</p>
			<h5>Benvenuto, registrati per iniziare</h5>
		</div>
	</div>



	<footer class="footer"><%@include file="footer.html"%></footer>
</body>
<style>
* {
	/* border: 1px solid red; */
}

body {
	font-family: 'Poppins', sans-serif;
	background-image: url("img/2.png");
	background-repeat: no-repeat;
	background-position: top 230px right 10px;
	background-size: 59%;
}

.container {
	height: 70vh;
	display: flex;
	justify-content: left;
	align-items: center;
}

#userForm {
	width: 75%;
	display: flex;
	flex-direction: column;
	align-items: start;
}

.form-check {
	padding-left: 50px;
}

.panel {
	border: 0;
	box-shadow: none;
}

.fade-in-image {
	animation: fadeIn 2s;
}

.btn {
	background-color: #3c3d41;
	color: white;
}

@
keyframes fadeIn { 10% {
	opacity: 0;
}

100


%
{
opacity






:






1




;
}
}
nav, footer {
	visibility: hidden;
}
</style>
</html>

