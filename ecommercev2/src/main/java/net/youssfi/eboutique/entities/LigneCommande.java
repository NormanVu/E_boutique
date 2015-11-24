package net.youssfi.eboutique.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class LigneCommande implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "idproduit")
	private Produit produit;
	private int quantite;
	private double prix;
	public LigneCommande( int quantite, double prix) {
		super();
		
		this.quantite = quantite;
		this.prix = prix;
	}
	public LigneCommande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}

}