<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifier un Propri�taire</title>
</head>
<body>
<jsp:include page="index.jsp"/>
	<h1> Modification d'un propri�taire </h1>
	<div class="form-group">
		<form name='identification' method="post" action="ControleurProprietaire?action=validerModifProprietaire&id=${proprietaire.idProprietaire}" onsubmit="return teste()">
			<div class="form-inline">
				<br/>Nom du Propri�taire : <input class="form-control" type="text" name="txtnom" value=${proprietaire.nomProprietaire}  id ="nom"><br/>
			</div>
			<div class="form-inline">
				<br/>Pr�nom du Propri�taire : <input class="form-control" type="text" name="txtprenom" value=${proprietaire.prenomProprietaire}  id ="prenom"><br/>
			</div>
			<input class="btn btn-success" type="submit" name="bt"  value="Valider" />
		</form>
	</div>
</body>
</html>