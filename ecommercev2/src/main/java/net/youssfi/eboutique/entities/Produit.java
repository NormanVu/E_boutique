package net.youssfi.eboutique.entities;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Produit implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduit;
	@NotEmpty
	private String designation;
	private String description;
	private double prix;
	private String photo;
	private int quantite;
	private boolean selectionne;
	@ManyToOne
	@JoinColumn(name = "ID_CAT")
	private Categorie categorie;
	public Produit( String designation, String description,
			double prix, String photo, int quantite, boolean selectionne) {
		super();
		
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.photo = photo;
		this.quantite = quantite;
		this.selectionne = selectionne;
		
	}
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public boolean isSelectionne() {
		return selectionne;
	}
	public void setSelectionne(boolean selectionne) {
		this.selectionne = selectionne;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	
}