<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="refresh" content="0;URL=javascript:fermer();">
<!-- Latest compiled and minified CSS -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-2.0.0.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/index.css" rel="stylesheet"/>
<script type="text/javascript" src="js/bootstrap.js"></script>
<title>Expo : Médiathèque De POLYTECH</title>
</head>


<script language="JavaScript">
	function fermer() {

	}
</script>

<body>
	<p align="center"></p>
	<p align="center">
		<font face="Arial" size="4"><u>Médiathèque de POLYTECH </u></font>
	</p>
	<p align="center">
		<font color="#004080" face="Arial" size="4">Gestion de
			l'exposition 2016</font>
	</p>
	<p align="left">
	</p>
	<div class="col-md-2" id="sidebar">
		<div class="sidebar-nav">
			<nav class="navbar navbar-default">
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" align="center">
					<ul class="nav nav-pills">
						<li><a href="ControleurAdherent?action=ajouterAdherent"><font
								face="Arial">Ajout Adhérent</font></a></li>
						<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" data-target="#" role="button" aria-haspopup="true" aria-expanded="false">Ajouter une Oeuvre <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href = "ControleurOeuvrePret?action=ajouterOeuvre">Ajouter une Oeuvre à prêter</a>
								<li><a href = "ControleurOeuvreVente?action=ajouterOeuvre">Ajouter une Oeuvre à vendre</a>
							</ul>
						<li><a href="ControleurAdherent?action=listerAdherent"><font
								face="Arial">Listing des adhérents</font></a><font face="Arial"> </font></li>
						<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" data-target="#" role="button" aria-haspopup="true" aria-expanded="false">Listing des Oeuvres <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href = "ControleurOeuvreVente?action=listerOeuvresVente">Listing des Oeuvres à vendre</a></li>
								<li><a href = "ControleurOeuvrePret?action=listerOeuvresPret">Listing des Oeuvres à prêter</a></li>
							</ul>
						</li>
						<li><a href = "ControleurReservation?action=listerReservations">Listing des Réservations</a></li>
						<li><a href = "ControleurProprietaire?action=listerProprietaires">Listing des Proprietaires</a></li>
						<li><a href = "ControleurProprietaire?action=ajouterProprietaire">Ajouter Proprietaire</a></li>
					</ul>
				</div>
			</nav>
		</div>
	</div>
</body>
</html>