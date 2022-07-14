<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html"%>
<meta charset="ISO-8859-1">
<title>Homepage Corséma</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<video autoplay muted loop id="myVideo">
  		<!-- <source src="img/1.mp4" type="video/mp4"> -->
  		<source src="img/1.webm" type="video/webm">
	</video>
	<jsp:include page="navbar.jsp" />
	<div class="container containerindex">
		<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
			<div id="login-panel" class="fade-in-image">
				<div class="panel panel-default">
					<div class="panel-body">
						<form accept-charset="UTF-8" role="form"
							action="/<%=application.getServletContextName()%>/login"
							method="post">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="Codice admin"
										name="codice" type="text">
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Password"
										name="password" type="password" value="">
								</div>
								<div class="checkbox">
									<label> <input name="remember" type="checkbox"
										value="Remember Me"> Remember Me
									</label>
								</div>
								<input class="btn btn-lg btn-block" type="submit" value="Login" id="loginbutton">
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6"
			data-mdb-toggle="animation" data-mdb-animation-reset="true"
			data-mdb-animation="slide-out-right">
			<span>Corséma</span>
			<p>Il gestionale dei corsi</p>
			<h4>Effettua il <strong>login</strong> per iniziare</h4>
		</div>


	</div>
	<footer class="footer"><%@include file="footer.html"%></footer>
</body>
<style>
body {
	background-image: url("../img/2.png");
	background-repeat: no-repeat;
	background-position: top 30px right 10px;
	background-size: 49%;
}

nav, footer {
	visibility: hidden;
}
</style>
</html>
<script>
document.getElementById('myVideo').playbackRate = 0.7;
</script>