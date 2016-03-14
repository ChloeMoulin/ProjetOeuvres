<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="refresh" content="0;URL=javascript:fermer();">

		<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" />		
		<link href="css/bootstrap.min.css" rel="stylesheet" />
		<link href="css/index.css" rel="stylesheet"/>
		<link href="css/simple-sidebar.css" rel = "stylesheet"/>
		
		<script type="text/javascript" src="js/jquery-2.0.0.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script type="text/javascript" src="js/index.js"></script>
		
		<title>Expo : Médiathèque De POLYTECH</title>
	</head>
	<body>
	
		<div class = "title" style="height:15%;border-bottom:1px solid #5983AA;margin-top:-3%;">

			<h1 align="center" style="padding-top:3%">
				Médiathèque de POLYTECH
			</h1>
						<p align="left" style="margin: -4% 3px 10px">
				<font color="#d0d0d0" face="Arial" size="4">Gestion de</font>
				<br/>
				<font color="#d0d0d0" face="Arial" size="4">l'exposition 2016</font>
			</p>
		</div>
		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
				<li class="sidebar-brand">
					<a href="index.jsp">Retour Accueil</a>
				</li>
				<li><a href="ControleurAdherent?action=ajouterAdherent"><font
						face="Arial">Ajout Adhérent</font></a></li>
				<li class="dropdown_index" onclick="displayMenuOeuvre()">
					<a>Ajouter une Oeuvre</a>
					<ul class ="dropdown_menu" id="dropdown_oeuvre_menu" style="display:none;">
						<li class="no_puce"><a href = "ControleurOeuvrePret?action=ajouterOeuvre">Ajouter une Oeuvre à prêter</a>
						<li class="no_puce"><a href = "ControleurOeuvreVente?action=ajouterOeuvre">Ajouter une Oeuvre à vendre</a>
					</ul>
				<li><a href="ControleurAdherent?action=listerAdherent"><font
						face="Arial">Listing des adhérents</font></a><font face="Arial"> </font></li>
						
				<li class="dropdown_index" onclick="displayMenuListeOeuvre()">	
					<a>Listing des oeuvres</a>			
					<ul class ="dropdown_menu" id="dropdown_liste_oeuvre_menu" style="display:none;">
						<li class="no_puce"><a href = "ControleurOeuvreVente?action=listerOeuvresVente">Listing des Oeuvres à vendre</a></li>
						<li class="no_puce"><a href = "ControleurOeuvrePret?action=listerOeuvresPret">Listing des Oeuvres à prêter</a></li>
					</ul>
				</li>
				<li><a href = "ControleurReservation?action=listerReservations">Listing des Réservations</a></li>
				<li><a href = "ControleurProprietaire?action=listerProprietaires">Listing des Proprietaires</a></li>
				<li><a href = "ControleurProprietaire?action=ajouterProprietaire">Ajouter Proprietaire</a></li>
			</ul>
		</div>
	</body>
</html>