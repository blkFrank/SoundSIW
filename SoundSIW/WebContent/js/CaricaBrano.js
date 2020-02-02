function CaricaBrano(titolo, id) {

	//converto l'id del brano in una stringa json
	
	console.log(id);
	
	var json = JSON.stringify(id);

	//avvia servlet di download 
	
	document.getElementById("loading").style.display="block";
	
	$.ajax({
	        url: "YoutubeAudioDownloadServlet",
	        type: 'POST',
	        contentType: "application/json",
	        data: json ,   
	        success: function (data) {
	          document.getElementById("loading").style.display="none";
	          caricaPlayer(titolo,id);
	        },
	        error: function() {
	            alert("Errore! Aggiorna la pagina!");
	        }
	    });
	
	//assegno a itemPlayer gli attributi di item
	
	
	
}


function caricaPlayer(titolo, id){
	console.log(titolo);
	console.log(id);
	string = '<div class = "container-fluid" style="position:fixed; bottom:40px; z-index:3;">';
	string += '<div class="song-play-area">';
	string += '<p>';
	string += titolo;
	string += '</p> ';
	string += ' <audio preload="auto" controls autoplay>';
	string += '<source src="http://localhost:8081/'+ id + '.mp3">';
	string += '</audio>';
	string += '</div></div>';
	
	$("#player").html(string);
}