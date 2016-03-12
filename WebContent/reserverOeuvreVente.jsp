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
	<form id="form_reservation" name="form_reservation" method="post" action="Controleur?action=validerReserverOeuvreVente&id=${oeuvre.id}" onsubmit="return teste()">
		<p align="left">    
			<br/>&nbsp;  &nbsp;  &nbsp; Titre de l'oeuvre : ${oeuvre.titre}
   			<br/>&nbsp;  &nbsp;  &nbsp; Prix de l'oeuvre : ${oeuvre.prixOeuvrevente}
   			<br/>&nbsp;  &nbsp;  &nbsp; Date Réservation : 
   			<input type = "text" id = "dateReservation" name = "dateReservation"/>
   			<br/>&nbsp;  &nbsp;  &nbsp;
   			<select name="adherent">
	   			<c:forEach items = "${adherents}" var="item">
					<option value = "${item.idAdherent }">${item.prenomAdherent } ${item.nomAdherent }</option>
				</c:forEach>
   			</select><br/>
   			<input type = "submit" name = "bt"  value = "Valider" />
   	</form> 
</body>
</html>