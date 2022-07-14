package com.venetopiemonte.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.venetopiemonte.businesscomponent.facade.AdminFacade;
import com.venetopiemonte.exceptions.DAOException;

/**
 * Servlet implementation class eliminaCorso
 */
@WebServlet("/eliminaCorso")
public class eliminaCorso extends HttpServlet {

	private static final long serialVersionUID = -3316857682289530461L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			String id = request.getParameter("corsoId");
			System.out.println(id);
			if (id != null) {
				AdminFacade.getInstance().deleteCorso(Long.valueOf(id));
			}
			response.sendRedirect("eliminacorsi.jsp");
		} catch (DAOException | ClassNotFoundException exc) {
			exc.printStackTrace();
			throw new ServletException(exc.getMessage());
		}
	}

}

