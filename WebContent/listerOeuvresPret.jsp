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
		<div class = "container_body">
			<div class="col-md-6">
				<p align="center">
					<h1>Listing des Oeuvres à prêter</h1>
				</p>
				<TABLE class="table table-hover">
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
			                <td><a class="btn btn-primary" href="ControleurOeuvrePret?action=modifierOeuvrePret&id=${item.id}"><i class="fa fa-pencil-square-o"></i></a></td>
						   	<td><a class="btn btn-danger" href="ControleurOeuvrePret?action=supprimerOeuvrePret&id=${item.id}"><i class="fa fa-trash"></i></a></td>
						</tr>
					</c:forEach>
				</TABLE>
			</div>
			<div id="footer">
				<a href="index.jsp">Accueil</a>
			</div>
		</div>
	</body>
</html>