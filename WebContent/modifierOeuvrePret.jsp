<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifier Oeuvre Pret</title>
</head>
<body>
	<form  id="form_pret" name='form_pret' method="post" action="Controleur?action=validerModifOeuvrePret&id=${oeuvre.id}" onsubmit="return teste()">
			     <p align="left">    
					<br/>&nbsp;  &nbsp;  &nbsp; Titre de l'oeuvre : 
				    <input type="text" name="txtTitre" value="${oeuvre.titre}"  id ="titre"/>
				     					<br/>&nbsp;  &nbsp;  &nbsp; Proprietaire :
					<select name = "proprietaire">
						<c:forEach items="${mesProprietaires}" var="item">
							<option value = "${item.idProprietaire }">${item.prenomProprietaire } ${item.nomProprietaire }</option>
						</c:forEach>
					</select>	
					
			        <input type="submit" name="bt"  value="Valider" >
		      
				</p>
	</form>
</body>
</html>