package net.youssfi.eboutique.metier;

import net.youssfi.eboutique.entities.Produit;


public interface IAdminProduitMetier extends InternauteBoutiqueMetier {
	public Long ajouterProduit(Produit p, Long idCat);

	public void supprimerProduit(Long idP);

	public void modifierProduit(Produit p);
}
