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
		<br/>
		<br/>
			<h1> Modification d'un adhérent </h1>
			<div class="container drop-shadow">
				<div class="container">
					<div class="form-group">
						<form name='identification' method="post" action="ControleurAdherent?action=validerModifAdherent&id=${adherent.idAdherent}" onsubmit="return testAdherent()">
						 	<div class="form-inline">
								<br/>Nom de l'adhérent : <input class="form-control" type="text" name="txtnom" value=${adherent.nomAdherent} id ="nom" onchange="nomChanged()"><br/>
								<p id = "alert_nom" style = "display:none;">Veuillez entrer un nom</p>
							</div>
							<div class="form-inline">
								<br/>Prénom de l'adhérent : <input class="form-control" type="text" name="txtprenom" value=${adherent.prenomAdherent} id ="prenom" onchange="prenomChanged()"><br/>
								<p id = "alert_prenom" style = "display:none;">Veuillez entrer un prénom</p>
							</div>
							<div class="form-inline">
								<br/>Ville de l'adhérent : <input class="form-control" type="text" name="txtville" value=${adherent.villeAdherent} id ="ville" onchange="villeChanged()"><br/>
								<p id = "alert_ville" style = "display:none;">Veuillez entrer une ville</p>
							</div>
							<input class="btn btn-success" type="submit" name="bt"  value="Valider" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
