<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Affichage de tous les adhérents</title>
	</head>
	
	<body>
		<jsp:include page="index.jsp" />
		<div class = "container_body">
			<p align="center">
				<br/>
				<br/>
				<h2> Listing des Adhérents </h2> 
				<p class = "add">
					<a class="btn btn-success" href="ControleurAdherent?action=ajouterAdherent">Ajouter un adhérent</a>
				</p>
			</p>
			<table class="table table-hover">
				<tr>
					<th>Numero</th>
					<th>Nom</th>
					<th>Prénom</th>
					<th>Ville</th>
					<th>Modifier</th>
					<th>Supprimer</th>
				</tr>
				<c:forEach items="${mesAdherents}" var="item">			
					<tr>
						<td>${item.idAdherent}</td>
						<td>${item.nomAdherent}</td>
						<td>${item.prenomAdherent}</td>
		                <td>${item.villeAdherent}</td>
		                <td><a class="btn btn-primary" href="ControleurAdherent?action=modifierAdherent&id=${item.idAdherent}"><i class="fa fa-pencil-square-o"></i></a></td>
		                <td><a class="btn btn-danger" href="ControleurAdherent?action=supprimerAdherent&id=${item.idAdherent}"><i class="fa fa-trash"></i></a></td>
					</tr>
				</c:forEach>
			</table>
		</div>	
	</body>
</html>