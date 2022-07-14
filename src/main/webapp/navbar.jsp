<nav class="navbar navbar-inverse">
	<div class="container-fluid">

		<!-- BRAND -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#alignment-example"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="corsisticorso.jsp">Corséma</a>
		</div>

		<!-- COLLAPSIBLE NAVBAR -->
		<div class="collapse navbar-collapse" id="alignment-example">

			<!-- Links -->
			<ul class="nav navbar-nav">
				<li><a href="corso.jsp">Corsi</a></li>
				<li><a href="totalecorsisti.jsp">Elenco totale corsisti</a></li>
				<li><a href="statistica.jsp">Statistiche</a></li>
			</ul>
			<!-- NOME UTENTE E LOGOUT / SIGN IN O LOG IN -->
			<%--controlliamo l'utente connesso --%>
			<%
			long codAdmin = session.getAttribute("codAdmin") != null ? (long) session.getAttribute("codAdmin") : 0;
			if (codAdmin < 1) {
			%>
					<ul class="nav navbar-nav navbar-right">
				<li><a href="registrazione.jsp"><span
						class="glyphicon glyphicon-user"></span> Sign up</a></li>
				<li><a href="index.jsp"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</ul>

			<%
			} else {
			%>
							<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-user"></span>
						<%=codAdmin%></a></li>
				<li><a href="index.jsp"><span
						class="glyphicon glyphicon-off"></span> Logout</a></li>
			</ul>


			<%
			}
			%>
		</div>

	</div>
</nav>
<style>
.navbar {
	height: 8vh;
	background-color: #3c3d41;
	border-radius: 0;
	!
	important
}

ul li:hover {
	color: white;
}

.navbar-brand {
	color: white;
}
</style>