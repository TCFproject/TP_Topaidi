package fr.epsi.DAO;

import java.util.List;

import fr.epsi.entite.Idee;

public interface IdeeDAO {
	void ajoutIdee(Idee idee);

	List<Idee> listIdee();
}
