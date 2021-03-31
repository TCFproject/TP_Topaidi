package fr.epsi.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom_pseudo;

	public void setId(Long id) {
		this.id = id;
	}

	public void setNom_pseudo(String nom_pseudo) {
		this.nom_pseudo = nom_pseudo;
	}

	public String getNom_pseudo() {
		return nom_pseudo;
	}
}
