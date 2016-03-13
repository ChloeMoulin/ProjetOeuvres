<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajouter un adhérent</title>
</head>
<SCRIPT language="Javascript" type="text/javascript"></script>
<script type="text/javascript" src="js/fonctControle.js"></script>


<body>
<jsp:include page="index.jsp"/>
	<H1> Ajout d'un adhérent </H1> 

	<FORM name='identification' method="post" action="ControleurAdherent?action=insererAdherent" onsubmit="return testAdherent()">
		<p align="left">
			<div class="form-inline">
				<FONT face="Arial" color="#004080"><BR>&nbsp;  &nbsp;  &nbsp;Nom de l'adherent : </FONT>
			    <INPUT class="form-control" type="text" name="txtnom" value=""  id ="nom" onchange="nomChanged()"/> <BR>
			    <p id = "alert_nom" style = "display:none;">Veuillez entrer un nom</p>
		    </div>
		    <div class="form-inline">
		        <FONT face="Arial" color="#004080"><BR>Prénom de l'adherent : </FONT>
		        <INPUT class="form-control" type="text" name="txtprenom"  id ="prenom" onchange="prenomChanged()"/> <BR>
		        <p id = "alert_prenom" style = "display:none;">Veuillez entrer un prénom</p>
		    </div>
		    <div class="form-inline">
		        <FONT face="Arial" color="#004080"><BR>&nbsp;  &nbsp;  &nbsp;Ville de l'adherent :</FONT>
		        <INPUT class="form-control" type="text" name="txtville" id ="ville" onchange=""/>
		        <p id = "alert_ville" style = "display:none;">Veuillez entrer une ville</p>
		    </div>
		        <FONT face="Arial" color="#004080">	<BR></FONT><BR>
		                  
		        <INPUT class="btn btn-success" type="submit" name="bt"  value="Ajouter" />
		        <FONT face="Arial" color="#004080"></FONT>
		        &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		      
		</p>
	</FORM>
<BR>
</body>
</html>