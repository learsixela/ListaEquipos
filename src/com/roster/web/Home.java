package com.roster.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.bean.Team;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Home Do get: ");
		//session
		HttpSession session = request.getSession();
		//arreglo
		ArrayList<Team> arrayListTeam = new ArrayList<Team>();
		
		if(session.getAttribute("teams")!= null) {
			arrayListTeam = (ArrayList<Team>) session.getAttribute("teams");
		}
		request.setAttribute("teams", arrayListTeam);
		
		//redireccionando
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/Equipos.jsp");
		// pasar request, y el response
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}

}
