function prendiBrano(titolo) {

	
	console.log(titolo);
	
	var json = JSON.stringify(titolo);
	$.ajax({
	        url: "AggiungiBranoAscoltato",
	        type: 'POST',
	        contentType: "application/json",
	        data: json ,   
	        success: function (data) {
	        	
	        },
	        error: function() {
	           
	        }
	    });

	
}