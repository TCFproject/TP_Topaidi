package fr.epsi.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.service.CategorieService;
import fr.epsi.service.UtilisateurService;

@WebServlet("/")
public class HomeController extends HttpServlet {

	@EJB
	private UtilisateurService UserService;

	@EJB
	private CategorieService catheServ;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// req.setAttribute("listCathe", catheServ.listCathe());
		req.setAttribute("test", catheServ.gettestService());
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Connexion");
		UserService.ConnectUser(req.getParameter("user"));
	}
}
