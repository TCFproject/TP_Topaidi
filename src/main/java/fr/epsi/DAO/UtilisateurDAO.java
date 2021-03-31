package fr.epsi.DAO;

import fr.epsi.entite.Utilisateur;

public interface UtilisateurDAO {
	Utilisateur rechercherUtilisateur(String utilisateur);

	void creerUtilisateur(Utilisateur u);
}
