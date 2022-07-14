<%@page import="java.io.PrintWriter"%>
<%@page import="com.venetopiemonte.exceptions.DAOException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html"%>
<meta charset="ISO-8859-1">
<title>Error page</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="navbar.jsp" />
	<div class="container">
		<p></p>
		
		<%
		if (exception instanceof ClassNotFoundException) {
		%>
		<div class="panel panel-danger">
			<h5 class="panel-heading">Eccezione durante la connessione al DB</h5>
		<div class="panel-body">
			<h3><%= exception.getClass().getName() %> </h3>
			<p>
				motivo:&nbsp;<%=exception.getMessage()%></p>
			<p>
				stacktrace:&nbsp;<%
			exception.printStackTrace(new PrintWriter(out));
			%>
			</p>
			<button onClick="window.history.back" class="btn btn-default">Indietro</button>
		</div>
		</div>

		<%
		} else if (exception instanceof DAOException) {
		%>
		<div class="panel panel-danger">
			<h5 class="panel-heading">Eccezione durante l'accesso al DB</h5>
		<div class="panel-body">
			<h5><%= exception.getClass().getName() %> </h5>
			<p>
				motivo:&nbsp;<%=exception.getMessage()%></p>
			<%-- <p>
				stacktrace:&nbsp;<%
			exception.printStackTrace(new PrintWriter(out));
			%>
			</p> --%>
			<button onClick="window.history.back" class="btn btn-default">Indietro</button>
		</div>
		</div>
		<%
		} else {
		%>
		<div class="panel panel-danger">
			<h5 class="panel-heading">Eccezione non prevista</h5>
			<div class="panel-body">
				<h5><%= exception.getClass().getName() %> </h5>
				<p>
					motivo:&nbsp;<%=exception.getMessage()%></p>
				<%-- <p>
					stacktrace:&nbsp;<%
			exception.printStackTrace(new PrintWriter(out));
			%>
				</p> --%>
				<button onClick="window.history.back" class="btn btn-default">Indietro</button>
			</div>
		</div>
		<%
		}
		%>
	</div>
	<footer class="footer"><%@include file="footer.html"%></footer>
</body>
<style>
.container {
background: white;
}
/*.container {
	display: flex;
	flex-direction: column;
	justify-content: space-around;
	align-items: center;
}
 .container span {
	font-size: 8em;
}
.container p {
	font-size: 2em;
	color: black;
} */
</style>
</html>