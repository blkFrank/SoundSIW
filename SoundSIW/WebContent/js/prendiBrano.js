function prendiBrano(titolo) {

	
console.log(titolo);
	
	var json = JSON.stringify(titolo);
	alert("Premi Ok per confermare!")
	$.ajax({
	        url: "AggiungiBranoAscoltato",
	        type: 'POST',
	        contentType: "application/json",
	        data: json ,   
	        success: function (data) {
	        	
	          
	        },
	        error: function() {
	            alert("errore")
	        }
	    });

	
}