<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.venetopiemonte.businesscomponent.model.Docente"%>
<%@page import="com.venetopiemonte.businesscomponent.model.Corso"%>
<%@page import="com.venetopiemonte.businesscomponent.facade.AdminFacade"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
if (session.getAttribute("codAdmin") != null) {
%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<%@include file="CDN.html"%>
<meta charset="ISO-8859-1">
<title>Elimina Corsi</title>

</head>
<body>
	<jsp:include page="navbar.jsp" />

	<div class="container">
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
					<!-- <th scope="col">Corsisti</th>  -->
					<th scope="col">Elimina</th>
				</tr>
			</thead>
			<tbody>
				<%
				Corso[] corsi = AdminFacade.getInstance().getCorsi();
				for (int i = 0; i < corsi.length; i++) {
					if (corsi[i].getInizio().getTime() > (new Date().getTime())) {
				%>
				<tr>
					<th scope="row"><%=corsi[i].getCodCorso()%></th>
					<td><%=corsi[i].getNomeCorso()%></td>
					<%
					SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
					%>
					<td><%=formato.format(corsi[i].getInizio())%></td>
					<td><%=formato.format(corsi[i].getFine())%></td>
					<td><%=corsi[i].getCosto()%></td>
					<td><%=corsi[i].getCommenti()%></td>
					<td><%=corsi[i].getAula()%></td>
					<%
					Docente doc = AdminFacade.getInstance().getDocenteById(corsi[i].getCodDocente());
					%>
					<td><%=doc.getNome()%>&nbsp;<%=doc.getCognome()%></td>
					<!-- <td><a href="corsisticorso.jsp"><i class="fa-solid fa-users"></i></a></td>  -->
					<td>
						<form
							action="/<%=application.getServletContextName()%>/eliminaCorso"
							method="post">
							<input type="hidden" name="corsoId"
								value="<%=corsi[i].getCodCorso()%>">
							<button class="btn btn-xs" type="submit" name="corsoId">
								<i class="fa-solid fa-delete-left"></i>
							</button>
						</form>
					</td>

				</tr>
				<%
				}
				}
				%>
			</tbody>
		</table>
	</div>

	<footer class="footer"><%@include file="footer.html"%></footer>
</body>
<style>
.container {
	height: 63vh;
	display: flex;
	justify-content: center;
	overflow-y: scroll;
	margin-bottom: 1vh;
}

html {
	overflow-x: hidden;
}

.btn {
	color: black;	
	background: transparent;
}

</style>
</html>


<%
} else {
response.sendRedirect("accessonegato.jsp");
}
%>
