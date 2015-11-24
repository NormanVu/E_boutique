<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<table>
		<tr>
<!-- 			<td><img  -->
<!-- 				src="/resources/images/panier.jpg"/></td> -->
<!-- 			<td> -->
			</td>
			<td class="pan">
				<div>
					<table>
						<tr>
<!-- 							<td colspan="2"><img id="imgPanier" -->
<!-- 								src="/resources/images/panier.jpg" -->
<!-- 								onclick="affichePanier()"/></td> -->
						</tr>
						<tr>
							<td>Nombre de produits :</td>
							<td>${panier.size}</td>
						</tr>
						<tr>
							<td>Total :</td>
							<td>${panier.total}</td>
						</tr>
					</table>
				</div>
			</td>
		</tr>
	</table>
</div>

<table>
	<c:forEach items="${categories }" var="cat">
		<tr>
			<td><a href="produitsParCat?idCat=${cat.idCategorie}">
					${cat.nomCategorie} </a></td>
		</tr>
	</c:forEach>
</table>

<div id="panier" style="display: none">
	<c:if test="${panier.size!=0}">
		<table>
			<tr>
				<th>ID</th>
				<th>Désignation</th>
				<th>Prix</
				<th>Quantité</th>
				<th>Montant</th>
			</tr>
			<c:forEach items="${panier.items}" var="art">
				<tr>
					<td>${art.produit.idProduit}</td>
					<td>${art.produit.designation}</td>
					<td>${art.produit.prix}</td>
					<td>${art.quantite}</td>
					<td>${art.quantite*art.produit.prix}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="4">Total</td>
				<td>${panier.total}</td>
			</tr>
		</table>
	</c:if>
</div>
<div id="catalogueProduits">
	<c:forEach items="${produits}" var="p">
		<div class="ficheProduit">
			<table>
				<tr>
					<td colspan="2"><img src="photoProduit?idP=${p.idProduit }"></td>
				</tr>
				<tr>
					<td>Désignation :</td>
					<td>${p.designation }</td>
				</tr>
				<tr>
					<td>Prix :</td>
					<td>${p.prix}</td>
				</tr>
				<tr>
					<td>Stock:</td>
					<td>${p.quantite}</td>
				</tr>
				<tr>
					<td>${p.description }</td>
				</tr>
				<tr>
					<td colspan="2">
						<form action="ajouterAuPanier">
							<input type="hidden" value="${p.idProduit}" name="idProduit">
							<input type="text" value="1" name="quantite"> <input
								type="submit" value="Ajouter au panier">
						</form>
					<td>
				</tr>
			</table>
		</div>
	</c:forEach>
</div>