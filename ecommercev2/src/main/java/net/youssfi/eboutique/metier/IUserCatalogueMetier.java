package net.youssfi.eboutique.metier;

import java.util.List;
import net.youssfi.eboutique.entities.Categorie;
import net.youssfi.eboutique.entities.Produit;

public interface IUserCatalogueMetier {
	public List<Categorie> listCategories();

	public Categorie getCategorie(Long idCat);

	public List<Produit> listproduits();

	public List<Produit> produitsParMotCle(String mc);

	public List<Produit> produitsSelectionnes();

	public Produit getProduit(Long idP);

	public List<Produit> produitsParCategorie(Long idCat);
}