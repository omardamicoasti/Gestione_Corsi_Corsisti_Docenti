package com.venetopiemonte.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.venetopiemonte.security.AlgoritmoMD5;
import com.venetopiemonte.utilities.LoginAdmin;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
       
	private static final long serialVersionUID = 5994589791469733142L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// dati dalla sessione
		long codice = Long.valueOf(request.getParameter("codice"));
		String password = AlgoritmoMD5.convertiMD5(request.getParameter("password"));
		
		HttpSession session = request.getSession();
		
		String adminPass = null;
		if (codice > 0 && password != null) {
			try {
				LoginAdmin logAdmin = new LoginAdmin();
				adminPass = logAdmin.controlloAdmin(codice);
				
				if (adminPass != null) {
					if (adminPass.equals(password)) {
						session.setAttribute("codAdmin", codice);
						response.sendRedirect("corsisticorso.jsp");
					} else {
					
						response.sendRedirect("accessonegato.jsp");
					}
				} else {
					response.sendRedirect("accessonegato.jsp");
				}
			} catch (Exception exc) {
				exc.printStackTrace();
				throw new ServletException(exc.getMessage());
			}
		}
		
		
	}

}
