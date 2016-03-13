var script = document.createElement('script');
script.src = "js/jquery-2.0.0.js";
script.type = 'text/javascript';
document.getElementsByTagName('head')[0].appendChild(script);

function nomChanged() {
	if($("#nom").val() != "") {
		$("#alert_nom").fadeOut();
	}
}

function prenomChanged () {
	if($("#prenom").val() != "") {
		$("#alert_prenom").fadeOut();
	}
}

function villeChanged() {
	if($("#ville").val() != "") {
		$("#alert_ville").fadeOut();
	}
}

function testAdherent()
{  ok = true;
   if ($("#nom").val() == "") {
	   ok = false;
	   $("#alert_nom").fadeIn();
   } else {
	   $("#alert_nom").fadeOut();   
   }
   if ($("#prenom").val() == "") {
	   ok = false;
	   $("#alert_prenom").fadeIn();
   } else {
	   $("#alert_prenom").fadeOut();
   }
   if ($("#ville").val() == "") {
	   ok = false;
	   $("#alert_ville").fadeIn();
   } else {
	   $("#alert_ville").fadeOut();
   }
   return ok;
}

function titreChanged() {
	if($("#titre").val() != "") {
		$("#alert_titre").fadeOut();
	}
}

function titrePretChanged(){
	if($("#titre_pret").val() != "") {
		$("#alert_titre_pret").fadeOut();
	}
}
function prixChanged () {
	if($("#prix").val().length > 0) {
		$("#alert_prix").fadeOut();
	}
}

function proprietaireChanged() {
	if($("#proprietaire").val() != "") {
		$("#alert_proprietaire").fadeOut();
	}
}


function testOeuvrePret() {
	if($("#titre_pret").val() == "") {
		$("#alert_titre_pret").fadeIn();
		return false;
	}
	$("#alert_titre_pret").fadeOut();
	return true;
}
function testOeuvreVente() {
	ok = true;
	if($("#titre").val() == "") {
		ok = false;
		$("#alert_titre").fadeIn();
	} else {
		$("#alert_titre").fadeOut();
	}
	if ($("#prix").val().length== 0) {
		ok = false;
		$("#alert_prix").fadeIn();		
	} else {
		$("#alert_prix").fadeOut();
	}
	if ($("#proprietaire").val()== "") {
		ok = false;
		$("#alert_proprietaire").fadeIn();		
	} else {
		$("#alert_proprietaire").fadeOut();
	}
	return ok;
}