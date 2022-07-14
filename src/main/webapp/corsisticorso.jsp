<%@page import="com.venetopiemonte.dbaccess.DBAccess"%>
<%@page import="com.venetopiemonte.businesscomponent.model.Corsista"%>
<%@page import="com.venetopiemonte.businesscomponent.model.Corso"%>
<%@page import="com.venetopiemonte.businesscomponent.facade.AdminFacade"%>
<%
if (session.getAttribute("codAdmin") != null) {
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html"%>
<meta charset="ISO-8859-1">
<title>Corsisti per singolo corso</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<!-- <a><i class="fa-solid fa-users"></i></a>   -->
	<div class="container">

		<div id="corsisti-table-container">
			<table class="table table-dark" id="corsi">
				<thead>
					<tr>
						<th scope="col">Codice</th>
						<th scope="col">Nome</th>
						<th scope="col">Cognome</th>
						<th scope="col">Precedenti Formativi</th>						
					</tr>
				</thead>

				<tbody>

					<%
					Corso[] corsi = AdminFacade.getInstance().getCorsi();
					for (int i = 0; i < corsi.length; i++) {
					%>

					<tr>
						<th class="bg-grey" colspan="3"><%=corsi[i].getNomeCorso()%></th>
						<%
						long[] iscritti = AdminFacade.getInstance().getIscrittiByCorso(corsi[i].getCodCorso());
						if (iscritti.length < 12) {
						%>
						<th class="bg-grey" colspan="1">

							<button type="button" class="border border-white btn btn-secondary  btn-sm"
								data-toggle="modal" data-target="#editModal_<%=corsi[i].getCodCorso() %>">Aggiungi Corsista</button>
						</th>

						<td><jsp:include page="aggiungiIscrittoModal.jsp">
								<jsp:param value="<%=corsi[i].getCodCorso()%>" name="id" />
						</jsp:include></td> 

						<%
						} else {
						%>
						<th class="bg-grey" colspan="1"><span
							class="btn btn-secondary btn-sm">Corso al completo</span></th>

						<%
						}
						%>

					</tr>

					<%
					for (int j = 0; j < iscritti.length; j++) {
						Corsista iscritto = AdminFacade.getInstance().getCorsistaByID(iscritti[j]);
					%>
					<tr>
						<th scope="row"><%=iscritto.getCodCorsista()%></th>
						<td><%=iscritto.getNome()%></td>
						<td><%=iscritto.getCognome()%></td>
						<td><%=iscritto.getPrecedentiFormativi() == true ? "sì" : "no"%></td>

					</tr>

					<%
					}
					}
					%>


				</tbody>
			</table>

		</div>



		<div class="corsistacorsi-buttons">
			<a href="aggiungicorsista.jsp" class="btn btn-success">Aggiungi
				Corsista</a> <a href="statistica.jsp" class="btn btn-primary">Statistiche</a>
			<a href="eliminacorsi.jsp" class="btn btn-danger">Elimina Corsi</a>
		</div>

	</div>
	<footer class="footer"><%@include file="footer.html"%></footer>
</body>
</html>

<%
} else {
response.sendRedirect("accessonegato.jsp");
}


%>