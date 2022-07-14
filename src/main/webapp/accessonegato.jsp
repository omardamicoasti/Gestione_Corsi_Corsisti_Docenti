<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html"%>
<meta charset="ISO-8859-1">
<title>Accesso negato</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="navbar.jsp" />
	<div class="container containeraccesso">
		<span>Accesso negato</span>
		<a href="index.jsp"><p>effettua nuovamente il  <strong>login</strong></p></a>  
	</div>
	<footer class="footer"><%@include file="footer.html"%></footer>
</body>
</html>