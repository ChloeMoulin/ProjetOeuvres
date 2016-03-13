<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifier un adhérent</title>
</head>
<body>
<jsp:include page="index.jsp"/>
	<h1> Modification d'un adhérent </h1>
	<div class="form-group">
		<form name='identification' method="post" action="Controleur?action=validerModifAdherent&id=${adherent.idAdherent}" onsubmit="return teste()">
		 	<div class="form-inline">
				<br/>Nom de l'adhérent : <input class="form-control" type="text" name="txtnom" value=${adherent.nomAdherent} id ="nom"><br/>
			</div>
			<div class="form-inline">
				<br/>Prénom de l'adhérent : <input class="form-control" type="text" name="txtprenom" value=${adherent.prenomAdherent} id ="prenom"><br/>
			</div>
			<div class="form-inline">
				<br/>Ville de l'adhérent : <input class="form-control" type="text" name="txtville" value=${adherent.villeAdherent} id ="ville"><br/>
			</div>
			<input class="btn btn-success" type="submit" name="bt"  value="Valider" />
		</form>
	</div>
</body>
</html>