<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modifier Oeuvre Pret</title>
		<script type="text/javascript" src="js/fonctControle.js"></script>
		<script type="text/javascript" src="js/jquery-2.0.0.js"></script>
</head>
	<body>
		<jsp:include page="index.jsp"/>
		<div class = "container_body">
			<p align="center">
				<br/>
				<br/>
				<h2> Modification d'une oeuvre pour le prêt </h2> 
			</p>
			<div class="container drop-shadow">
				<div class="container">
					<br/>
					<form  id="form_pret" name='form_pret' method="post" action="ControleurOeuvrePret?action=validerModifOeuvrePret&id=${oeuvre.id }" onsubmit="return testOeuvrePret()">
					     <fieldset class="form-group" >					    	
						    <label for= "titre_pret">Titre :</label>   
							<input class="form-control" type="text" name="txtTitre" value='${oeuvre.titre}' id ="titre_pret" onchange="titrePretChanged()">
			   				<p class = "alert" id = "alert_titre_pret" style = "display:none;"><i class="fa fa-exclamation-triangle"></i>Veuillez entrer un titre</p><br/>
							
							<label for= "proprietaire">Proprietaire :</label> 
							<select class="form-control" name = "proprietaire">
								<c:forEach items="${mesProprietaires}" var="item">
									<option value = '${item.idProprietaire }'>${item.prenomProprietaire } ${item.nomProprietaire }</option>
								</c:forEach>
							</select>
							<p class="alert" id = "alert_proprietaire" style = "display:none;"><i class="fa fa-exclamation-triangle"></i>Veuillez sélectionner un proprietaire</p><br/>
							
							<br/>
						    <input class="btn btn-success" type="submit" name="bt"  value="Valider" >
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>