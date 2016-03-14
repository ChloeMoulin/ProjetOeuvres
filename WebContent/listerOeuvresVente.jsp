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
		<jsp:include page="index.jsp" />
		<div class = "container_body">
			<div class="row">
				<div class="col-md-6">
					<P align="center">
						<h1>Listing des oeuvres à vendre </h1>
					</P>
					<TABLE class="table table-hover">
						<TR>
							<TH>Titre</TH>
							<TH>Etat</TH>
							<TH>Prix</TH>
							<th>Propriétaire</th>
							<th>Modifier</th>
							<th>Réserver</th>
							<th>Supprimer</th>
				
						</TR>
						<c:forEach items="${mesOeuvres}" var="item">			
							<tr>
								<td>${item.titre}</td>
								<td>${item.etatOeuvrevente}</td>
								<td>${item.prixOeuvrevente}</td>
				                <td>${item.proprietaire.getPrenomProprietaire()} ${item.proprietaire.getNomProprietaire()}</td>
				                <td><a class="btn btn-primary" href="ControleurOeuvreVente?action=modifierOeuvreVente&id=${item.id}"><i class="fa fa-pencil-square-o"></i></a></td>
				                <c:choose>
				                	<c:when test="${item.etatOeuvrevente == 'R' || item.etatOeuvrevente == 'r'}">
				                		<td>Indisponible</td>
			                		</c:when>
			                		<c:otherwise>
			   			                <td><a class="btn btn-success" href="ControleurReservation?action=reserverOeuvreVente&id=${item.id}"><i class="fa fa-check"></i></a></td>
			                		</c:otherwise>
				                </c:choose>
							   	<td><a class="btn btn-danger" href="ControleurOeuvreVente?action=supprimerOeuvreVente&id=${item.id}"><i class="fa fa-trash"></i></a></td>
							</tr>
						</c:forEach>
					</TABLE>
				</div>
			</div>
			<div class = "add">
				<a class="btn btn-success" href="ControleurOeuvreVente?action=ajouterOeuvre">Ajouter une oeuvre à vendre</a>
			</div>
		</div>
	</body>
</html>