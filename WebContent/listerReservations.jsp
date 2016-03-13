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
	<P>
		<A href="index.jsp"><FONT face="Arial" color="#004080">Retour
				Accueil</FONT></A>
	</P>
	<P align="center">
		<FONT face="Arial" size="5" color="#004080"><U> <STRONG>Listing&nbsp;des
					réservations </STRONG></U></FONT>
	</P>

	<div class="col-md-6">
		<TABLE class="table table-hover">
			<CAPTION>Tableau des réservations</CAPTION>
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
</body>
</html>