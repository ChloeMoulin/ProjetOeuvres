<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Affichage de toutes les réservations</title>
</head>
<body>
	<P>
		<A href="index.jsp"><FONT face="Arial" color="#004080">Retour
				Accueil</FONT></A>
	</P>
	<P align="center">
		<FONT face="Arial" size="5" color="#004080"><U> <STRONG>Listing&nbsp;des
					réservations </STRONG></U></FONT>
	</P>

	<TABLE BORDER="1">
		<CAPTION>Tableau des réservations</CAPTION>
		<TR>
			<TH>Oeuvre</TH>
			<TH>Adhérent</TH>
			<TH>Date</TH>
			<th>Statut</th>

		</tr>
		<c:forEach items="${mesReservations}" var="item">			
			<tr>
				<td>${item.oeuvrevente.getTitre()}</td>
				<td>${item.adherent.getPrenomAdherent()} ${item.adherent.getNomAdherent()}</td>
				<td>${item.date}</td>
                <td>${item.statut}</td>
			</tr>
		</c:forEach>
	</TABLE>
</body>
</html>