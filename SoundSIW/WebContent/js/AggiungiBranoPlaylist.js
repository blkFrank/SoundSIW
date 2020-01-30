function AggiungiBranoPlaylist(titolo, id) {

	//converto l'id del brano in una stringa json
	
	console.log(id);
	
	var json = JSON.stringify(id);

	//avvia servlet di download 
	
	alert("Premi Ok per confermare!")
	$.ajax({
	        url: "AggiungiBranoServlet",
	        type: 'POST',
	        contentType: "application/json",
	        data: json ,   
	        success: function (data) {
	          alert("Brano aggiunto alla Playlist!");
	          
	        },
	        error: function() {
	            alert("Errore! Aggiorna la pagina!");
	        }
	    });

	
}