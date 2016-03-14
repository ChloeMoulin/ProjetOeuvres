<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Ajouter un proprietaire</title>
		<script language="Javascript" type="text/javascript"></script>
	</head>
	<body>
		<jsp:include page="index.jsp"/> 
		<div class = "container_body">
			<p align="center">
				<br/>
				<br/>
				<h2> Ajout d'un propriétaire </h2> 
			</p>
			<div class="container drop-shadow">
				<div class="container">
					<br/>
					<form  name='identification' method="post" action="ControleurProprietaire?action=insererProprietaire" onsubmit="return teste()">
					     <fieldset class="form-group" >
						    <label for="nom">Nom : </label>
							<input class="form-control" type="text" name="txtnom" value=""  id ="nom" onchange="nomChanged()"/><br/>
	
							<label for="prenom">Prénom : </label>
						    <input class="form-control" type="text" name="txtprenom"  id ="prenom" onchange="prenomChanged()"/><br/>
								
							<br/>				          
					        <input class="btn btn-success" type="submit" name="bt"  value="Ajouter" />
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>