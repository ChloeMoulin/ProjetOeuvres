<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajouter un proprietaire</title>
</head>
<SCRIPT language="Javascript" type="text/javascript"></script>
<script type="text/javascript" src="js/foncControle.js"></script>


<body>
	<jsp:include page="index.jsp"/> 
	<div class = "container_body">
		<h1> Ajout d'un proprietaire</h1>
		<DIV class="form-group">
			<FORM  name='identification' method="post" action="ControleurProprietaire?action=insererProprietaire" onsubmit="return teste()">
			     <P align="left">
				     <div class="form-inline">
			     		<FONT face="Arial" color="#004080"></FONT>  
						<FONT face="Arial" color="#004080"><BR/>Nom du proprietaire : </FONT>
					    <INPUT class="form-control" type="text" name="txtnom" value=""  id ="nom" onchange="nomChanged()"/> <BR/>
				   	</div>
				   	<div class="form-inline">
				        <FONT face="Arial" color="#004080">
						<BR>Prénom du proprietaire : </FONT>
				        <INPUT class="form-control" type="text" name="txtprenom"  id ="prenom" onchange="prenomChanged()"/> <BR>
			        </div>
			        <br/>
			          <!-- Boutons Ajouter -->
			          
			        <INPUT class="btn btn-success" type="submit" name="bt"  value="Ajouter" />
			        <FONT face="Arial" color="#004080"></FONT>
			        &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
				</P>
			</FORM>
		</DIV>
	</div>
</body>
</html>