<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Affichage de toutes les oeuvres à vendre </title>
</head>
<body>
	<P>
		<A href="index.jsp"><FONT face="Arial" color="#004080">Retour
				Accueil</FONT></A>
	</P>
	<P align="center">
		<FONT face="Arial" size="5" color="#004080"><U> <STRONG>Listing&nbsp;des
					Oeuvres à vendre </STRONG></U></FONT>
	</P>

	<TABLE BORDER="1">
		<CAPTION>Tableau des Oeuvres</CAPTION>
		<TR>
			<TH>Titre</TH>
			<TH>Etat</TH>
			<TH>Prix</TH>
			<th>Propriétaire</th>
			<th>Modifier</th>
			<th>Réserver</th>

		</TR>
		<c:forEach items="${mesOeuvres}" var="item">			
			<tr>
				<td>${item.titre}</td>
				<td>${item.etatOeuvrevente}</td>
				<td>${item.prixOeuvrevente}</td>
                <td>${item.proprietaire.getPrenomProprietaire()} ${item.proprietaire.getNomProprietaire()}</td>
                <td><input type = "button" value = "Modifier" onclick="location.href='Controleur?action=modifierOeuvreVente&id=${item.id}'"/></td>
                <td><input type = "button" value = "Réserver" onclick="location.href='Controleur?action=reserverOeuvreVente&id=${item.id}'"/></td>
			</tr>
		</c:forEach>
	</TABLE>
</body>
</html>