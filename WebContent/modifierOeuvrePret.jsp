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
	<div class="form-group">
		<form id="form_pret" name='form_pret' method="post" action="ControleurOeuvrePret?action=validerModifOeuvrePret&id=${oeuvre.id}" onsubmit="return testOeuvrePret()">
		     <p align="left">
		     	<div class="form-inline">
					<br/>Titre de l'oeuvre : 
			    	<input class="form-control" type="text" name="txtTitre" value="${oeuvre.titre}"  id ="titre_pret" onchange="titrePretChanged()"/>
			    	<p id = "alert_titre_pret" style = "display:none;">Veuillez entrer un titre</p>
			    </div>    
			    
			    <div class="form-inline"> 					
					<br/>Proprietaire :
					<select class="form-control" name = "proprietaire" onchange="proprietaireChanged()">
						<c:forEach items="${mesProprietaires}" var="item">
							<option value = "${item.idProprietaire }">${item.prenomProprietaire } ${item.nomProprietaire }</option>
						</c:forEach>
					</select>
				</div>	
				
		        <input class="btn btn-success" type="submit" name="bt"  value="Valider" />
			</p>
		</form>
	</div>
</body>
</html>