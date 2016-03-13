<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Modifier une oeuvre</title>
		<SCRIPT language="Javascript" type="text/javascript"></script>
		<script type="text/javascript" src="js/fonctControle.js"></script>
		<script type="text/javascript" src="js/jquery-2.0.0.js"></script>
	</head>
	<body>
		<div align="center">
			<form id="form_vente" name='form_vente' method="post" action="Controleur?action=validerModifOeuvreVente&id=${oeuvre.id}" onsubmit="return testOeuvreVente()">
			     <p align="left">    
					<br/>&nbsp;  &nbsp;  &nbsp; Titre de l'oeuvre : 
				    <input type="text" name="txtTitre" value="${oeuvre.titre}"  id ="titre"/ onchange="titreChanged()">
				    <p id = "alert_titre" style = "display:none;">Veuillez entrer un titre</p>
				    
					<br/>&nbsp;  &nbsp;  &nbsp; Prix de l'oeuvre :
					<input type="number" name="numberPrix" value = "${oeuvre.prixOeuvrevente.toString()}" id="prix" onchange="prixChanged()">
					<p id = "alert_prix" style = "display:none;">Veuillez entrer un prix</p>
					<br/>&nbsp;  &nbsp;  &nbsp; Etat de l'oeuvre : 
					<select name = "etatOeuvre">
						<option value="L" selected>L</option>
						<option value ="R">R</option>
					</select>
					
					<br/>&nbsp;  &nbsp;  &nbsp; Proprietaire :
					<select name = "proprietaire" onchange="proprietaireChanged()">
						<c:forEach items="${mesProprietaires}" var="item">
							<option value = "${item.idProprietaire }">${item.prenomProprietaire } ${item.nomProprietaire }</option>
						</c:forEach>
					</select>
					<p id = "alert_proprietaire" style = "display:none;">Veuillez sélectionner un proprietaire</p>
							
			          
			        <input type="submit" name="bt"  value="Valider" >
				      
				</p>
			</form>
		</div>
	</body>
</html>