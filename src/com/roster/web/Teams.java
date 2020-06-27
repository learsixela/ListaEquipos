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
 * Servlet implementation class Teams
 */
@WebServlet("/Teams")
public class Teams extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teams() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Teams Do get: ");
		RequestDispatcher view;
		//session
		HttpSession session = request.getSession();
		if(request.getParameter("idTeam")!=null) {
			session.setAttribute("idTeam", request.getParameter("idTeam"));
			//redireccionando a vistas
			 view = request.getRequestDispatcher("/WEB-INF/views/TeamInfo.jsp");
		}else {
			
		//arreglo
		ArrayList<Team> arrayListTeam = new ArrayList<Team>();
		
		if(session.getAttribute("teams")!= null) {
			arrayListTeam = (ArrayList<Team>) session.getAttribute("teams");
		}
		request.setAttribute("teams", arrayListTeam);
		
		//redireccionando a vistas
		 view = request.getRequestDispatcher("/WEB-INF/views/NewTeam.jsp");
		}
		
		// pasar request, y el response
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//instanciar sesion
		HttpSession session = request.getSession();
		//obteenr valor pasado por url o desde el jsp
		String sTeam = request.getParameter("team");
		//crear un arreglo
		ArrayList<Team> arrayListTeam = new ArrayList<Team>();
		
		if(session.getAttribute("teams") != null) {
			//obteniendo el array de los teams
			arrayListTeam = (ArrayList<Team>) session.getAttribute("teams");
		}
		
		Team oTeam = new Team();
		
		//validacion del parametro
		if(!sTeam.trim().equals("")) {
			oTeam.setsNombre(sTeam);
			session.setAttribute("team", oTeam);
			//agregando al arreglo el objeto
			arrayListTeam.add(oTeam);
			//sobre escribiendo en sesion el arreglo
			session.setAttribute("teams", arrayListTeam);
			
			//redireccionando a otro servlet
			response.sendRedirect("/Rosters/Home");
			
		}else {
			response.getWriter().append("Error en el ingreso del team ");
		}
		
		
	}

	
	
	
	
	
	
	
	
	
}
