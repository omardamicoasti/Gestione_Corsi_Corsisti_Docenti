<%@page import="com.venetopiemonte.businesscomponent.model.Corsista"%>
<%@page import="com.venetopiemonte.businesscomponent.facade.AdminFacade"%>

<%
if (session.getAttribute("username") == null) {
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html"%>
<meta charset="ISO-8859-1">
<title>Elenco totale corsisti</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<!-- <a><i class="fa-solid fa-users"></i></a>   -->
	<div class="container">
		<table class="table table-dark" id="corsi">
			<thead>
				<tr>
					<th scope="col">Codice</th>
					<th scope="col">Nome</th>
					<th scope="col">Cognome</th>
					<th scope="col">Precedenti Formativi</th>
					<th scope="col">Elenco iscrizioni</th>
				</tr>
			</thead>
			<tbody>
				<%
					
					Corsista[] arrayCorsisti = AdminFacade.getInstance().getCorsisti();
					for (int i = 0; i < arrayCorsisti.length; i++) {
				%>
				<tr>
					<td scope="row"><%=arrayCorsisti[i].getCodCorsista()%></td>
					<td><%=arrayCorsisti[i].getNome()%></td>
					<td><%=arrayCorsisti[i].getCognome()%></td>
					<td><%=arrayCorsisti[i].getPrecedentiFormativi()%></td>
					<td>
						<form
								action="/<%=application.getServletContextName()%>/infocorsista.jsp"
								method="get">
								<input type="hidden" name="corsistaId"
									value="<%=arrayCorsisti[i].getCodCorsista()%>">
								<button class="btn btn-xs btntotale" type="submit">
									<i class="fa-solid fa-people-roof"></i>
								</button>
						</form>
					</td>
					
				</tr>
				<%
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

</style>
</html>
<%
} else {
	response.sendRedirect("accessonegato.jsp");
}
%>