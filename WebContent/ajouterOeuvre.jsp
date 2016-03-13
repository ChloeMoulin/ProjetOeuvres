<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Ajouter une Oeuvre</title>

		
	</head>
		<SCRIPT language="Javascript" type="text/javascript"></script>
		<script type="text/javascript" src="js/fonctControle.js"></script>
		<script type="text/javascript" src="js/jquery-2.0.0.js"></script>

	<body>
		<h1> Ajout d'une oeuvre </h1> 
		
		<div align="center">
			<p class="oeuvreType">
				<select id="selectType" name="oeuvreType">
					<option value="vente" selected> Oeuvre Vente</option>
					<option value ="pret">Oeuvre Prêt</option>
				</select>
			</p>
			<form style = "display:none;" id="form_vente" name='form_vente' method="post" action="Controleur?action=insererOeuvreVente" onsubmit="return testOeuvreVente()">
			     <p align="left">    
					<br/>&nbsp;  &nbsp;  &nbsp; Titre de l'oeuvre : 
				    <input type="text" name="txtTitre" value=""  id ="titre" onchange="titreChanged()">
					<p id = "alert_titre" style = "display:none;">Veuillez entrer un titre</p>
					
					<br/>&nbsp;  &nbsp;  &nbsp; Prix de l'oeuvre :
					<input type="number" name="numberPrix" value = "" id="prix" onchange="prixChanged()">
					<p id = "alert_prix" style = "display:none;">Veuillez entrer un prix</p>
					
					<br/>&nbsp;  &nbsp;  &nbsp; Proprietaire :
					<select name ="proprietaire" id ="proprietaire" onchange="proprietaireChanged()">
						<c:forEach items="${mesProprietaires}" var="item">
							<option value = "${item.idProprietaire }">${item.prenomProprietaire } ${item.nomProprietaire }</option>
						</c:forEach>
					</select>		
					<p id = "alert_proprietaire" style = "display:none;">Veuillez sélectionner un proprietaire</p>
					
			          
			        <input type="submit" name="bt"  value="Ajouter" >
		      
				</p>
			</form>
			<form  style = "display:none;" id="form_pret" name='form_pret' method="post" action="Controleur?action=insererOeuvrePret" onsubmit="return testOeuvrePret()">
			     <p align="left">    
					<br/>&nbsp;  &nbsp;  &nbsp; Titre de l'oeuvre : 
				    <input type="text" name="txtTitre" value=""  id ="titre_pret" onchange="titrePretChanged()">
				    <p id = "alert_titre_pret" style = "display:none;">Veuillez entrer un titre</p>
				    
				     					<br/>&nbsp;  &nbsp;  &nbsp; Proprietaire :
					<select name = "proprietaire">
						<c:forEach items="${mesProprietaires}" var="item">
							<option value = "${item.idProprietaire }">${item.prenomProprietaire } ${item.nomProprietaire }</option>
						</c:forEach>
					</select>	
					<p id = "alert_proprietaire" style = "display:none;">Veuillez sélectionner un proprietaire</p>
					
			        <input type="submit" name="bt"  value="Ajouter" >
		      
				</p>
			</form>
		</div>
		<script type="text/javascript">
			$(document).ready(function() {
				var type = $("#selectType").val();
				if (type == "vente") {
					$("#form_vente").show();
				} else if (type == "pret") {
					$("#form_pret").show();
				}
				
				$("#selectType").on('change',function() {
					var type = $(this).val();
					if (type == "vente") {
						$("#form_pret").hide();
						$("#form_vente").show();
					} else if (type == "pret") {
						$("#form_vente").hide();
						$("#form_pret").show();
					}
				});
			});
			
		</script>
	</body>
</html>