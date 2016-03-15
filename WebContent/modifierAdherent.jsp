<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<script type="text/javascript" src="js/fonctControle.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Modifier un adhérent</title>
	</head>
	<body>
	<jsp:include page="index.jsp"/>
		<div class = "container_body">
			<p align="center">
				<br/>
				<br/>
				<h2> Modification d'un adhérent </h2> 
			</p>
			<div class="container drop-shadow">
				<div class="container">
					<br/>
					<form name='identification' method="post" action="ControleurAdherent?action=validerModifAdherent&id=${adherent.idAdherent}" onsubmit="return testAdherent()">
						<fieldset class="form-group" >
							<label for= "nom">Nom :</label>
							<input class="form-control" type="text" name="txtnom" value='${adherent.nomAdherent}' id ="nom" onchange="nomChanged()"/>
							<p class="alert" id = "alert_nom" style = "display:none;"><i class="fa fa-exclamation-triangle"></i>Veuillez entrer un nom</p><br/>
							
							<label for= "nom">Prénom :</label>
							<input class="form-control" type="text" name="txtprenom" value='${adherent.prenomAdherent}' id ="prenom" onchange="prenomChanged()"/>
							<p class="alert" id = "alert_prenom" style = "display:none;"><i class="fa fa-exclamation-triangle"></i>Veuillez entrer un prénom</p><br/>
							
							<label for= "nom">Ville :</label>
							<input class="form-control" type="text" name="txtville" value='${adherent.villeAdherent}' id ="ville" onchange="villeChanged()"/>
							<p class="alert" id = "alert_ville" style = "display:none;"><i class="fa fa-exclamation-triangle"></i>Veuillez entrer une ville</p><br/>
							
							<input class="btn btn-success" type="submit" name="bt"  value="Valider" />
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
