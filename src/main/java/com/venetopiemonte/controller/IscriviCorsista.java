package com.venetopiemonte.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.venetopiemonte.businesscomponent.facade.AdminFacade;
import com.venetopiemonte.businesscomponent.model.Iscrizione;
import com.venetopiemonte.exceptions.DAOException;

/**
 * Servlet implementation class IscriviCorsista
 */
@WebServlet("/iscriviCorsista")
public class IscriviCorsista extends HttpServlet {

	private static final long serialVersionUID = 3173338870892942735L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("corso" +request.getParameter("idCorso"));
		System.out.println("corsista" +request.getParameter("idCorsista"));
		Iscrizione iscrizione= new Iscrizione();
		iscrizione.setCodCorso(Long.parseLong(request.getParameter("idCorso")));
		iscrizione.setCodCorsista(Long.parseLong(request.getParameter("idCorsista")));
		
		
		
		try {
			AdminFacade.getInstance().createIscrizione(iscrizione);
		} catch (ClassNotFoundException | DAOException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("corsisticorso.jsp");
	}

}
