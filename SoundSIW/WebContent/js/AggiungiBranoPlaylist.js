function AggiungiBranoPlaylist(titolo, id) {

	//converto l'id del brano in una stringa json
	
	console.log(id);
	
	var json = JSON.stringify(id);

	//avvia servlet di download 
	
	$.ajax({
	        url: "AggiungiBranoServlet",
	        type: 'POST',
	        contentType: "application/json",
	        data: json ,   
	        success: function (data) {
	          
	        },
	        error: function() {
	            alert("Errore! Riprova ad aggiungere il brano!");
	        }
	    });

	
}