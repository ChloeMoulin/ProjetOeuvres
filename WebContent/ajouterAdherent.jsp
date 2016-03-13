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
	<H1> Ajout d'un adhérent </H1> 

<DIV align="center">
<FORM  name='identification' method="post" action="Controleur?action=insererAdherent" onsubmit="return testAdherent()">
     <P align="left"><FONT face="Arial" color="#004080"></FONT>     
		<FONT face="Arial" color="#004080"><BR>&nbsp;  &nbsp;  &nbsp; Nom de l'adherent : </FONT>
	    <INPUT type="text" name="txtnom" value=""  id ="nom" onchange="nomChanged()"> <BR>
	    <p id = "alert_nom" style = "display:none;">Veuillez entrer un nom</p>
        <FONT face="Arial" color="#004080">
		<BR>Prenom de l'adherent : </FONT>
        <INPUT type="text" name="txtprenom"  id ="prenom" onchange="prenomChanged()" > <BR>
        <p id = "alert_prenom" style = "display:none;">Veuillez entrer un prénom</p>
        
        <FONT face="Arial" color="#004080"> <BR>&nbsp;  &nbsp;  &nbsp; Ville de l'adherent :</FONT>
        <INPUT type="text" name="txtville" id ="ville" onchange="villeChanged()">
        <p id = "alert_ville" style = "display:none;">Veuillez entrer une ville</p>
        <FONT face="Arial" color="#004080">	<BR></FONT><BR>
        
          <!-- Boutons Ajouter -->
          
        <INPUT type="submit" name="bt"  value="Ajouter" >
        <FONT face="Arial" color="#004080"></FONT>
        &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      
</P></FORM>
</DIV>
<BR>
</body>
</html>