<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/fonctControle.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Modifier un adhérent</title>
</head>
<body>

	<h1> Modification d'un adhérent </h1>
	 <form name='identification' method="post" action="Controleur?action=validerModifAdherent&id=${adherent.idAdherent}" onsubmit="return testAdherent()">
		Nom de l'adhérent : <input type="text" name="txtnom" value=${adherent.nomAdherent}  id ="nom" onchange="nomChanged()"><br/>
		<p id = "alert_nom" style = "display:none;">Veuillez entrer un nom</p>
		Prénom de l'adhérent : <input type="text" name="txtprenom" value=${adherent.prenomAdherent}  id ="prenom" onchange="prenomChanged()"><br/>
		<p id = "alert_prenom" style = "display:none;">Veuillez entrer un prénom</p>
		
		Ville de l'adhérent : <input type="text" name="txtville" value=${adherent.villeAdherent}  id ="ville" onchange="villeChanged()"><br/>
		<p id = "alert_ville" style = "display:none;">Veuillez entrer une ville</p>
		
		<input type="submit" name="bt"  value="Valider" />
	</form>
</body>
</html>
