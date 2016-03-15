function displayMenuOeuvre() {
	if ($("#dropdown_oeuvre_menu").is(":visible") == false) {
		$("#dropdown_oeuvre_menu").fadeIn();
	} else {
		$("#dropdown_oeuvre_menu").fadeOut();
	}
}

function displayMenuListeOeuvre() {
	if ($("#dropdown_liste_oeuvre_menu").is(":visible") == false) {
		$("#dropdown_liste_oeuvre_menu").fadeIn();
	} else {
		$("#dropdown_liste_oeuvre_menu").fadeOut();
	}
}

$(document).ready(function() {
	var param = location.search.split("?action=")[1];
	var bool_pret = (param == "listerOeuvresPret");
	var bool_vente = (param == "listerOeuvresVente");
	if (bool_pret || bool_vente) {
		$("#dropdown_liste_oeuvre_menu").fadeIn();
	}
	
	$(".datepicker").datepicker();
});