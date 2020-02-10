function SearchProxy() {
	
	$(document).ready(function(){
		
			var search = $('#search').val();
			$.ajax({
				url:'YoutubeSearchProxyServlet',
				type: 'GET',
				data: {search: search}, 
				success: function(result){
					$('#search').html(result);
				}
			});
		});		
	
}