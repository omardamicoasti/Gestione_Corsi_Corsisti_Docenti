package com.venetopiemonte.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.venetopiemonte.businesscomponent.facade.AdminFacade;
import com.venetopiemonte.businesscomponent.model.Corsista;

/**
 * Servlet implementation class AggiungiCorsista
 */
@WebServlet("/aggiungiCorsista")
public class AggiungiCorsista extends HttpServlet {

	private static final long serialVersionUID = 3345825001357367679L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		Corsista corsista= new Corsista();
		
		try {
			corsista.setNome(request.getParameter("nome"));
			corsista.setCognome(request.getParameter("cognome"));
			String precForm= request.getParameter("cognome");
			if(precForm.equals("T")) corsista.setPrecedentiFormativi(true);
			else corsista.setPrecedentiFormativi(false);
			AdminFacade.getInstance().createOrUpdateCorsista(corsista);
			response.sendRedirect("corsisticorso.jsp");
		} catch(Exception exc) {
			exc.printStackTrace();
			throw new ServletException(exc.getMessage());
		}
	}

}
