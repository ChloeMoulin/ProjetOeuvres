<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Reserver Oeuvre Vente</title>
		

	</head>
	<body>
			<script type="text/javascript" src="js/fonctControle.js"></script>
		<script type="text/javascript" src="js/jquery-2.0.0.js"></script>
   		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.4.5/jquery.datetimepicker.min.js"></script>
    	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.2/js/select2.min.js"></script>
    	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.2/js/i18n/fr.js"></script>
	
		<script type="text/javascript">
        $(function() {
            // Datetime picker
            $(".datepicker").datetimepicker({
                timepicker: false,
                format: "d/m/Y",
                dayOfWeekStart: 1,
                startDate: new Date(),
                minDate: 0
            });
            </script>
		<jsp:include page="index.jsp"/>
		<div class = "container_body">
			<p align="center">
				<br/>
				<br/>
				<h2> Réserver une oeuvre </h2> 
			</p>		
			<div class="container drop-shadow">
				<div class="container">
					<br/>
					<form id="form_reservation" name="form_reservation" method="post" action="ControleurReservation?action=validerReserverOeuvreVente&id=${oeuvre.id}" onsubmit="return teste()">
						<fieldset class="form-group" >
							<label>Titre de l'oeuvre : ${oeuvre.titre}</label><br/>
				   			<label>Prix de l'oeuvre : ${oeuvre.prixOeuvrevente}</label><br/>
				   			
				   			<br/>
				   			<label for="dateReservation">Date Réservation :</label>
				   			<input class="form-control" type = "text" id = "dateReservation" class="datepicker" name = "dateReservation"/><br/>
	
				
				   			<label for = "adherent">Acheteur :</label>
				   			<select class="form-control" name="adherent">
					   			<c:forEach items = "${adherents}" var="item">
									<option value = "${item.idAdherent }">${item.prenomAdherent } ${item.nomAdherent }</option>
								</c:forEach>
				   			</select>
				   			
				   			<br/>	
				   			<input class="btn btn-success" type = "submit" name = "bt"  value = "Valider" />
				   		</fieldset>
				   	</form>
			   	</div>
		   	</div> 
	   	</div>
	</body>
</html>