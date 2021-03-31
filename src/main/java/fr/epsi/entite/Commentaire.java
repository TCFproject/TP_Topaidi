package fr.epsi.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import fr.epsi.Vote;

@Entity
public class Commentaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Utilisateur utilisateur;
	@ManyToOne
	private Idee idee;
	private String commantaire;
	private Vote vote;

	public void setId(Long id) {
		this.id = id;
	}

	public void setCommantaire(String commantaire) {
		this.commantaire = commantaire;
	}

	public void setIdee(Idee idee) {
		this.idee = idee;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public void setVote(Vote vote) {
		this.vote = vote;
	}

	public Long getId() {
		return id;
	}

	public String getCommantaire() {
		return commantaire;
	}

	public Idee getIdee() {
		return idee;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public Vote getVote() {
		return vote;
	}
}
