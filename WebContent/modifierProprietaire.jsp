<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifier un Propriétaire</title>
</head>
<body>
	<h1> Modification d'un propriétaire </h1>
	 <form name='identification' method="post" action="Controleur?action=validerModifProprietaire&id=${proprietaire.idProprietaire}" onsubmit="return teste()">
		Nom du Propriétaire : <input type="text" name="txtnom" value=${proprietaire.nomProprietaire}  id ="nom"><br/>
		Prénom du Propriétaire : <input type="text" name="txtprenom" value=${proprietaire.prenomProprietaire}  id ="prenom"><br/>
		<input type="submit" name="bt"  value="Valider" />
	</form>
</body>
</html>