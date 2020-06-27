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

import com.web.bean.Player;
import com.web.bean.Team;

/**
 * Servlet implementation class Players
 */
@WebServlet("/Players")
public class Players extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Players Do get: ");
		
		//redireccionando
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/NewPlayer.jsp");
		// pasar request, y el response
		view.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//obtener datos desde jsp
		String sPlayerFName= request.getParameter("fname");
		String sPlayerLName= request.getParameter("lname");
		String sPlayerAge = request.getParameter("age");
		String sIdTeam = request.getParameter("idTeam");
		Integer iPlayerEdad =0;
		if(!sPlayerAge.trim().equals("")) {
			 iPlayerEdad = Integer.parseInt(sPlayerAge);
		}
		
		//instanciar clase
		Player player = new Player(); 
		//seteando datos al objeto
		player.setFirst_name(sPlayerFName);
		player.setLast_name(sPlayerLName);
		player.setAge(iPlayerEdad);
		
		Integer idTeam = Integer.parseInt(sIdTeam);
		ArrayList<Team> arrayListTeam = new ArrayList<Team>();
		//acceder al arreglo en sesion?
		//session
		HttpSession session = request.getSession();
		arrayListTeam = (ArrayList<Team>) session.getAttribute("teams");
		
		arrayListTeam.get(idTeam).agregarPlayer(player);
		
		//redireccionando
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/TeamInfo.jsp");
		// pasar request, y el response
		view.forward(request, response);
		
	}

}
