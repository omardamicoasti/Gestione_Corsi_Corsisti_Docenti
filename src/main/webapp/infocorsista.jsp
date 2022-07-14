<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.venetopiemonte.businesscomponent.model.Iscrizione"%>
<%@page import="com.venetopiemonte.businesscomponent.model.Corso"%>
<%@page import="com.venetopiemonte.businesscomponent.facade.AdminFacade"%>

<%
if (session.getAttribute("username") == null) {
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="corsista" class="com.venetopiemonte.businesscomponent.CorsistaBC" scope="session" />
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html"%>
<meta charset="ISO-8859-1">
<title>Elenco corsi frequentati</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<!-- <a><i class="fa-solid fa-users"></i></a>   -->
	<div class="container containerinfocorsista">
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
						long corsistaId = Long.parseLong(request.getParameter("corsistaId"));
						long[] arrayIdCorsi = AdminFacade.getInstance().getCorsiByIscritto(corsistaId);
						for (int i = 0; i < arrayIdCorsi.length; i++) {
							Corso infoCorso = AdminFacade.getInstance().getCorsoByID(arrayIdCorsi[i]);
					%>
				<tr>
					<td scope="row"><%=arrayIdCorsi[i]%></td>
					<td><%=infoCorso.getNomeCorso()%></td>
					<%
					SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
					%>
					<td><%=formato.format(infoCorso.getInizio())%></td>
					<td><%=formato.format(infoCorso.getFine())%></td>
					<td><%=infoCorso.getCosto()%></td>
					<td><%=infoCorso.getCommenti()%></td>
					<td><%=infoCorso.getAula()%></td>
					<td><%=infoCorso.getCodDocente()%></td>
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