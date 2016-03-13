<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajouter un proprietaire</title>
</head>
<script language="Javascript" type="text/javascript"></script>
<script type="text/javascript" src="js/foncControle.js"></script>


<body>
	<jsp:include page="index.jsp"/> 
	<h1> Ajout d'un proprietaire</h1>
	<div class="form-group">
		<form  name='identification' method="post" action="ControleurProprietaire?action=insererProprietaire" onsubmit="return teste()">
		     <p align="left">
			     <div class="form-inline">
					<br/>Nom du proprietaire :
				    <input class="form-control" type="text" name="txtnom" value=""  id ="nom" onchange="nomChanged()"/> <br/>
			   	</div>
			   	<div class="form-inline">
			       
					<br/>Prénom du proprietaire : 
			        <input class="form-control" type="text" name="txtprenom"  id ="prenom" onchange="prenomChanged()"/> <br/>
		        </div>
		        <br/>
		          <!-- Boutons Ajouter -->
		          
		        <input class="btn btn-success" type="submit" name="bt"  value="Ajouter" />
		        &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
			</p>
		</form>
	</div>
</body>
</html>