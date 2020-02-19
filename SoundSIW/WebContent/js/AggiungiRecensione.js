function AggiungiRecensione(id,stella) {

	console.log(id);
	console.log(stella);

	var valutation = [id, stella];
	var json = JSON.stringify(valutation);

	$.ajax({
	        url: "AggiungiRecensioneServlet",
	        type: 'POST',
	        contentType: "application/json",
	        data: json ,   
	        success: function (data) {
	        	console.log(data);
	        	document.getElementById("review").value=data;
	        },
	        error: function() {
	        	alert("Errore! Riprova ad aggiungere la recensione!");
	        }
	    });
	
}
