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
	          caricaPlayer(titolo,data);
	        },
	        error: function() {
	            alert("Errore! Aggiorna la pagina!");
	        }
	    });
	
	//assegno a itemPlayer gli attributi di item
	
	
	
}


function caricaPlayer(titolo, data){
	console.log(titolo);
	console.log(data);
	document.getElementById("containerTrack").style.display="block";
	document.getElementById("songName").innerText = titolo;
	document.getElementById("srcAudio").src = data;
	document.getElementById("song").load();
	
}

	
	
