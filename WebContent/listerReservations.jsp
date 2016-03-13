<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Affichage de toutes les réservations</title>
</head>
<body>
<jsp:include page="index.jsp"/>
	<div id="wrap">
		<div id="main" class="clearfix">
			<div class="col-md-6">
				<P align="center">
					<h1>Listing des réservations</h1>
				</P>
				<TABLE class="table table-hover">
					<TR>
						<TH>Oeuvre</TH>
						<TH>Adhérent</TH>
						<TH>Date</TH>
						<th>Réservation</th>
						<th>Supprimer</th>
					</tr>
					<c:forEach items="${mesReservations}" var="item">			
						<tr>
							<td>${item.oeuvrevente.getTitre()}</td>
							<td>${item.adherent.getPrenomAdherent()} ${item.adherent.getNomAdherent()}</td>
							<td><fmt:formatDate value="${item.date}" pattern="dd/MM/yyyy" /></td>
			                <c:choose>
			                	<c:when test="${item.statut == 'reservee'}">
			                		<td><a class="btn btn-success" href="ControleurReservation?action=confirmerReservation&id=${item.oeuvrevente.getId()}">Confirmer</a></td>
			                	</c:when>
			                	<c:otherwise>
			                		<td><i class="fa fa-check"></i></td>
			                	</c:otherwise>
			                </c:choose>
			               	<td><a class="btn btn-danger" href="ControleurReservation?action=supprimerReservation&id=${item.oeuvrevente.getId()}"><i class="fa fa-trash"></i></a></td>
						</tr>
					</c:forEach>
				</TABLE>
			</div>
		</div>
	</div>
	<div id="retour">
		<a href="index.jsp">Accueil</a>
	</div>
</body>
</html>