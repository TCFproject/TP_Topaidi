package fr.epsi.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import fr.epsi.entite.Idee;

public class IdeeDAOImpl implements IdeeDAO {

	private EntityManager em;
	private UserTransaction utx;

	public IdeeDAOImpl(EntityManager em, UserTransaction utx) {
		this.em = em;
		this.utx = utx;
	}

	public List<Idee> listIdee() {
		List<Idee> listIdees = em.createQuery("select i from Idee i", Idee.class).getResultList();
		return listIdees;
	}

	public void ajoutIdee(Idee idee) {
		// TODO Auto-generated method stub
		try {
			utx.begin();
			em.persist(idee);
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

}