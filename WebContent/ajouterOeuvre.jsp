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
	<jsp:include page="index.jsp"/>
		<h1> Ajout d'une oeuvre </h1> 
		
		<div class="form-group">
			<form role="form">
				<div class="form-inline">
					<p class="oeuvreType">
						<select class="form-control" id="selectType" name="oeuvreType">
							<option value="vente" selected> Oeuvre Vente</option>
							<option value ="pret">Oeuvre Prêt</option>
						</select>
					</p>
				</div>
			</form>
			<form style = "display:none;" id="form_vente" name='form_vente' method="post" action="ControleurOeuvreVente?action=insererOeuvreVente" onsubmit="return testOeuvreVente()">
			    <div class="form-inline">    
				<br/>&nbsp;  &nbsp;  &nbsp; Titre de l'oeuvre : 
				   	<input class="form-control" type="text" name="txtTitre" value=""  id ="titre" onchange="titreChanged()"/>
   					<p id = "alert_titre" style = "display:none;">Veuillez entrer un titre</p>
				</div>
				<div class="form-inline">
					<br/>&nbsp;  &nbsp;  &nbsp; Prix de l'oeuvre : 
					<input class="form-control" type="number" name="numberPrix" value = "" id="prix" onchange="prixChanged()"/>
					<p id = "alert_prix" style = "display:none;">Veuillez entrer un prix</p>
				</div>
				<div class="form-inline">
					<br/>&nbsp;  &nbsp;  &nbsp; Proprietaire :
					<select class="form-control" name = "proprietaire" onchange="proprietaireChanged()">
						<c:forEach items="${mesProprietaires}" var="item">
							<option value = "${item.idProprietaire }">${item.prenomProprietaire } ${item.nomProprietaire }</option>
						</c:forEach>
					</select>
					<p id = "alert_proprietaire" style = "display:none;">Veuillez sélectionner un proprietaire</p>
				</div>		
				<br/>			          
		        <input class="btn btn-success" type="submit" name="bt"  value="Ajouter" >	      
			</form>
			<form  style = "display:none;" id="form_pret" name='form_pret' method="post" action="ControleurPret?action=insererOeuvrePret" onsubmit="return testOeuvrePret()">
			     <div class="form-inline">   
					<br/>&nbsp;  &nbsp;  &nbsp; Titre de l'oeuvre : 
				    <input class="form-control" type="text" name="txtTitre" value="" id ="titre" onchange="titrePretChanged()">
   				    <p id = "alert_titre_pret" style = "display:none;">Veuillez entrer un titre</p>
				 </div>
				 <div class="form-inline">
				     <br/>&nbsp;  &nbsp;  &nbsp; Proprietaire :
					<select class="form-control" name = "proprietaire">
						<c:forEach items="${mesProprietaires}" var="item">
							<option value = "${item.idProprietaire }">${item.prenomProprietaire } ${item.nomProprietaire }</option>
						</c:forEach>
					</select>
					<p id = "alert_proprietaire" style = "display:none;">Veuillez sélectionner un proprietaire</p>
					</div>	
					<br/>
			        <input class="btn btn-success" type="submit" name="bt"  value="Ajouter" >
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