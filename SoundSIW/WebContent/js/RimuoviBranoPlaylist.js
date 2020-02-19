function RimuoviBranoPlaylist(titolo, id) {

	//converto l'id del brano in una stringa json
	
	console.log(id);
	
	var json = JSON.stringify(id);

	//avvia servlet di download 

	$.ajax({
	        url: "RimuoviBranoServlet",
	        type: 'POST',
	        contentType: "application/json",
	        data: json ,   
	        success: function (data) {
	          
	        },
	        error: function() {
	            alert("Errore! Prova di nuovo!");
	        }
	    });

	
}