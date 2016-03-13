<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reserver Oeuvre Vente</title>
</head>
<body>
	<jsp:include page="index.jsp"/>
	<div class="form-group">
		<form id="form_reservation" name="form_reservation" method="post" action="ControleurReservation?action=validerReserverOeuvreVente&id=${oeuvre.id}" onsubmit="return teste()">
			<p align="left">    
				<br/>Titre de l'oeuvre : ${oeuvre.titre}
	   			<br/>Prix de l'oeuvre : ${oeuvre.prixOeuvrevente}
	   			<br/>Date Réservation :
	   			<span class="form-inline"> 
	   				<input class="form-control" type = "text" id = "dateReservation" name = "dateReservation"/>
	   			</span>
	   			<br/>
	   			<div class="form-inline">
	   			Acheteur:
		   			<select class="form-control" name="adherent">
			   			<c:forEach items = "${adherents}" var="item">
							<option value = "${item.idAdherent }">${item.prenomAdherent } ${item.nomAdherent }</option>
						</c:forEach>
		   			</select><br/>
	   			</div>
	   			<input class="btn btn-success" type = "submit" name = "bt"  value = "Valider" />
	   	</form>
   	</div> 
</body>
</html>