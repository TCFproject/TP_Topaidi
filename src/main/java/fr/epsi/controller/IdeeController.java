package fr.epsi.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.service.CategorieService;
import fr.epsi.service.IdeeService;

@WebServlet("/idee")
public class IdeeController extends HttpServlet {

	@EJB
	private IdeeService ideeServ;

	@EJB
	private CategorieService catheServ;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pseudo = req.getParameter("user");
		req.setAttribute("test", pseudo);
		req.setAttribute("cathe", catheServ.listCathe());
		req.setAttribute("listIdee", ideeServ.listIdee());
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ListIdee.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String description = req.getParameter("description");
		String url = req.getParameter("url");
		String titre = req.getParameter("titre");
		String cathegorie = req.getParameter("cathegorie");

		this.ideeServ.creerNouvelleIdee(description, url, titre, cathegorie);
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ListIdee.jsp").forward(req, resp);
	}
}
