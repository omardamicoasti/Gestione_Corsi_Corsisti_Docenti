
<%@page import="com.venetopiemonte.businesscomponent.model.Corsista"%>
<%@page import="com.venetopiemonte.businesscomponent.facade.AdminFacade"%>
<%@page import="com.venetopiemonte.businesscomponent.model.Corso"%>
<%
long id = Long.parseLong(request.getParameter("id"));

if (request.getParameter("id") == null) {
	response.sendRedirect("corsisticorso.jsp");
} else {
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%

long[] nonIscritti= AdminFacade.getInstance().getNonIscrittiByCorso(id);

%>
<div class="modal fade" id="editModal_<%=id%>" role="dialog">
	<div class="modal-dialog modal-md">

			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">
						Corsisti iscrivibili a <%= AdminFacade.getInstance().getCorsoByID(id).getNomeCorso()%>
					</h4>
				</div>
				<div class="modal-body">
					<table class="table table-dark">
						<thead>
							<tr>
							<th>Nome</th>
							<th>Cognome</th>
							<th> </th>
							</tr>
						</thead>
						
						<tbody>
						<%
						for (int i=0; i<nonIscritti.length; i++){
							Corsista corsista= AdminFacade.getInstance().getCorsistaByID(nonIscritti[i]);
						%>
						
						<tr>
							<td><%= corsista.getNome()%></td>
							<td><%= corsista.getCognome()%></td>
							<td> 
								<form action="/<%=application.getServletContextName()%>/iscriviCorsista" method="post">
									<input type="hidden" name="idCorso" value="<%=id%>">
									<input type="hidden" name="idCorsista" value="<%=corsista.getCodCorsista()%>">
									<button class="btn btn-success"type="submit"><span class="glyphicon glyphicon-plus"></span></button>
								</form>
							
							</td>
						</tr>
						
						<%
							}
						%>
						
						</tbody>
						
					</table>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-success btn-l">Salva
						modifiche</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">
						Annulla</button>
				</div>
			</div>

	</div>
</div>
<%
}
%>