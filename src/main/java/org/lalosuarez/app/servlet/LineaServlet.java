package org.lalosuarez.app.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class WelcomeServlet
 */
public class LineaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action") == null ? "undefined" : request.getParameter("action");
		
/*		Linea linea = new Linea();
		linea.setNombre("Línea 1");
		linea.setId(1000);
		
		request.setAttribute("action", action);
		request.setAttribute("linea", linea);*/
		
		switch (action) {
		
		case "list":
			System.out.println(action);
			list(request, response, "views/lineas/list.jsp");
			break;
		
		case "add":
			System.out.println(action);
			add(request, response, "views/lineas/form.jsp");
			break;
			
		case "edit":
			System.out.println(action);
			add(request, response, "views/lineas/form.jsp");
			break;			
			
		default:
			System.out.println("No valid action defined");
			list(request, response, "views/lineas/list.jsp");
			break;
		}
		
		return;
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response, String view) {
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		return;
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response, String view) {
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		return;
	}	
}
