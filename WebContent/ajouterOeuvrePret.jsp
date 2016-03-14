<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajouter une oeuvre pour le prêt</title>
<script language="Javascript" type="text/javascript"></script>
<script type="text/javascript" src="js/fonctControle.js"></script>
<script type="text/javascript" src="js/jquery-2.0.0.js"></script>
</head>
	<body>
		<jsp:include page="index.jsp"/>
		<div class = "container_body">
		<br/>
		<br/>
			<h1> Ajout d'une oeuvre pour le prêt</h1>
			<div class="container drop-shadow">
				<div class="container">
					<div class="form-group">
						<form  id="form_pret" name='form_pret' method="post" action="ControleurOeuvrePret?action=insererOeuvrePret" onsubmit="return testOeuvrePret()">
						     <div class="form-inline">   
								<br/>Titre de l'oeuvre : 
							    <input class="form-control" type="text" name="txtTitre" value="" id ="titre" onchange="titrePretChanged()">
			   				    <p class = "alert" id = "alert_titre_pret" style = "display:none;"><i class="fa fa-exclamation-triangle"></i>Veuillez entrer un titre</p>
							 </div>
							 <div class="form-inline">
							    <br/>Proprietaire :
								<select class="form-control" name = "proprietaire">
									<c:forEach items="${mesProprietaires}" var="item">
										<option value = "${item.idProprietaire }">${item.prenomProprietaire } ${item.nomProprietaire }</option>
									</c:forEach>
								</select>
								<p class="alert" id = "alert_proprietaire" style = "display:none;"><i class="fa fa-exclamation-triangle"></i>Veuillez sélectionner un proprietaire</p>
							</div>	
							<br/>
						    <input class="btn btn-success" type="submit" name="bt"  value="Ajouter" >
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>