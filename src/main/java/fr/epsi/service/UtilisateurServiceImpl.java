package fr.epsi.service;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.epsi.DAO.UtilisateurDAO;
import fr.epsi.DAO.UtilisateurDAOImpl;
import fr.epsi.entite.Utilisateur;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class UtilisateurServiceImpl implements UtilisateurService {

	@PersistenceContext
	private EntityManager em;
	@Resource
	private UserTransaction utx;

	public void ConnectUser(String u) {
		UtilisateurDAO userDAO = new UtilisateurDAOImpl(em, utx);
		if (userDAO.rechercherUtilisateur(u) == null) {
			System.out.print("entrer");
			Utilisateur user = new Utilisateur();
			user.setNom_pseudo(u);
			userDAO.creerUtilisateur(user);
		}
	}
}
