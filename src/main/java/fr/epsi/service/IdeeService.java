package fr.epsi.service;

import java.util.List;

import fr.epsi.entite.Idee;

public interface IdeeService {
	List<Idee> listIdee();

	void creerNouvelleIdee(String desc, String url, String titre, String cathe);
}
