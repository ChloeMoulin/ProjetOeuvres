<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajouter une Oeuvre pour le prêt</title>
<script language="Javascript" type="text/javascript"></script>
<script type="text/javascript" src="js/fonctControle.js"></script>
<script type="text/javascript" src="js/jquery-2.0.0.js"></script>
</head>
<body>
	<jsp:include page="index.jsp"/>
	<h1> Ajout d'une oeuvre pour le prêt</h1>
		<div class="form-group">
			<form  id="form_pret" name='form_pret' method="post" action="ControleurOeuvrePret?action=insererOeuvrePret" onsubmit="return testOeuvrePret()">
			     <div class="form-inline">   
					<br/>&nbsp;  &nbsp;  &nbsp; Titre de l'oeuvre : 
				    <input class="form-control" type="text" name="txtTitre" value="" id ="titre" onchange="titrePretChanged()">
   				    <p id = "alert_titre_pret" style = "display:none;">Veuillez entrer un titre</p>
				 </div>
				 <div class="form-inline">
				     <br/>&nbsp;  &nbsp;  &nbsp; Proprietaire :
					<select class="form-control" name = "proprietaire">
						<c:forEach items="${mesProprietaires}" var="item">
							<option value = "${item.idProprietaire }">${item.prenomProprietaire } ${item.nomProprietaire }</option>
						</c:forEach>
					</select>
					<p id = "alert_proprietaire" style = "display:none;">Veuillez sélectionner un proprietaire</p>
					</div>	
					<br/>
			        <input class="btn btn-success" type="submit" name="bt"  value="Ajouter" >
			</form>
		</div>
</body>
</html>