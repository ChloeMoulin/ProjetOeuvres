<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Affichage de toutes les oeuvres à prêter </title>
</head>
<body>
<jsp:include page="index.jsp"/>
	<P>
		<A href="index.jsp"><FONT face="Arial" color="#004080">Retour
				Accueil</FONT></A>
	</P>
	<P align="center">
		<FONT face="Arial" size="5" color="#004080"><U> <STRONG>Listing&nbsp;des
					Oeuvres à prêter </STRONG></U></FONT>
	</P>
	<div class="col-md-6">
		<TABLE class="table table-hover">
			<CAPTION>Tableau des Oeuvres</CAPTION>
			<TR>
				<TH>Titre</TH>
				<th>Propriétaire</th>
				<th>Modifier</th>
				<th>Supprimer</th>
			</TR>
			<c:forEach items="${mesOeuvres}" var="item">			
				<tr>
					<td>${item.titre}</td>
	                <td>${item.proprietaire.getPrenomProprietaire()} ${item.proprietaire.getNomProprietaire()}</td>
	                <td><a class="btn btn-primary" href="Controleur?action=modifierOeuvrePret&id=${item.id}"><i class="fa fa-pencil-square-o"></i></a></td>
				   	<td><a class="btn btn-danger" href="Controleur?action=supprimerOeuvrePret&id=${item.id}"><i class="fa fa-trash"></i></a></td>
				</tr>
			</c:forEach>
		</TABLE>
	</div>
</body>
</html>