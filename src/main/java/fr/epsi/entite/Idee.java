package fr.epsi.entite;

import java.awt.Window.Type;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Idee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titre;
	private String description;
	private String imgUrl;

	@OneToOne(cascade = CascadeType.ALL)
	private Categorie categorie;

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public String getDescription() {
		return description;
	}

	public Long getId() {
		return id;
	}

	public String getTitre() {
		return titre;
	}

	public String getImgUrl() {
		return imgUrl;
	}
}
