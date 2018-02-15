$(document).ready(function(){
	reset();
})
// when any modal is closing
$('.modal').on('hide.bs.modal', function (e) {
	
	if(e.target.id == "contattaci"){
		reset();
	}
})

function reset(){
	$("input[name=nome]").val('');
	$("input[name=cognome]").val('');
	$("input[name=email]").val('');
	$("#textarea").val('');
}

if(typeof window.history.pushState == 'function') {
    window.history.pushState({}, "Hide", "http://localhost:8080/PrenotazioneVisitaMedica/restituisciSegnalazioni");
}