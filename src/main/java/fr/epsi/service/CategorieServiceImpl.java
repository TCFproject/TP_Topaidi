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
import fr.epsi.entite.Categorie;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class CategorieServiceImpl implements CategorieService {

	@PersistenceContext
	private EntityManager em;
	@Resource
	private UserTransaction utx;

	public List<Categorie> listCathe() {
		// TODO Auto-generated method stub
		CategorieDAO catheDAO = new CategorieDAOImpl(em, utx);
		return catheDAO.listCathegorie();
	}

	public String gettestService() {
		return "Hello";
	}

}
