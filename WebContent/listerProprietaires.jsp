<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Affichage de tous les proprietaires</title>
</head>
<body>
<jsp:include page="index.jsp"/>
	<P>
		<A href="index.jsp"><FONT face="Arial" color="#004080">Retour
				Accueil</FONT></A>
	</P>
	<div class="col-md-6">
		<P align="center">
			<h1>Listing des proprietaires</h1>
		</P>
		<TABLE class="table table-hover">
			<TR>
				<TH>Numero</TH>
				<TH>Nom</TH>
				<TH>Prénom</TH>
				<th>Modifier</th>
				<th>Supprimer</th>
	
			</TR>
			<c:forEach items="${mesProprietaires}" var="item">			
				<tr>
					<td>${item.idProprietaire}</td>
					<td>${item.nomProprietaire}</td>
					<td>${item.prenomProprietaire}</td>
	                <td><a class="btn btn-primary" href="ControleurProprietaire?action=modifierProprietaire&id=${item.idProprietaire}"><i class="fa fa-pencil-square-o"></i></a></td>
					<td><a class="btn btn-danger" href="ControleurProprietaire?action=supprimerProprietaire&id=${item.idProprietaire}"><i class="fa fa-trash"></i></a></td>
					
				</tr>
			</c:forEach>
		</TABLE>
	</div>
</body>
</html>