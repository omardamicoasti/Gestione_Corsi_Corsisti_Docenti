<%@page import="com.venetopiemonte.businesscomponent.facade.AdminFacade"%>
<%@page import="com.venetopiemonte.businesscomponent.model.Corso"%>
<%@page import="com.venetopiemonte.businesscomponent.model.Docente"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.venetopiemonte.businesscomponent.Statistiche"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html"%>
<meta charset="ISO-8859-1">
<title>Statistica</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:include page="navbar.jsp" />

	<%
	Statistiche statistica = new Statistiche();
	%>
	<div class="container containerstatistica">
		<table class="table table-dark" id="corsi">
			<thead>
				<tr>
					<th scope="col">Statistica</th>
					<th scope="col">Dati</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">Corsisti totali</th>
					<td><%=statistica.numeroCorsisti()%></td>
				</tr>
				<tr>
					<th scope="row">Corso più frequentato</th>
					<td><%=statistica.corsoMaxFrequenze().getNomeCorso()%></td>
				</tr>
				<tr>
					<th scope="row">Data inizio ultimo corso</th>

					<%
					SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
					%>
					<td><%=sf.format(statistica.dataUltimoCorso())%></td>
				</tr>
				<tr>
					<th scope="row">Durata media corsi</th>
					<td><%=statistica.avgDurataCorsi()%></td>
				</tr>
				<tr>
					<th scope="row">Elenco corsisti</th>
					<td><a class="btn btn-default" href="totalecorsisti.jsp">Vedi
							elenco corsisti</a></td>
				</tr>

			</tbody>
		</table>


		<h3>Docenti che possono tenere più corsi</h3>
		<table class="table table-dark">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Cognome</th>
				</tr>
			</thead>

			<tbody>
				<%
				Docente[] docenti = statistica.multiCorsoDocente();

				for (int i = 0; i < docenti.length; i++) {
				%>

				<tr>
					<td><%=docenti[i].getNome()%></td>
					<td><%=docenti[i].getCognome()%></td>
				</tr>

				<%
				}
				%>
				

				

			</tbody>

		</table>


		<h3>Corsi con posti disponibili</h3>
		<table class="table table-dark">
			<thead>
				<tr>
					<th>Nome Corso</th>
					<th>Aula</th>
					<th>Docente</th>
					<th>Data di inizio</th>
					<th>Data di fine</th>
					
				</tr>
			</thead>

			<tbody>
				<%
				Corso[] corsi = statistica.corsiPostiLiberi();

				for (int i = 0; i <corsi.length; i++) {
				%>

				<tr>
					<td><%=corsi[i].getNomeCorso()%></td>
					<td><%=corsi[i].getAula()%></td>
					<td><%=AdminFacade.getInstance().getDocenteById(corsi[i].getCodDocente()).getCognome()%></td>
					<td><%=sf.format(corsi[i].getInizio())%></td>
					<td><%=sf.format(corsi[i].getFine())%></td>
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