package com.roster.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.bean.Player;
import com.web.bean.Team;

/**
 * Servlet implementation class DeletePlayer
 */
@WebServlet("/DeletePlayer")
public class DeletePlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePlayer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idTeam= Integer.parseInt(request.getParameter("idTeam"));
		int idPlayer= Integer.parseInt(request.getParameter("idPlayer"));
		
		HttpSession session = request.getSession();
		
		ArrayList<Team> arrayListTeam = new ArrayList<Team>();
		arrayListTeam = (ArrayList<Team>) session.getAttribute("teams");
		
		Team team = new Team();
		team = arrayListTeam.get(idTeam);
		
		Player player = new Player();
		player = team.getArrayListPlayer().get(idPlayer);
		
		team.eliminarPlayer(player);
		//redirigir a get con un parametro en la url
		response.sendRedirect("/Rosters/Teams?idTeam="+idTeam);
		
	}

}
