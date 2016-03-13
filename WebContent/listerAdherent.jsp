<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Affichage de tous les adhérents</title>
<script type="text/javascript" src="js/jquery-2.0.0.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="js/bootstrap.js"></script>
</head>
<body>
	<P>
		<A href="index.jsp"><FONT face="Arial" color="#004080">Retour
				Accueil</FONT></A>
	</P>
	<P align="center">
		<FONT face="Arial" size="5" color="#004080"><U> <STRONG>Listing&nbsp;des
					Adhérents </STRONG></U></FONT>
	</P>
	<div class="col-md-6">
		<TABLE class="table table-hover">
			<CAPTION>Tableau des Adhérents</CAPTION>
			<TR>
				<TH style="text-align:center">Numero</TH>
				<TH style="text-align:center">Nom</TH>
				<TH style="text-align:center">Prénom</TH>
				<TH style="text-align:center">Ville</TH>
			</TR>
			<c:forEach items="${mesAdherents}" var="item">			
				<tr>
					<td style="text-align:center" style="vertical-align:center">${item.idAdherent}</td>
					<td style="text-align:center" style="vertical-align:center">${item.nomAdherent}</td>
					<td style="text-align:center" style="vertical-align:center">${item.prenomAdherent}</td>
	                <td style="text-align:center" style="vertical-align:center">${item.villeAdherent}</td>
	                <td><input class="btn btn-primary center-block"  style="align:center" style="vertical-align:center" type = "button" value = "Modifier" onclick="location.href='Controleur?action=modifierAdherent&id=${item.idAdherent}'"/></td>
	                <td><input type = "button" value = "Supprimer" onclick="location.href='Controleur?action=supprimerAdherent&id=${item.idAdherent}'"/></td>
				</tr>
			</c:forEach>
		</TABLE>
	</div>
</body>
</html>