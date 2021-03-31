package fr.epsi.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import fr.epsi.entite.Categorie;

public class CategorieDAOImpl implements CategorieDAO {

	private EntityManager em;
	private UserTransaction utx;

	public CategorieDAOImpl(EntityManager em, UserTransaction utx) {
		this.em = em;
		this.utx = utx;
	}

	public List<Categorie> listCathegorie() {
		// TODO Auto-generated method stub

		return em.createQuery("select c from Categorie c", Categorie.class).getResultList();
	}

}
