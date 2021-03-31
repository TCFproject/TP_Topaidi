package fr.epsi.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import fr.epsi.entite.Utilisateur;

public class UtilisateurDAOImpl implements UtilisateurDAO {

	private EntityManager em;
	private UserTransaction utx;

	public UtilisateurDAOImpl(EntityManager em, UserTransaction utx) {
		this.em = em;
		this.utx = utx;
	}

	public void creerUtilisateur(Utilisateur u) {
		// TODO Auto-generated method stub

		try {
			utx.begin();
			em.persist(u);
			System.out.print("c'est persist");
			utx.commit();
			System.out.print("c'est commit");

		} catch (NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Utilisateur rechercherUtilisateur(String utilisateur) {
		// TODO Auto-generated method stub
		/*
		 * Utilisateur rchUser =
		 * em.createQuery("select u from Utilisateur u where u.nom_pseudo = :nom_pseudo"
		 * , Utilisateur.class) .setParameter("nom_pseudo", utilisateur)
		 * .getSingleResult();
		 */
		return em.createQuery("select u from Utilisateur u where u.nom_pseudo = :nom_pseudo", Utilisateur.class)
				.setParameter("nom_pseudo", utilisateur).getResultList().stream().findFirst().orElse(null);
	}
}
