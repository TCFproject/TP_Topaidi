package fr.epsi.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.epsi.DAO.CategorieDAO;
import fr.epsi.DAO.CategorieDAOImpl;
import fr.epsi.DAO.IdeeDAO;
import fr.epsi.DAO.IdeeDAOImpl;
import fr.epsi.entite.Categorie;
import fr.epsi.entite.Idee;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class IdeeServiceImpl implements IdeeService {

	@PersistenceContext
	private EntityManager em;
	@Resource
	private UserTransaction utx;

	public List<Idee> listIdee() {
		IdeeDAO ideeDAO = new IdeeDAOImpl(em, utx);
		return ideeDAO.listIdee();
	}

	public void creerNouvelleIdee(String desc, String url, String titre, String cathe) {
		// TODO Auto-generated method stub
		CategorieDAO catheDAO = new CategorieDAOImpl(em, utx);
		IdeeDAO ideeDAO = new IdeeDAOImpl(em, utx);

		Categorie laCathe = new Categorie();
		laCathe.setLibelle(cathe);

		Idee idee = new Idee();
		idee.setDescription(desc);
		idee.setImgUrl(url);
		idee.setTitre(titre);
		idee.setCategorie(laCathe);
		ideeDAO.ajoutIdee(idee);
	}
}
