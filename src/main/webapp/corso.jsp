<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.venetopiemonte.businesscomponent.facade.AdminFacade"%>
<%@page import="com.venetopiemonte.businesscomponent.model.Corso"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
if (session.getAttribute("codAdmin") != null) {
%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html"%>
<meta charset="ISO-8859-1">
<title>Corsi</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<%
		Corso[] corsi= AdminFacade.getInstance().getCorsi();
		SimpleDateFormat sf= new SimpleDateFormat("dd/MM/yyyy");
	%>
	<jsp:include page="navbar.jsp" />
	<!-- <a><i class="fa-solid fa-users"></i></a>   -->
	<div class="container containercorso">
		<table class="table table-dark" id="corsi">
			<thead>
				<tr>
					<th scope="col">Codice</th>
					<th scope="col">Nome</th>
					<th scope="col">Data Inizio</th>
					<th scope="col">Data Fine</th>
					<th scope="col">Costo</th>
					<th scope="col">Commenti</th>
					<th scope="col">Aula</th>
					<th scope="col">Docente</th>
				</tr>
			</thead>
			<tbody>
				<%
					for(Corso corso: corsi){
				%>
				
				
				<tr>
					<td><%=corso.getCodCorso() %></td>
					<td><%=corso.getNomeCorso()%></td>
					<td><%=sf.format(corso.getInizio())%></td>
					<td><%=sf.format(corso.getFine())%></td>
					<td><%=corso.getCosto()%></td>
					<td><%=corso.getCommenti()%></td>
					<td><%=corso.getAula()%></td>
					<td><%=AdminFacade.getInstance().getDocenteById(corso.getCodDocente()).getCognome()%></td>
				</tr>
				
				<%
					}
				%>
				
			</tbody>
		</table>
	</div>
	<footer class="footer"><%@include file="footer.html"%></footer>
</body>
</html>
<%
} else {
response.sendRedirect("accessonegato.jsp");
}


%>