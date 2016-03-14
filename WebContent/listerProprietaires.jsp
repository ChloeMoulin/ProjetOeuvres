<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN" "http://www.w3.org/tr/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Affichage de tous les proprietaires</title>
	</head>
	
	<body>
	<jsp:include page="index.jsp"/>
		<div class = "container_body">
			<p align="center">
				<br/>
				<br/>
				<h2>Listing des proprietaires</h2>
				<p class = "add">
					<a class="btn btn-success"href="ControleurProprietaire?action=ajouterProprietaire">Ajouter un adhérent</a>
				</p>
			</p>
			<table class="table table-hover">
				<tr>
					<th>Numero</th>
					<th>Nom</th>
					<th>Prénom</th>
					<th>Modifier</th>
					<th>Supprimer</th>		
				</tr>
				<c:forEach items="${mesProprietaires}" var="item">			
					<tr>
						<td>${item.idProprietaire}</td>
						<td>${item.nomProprietaire}</td>
						<td>${item.prenomProprietaire}</td>
		                <td><a class="btn btn-primary" href="ControleurProprietaire?action=modifierProprietaire&id=${item.idProprietaire}"><i class="fa fa-pencil-square-o"></i></a></td>
						<td><a class="btn btn-danger" href="ControleurProprietaire?action=supprimerProprietaire&id=${item.idProprietaire}"><i class="fa fa-trash"></i></a></td>						
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>