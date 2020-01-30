package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.YouTube.Search;
import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.Thumbnail;
import com.google.gson.Gson;
import objectDAO.BranoDAO;
import objectDAO.BranoPlaylistDAO;
import object.Brano;
import object.BranoPlaylist;
import database.DatabaseManager;


/**
 * Servlet implementation class BraniArtistiServlet
 */
@WebServlet("/MostraPlaylistServlet")
public class MostraPlaylistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final String PROPERTIES_FILENAME = "youtube.properties";

    private static final long NUMBER_OF_VIDEOS_RETURNED = 25;
    /**
     * Define a global instance of a Youtube object, which will be used
     * to make YouTube Data API requests.
     */
    private static YouTube youtube;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostraPlaylistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String paramUsername= (String) session.getAttribute("username");
		BranoPlaylistDAO t = DatabaseManager.getInstance().getDaoFactory().getBranoPlaylistDAO();
		BranoDAO x= DatabaseManager.getInstance().getDaoFactory().getBranoDAO();
		List<BranoPlaylist> temp = t.findAllByPlaylist(paramUsername);
		
		
		List<Brano> b=new ArrayList<Brano>();
		
		for(BranoPlaylist b1: temp)
		{
			Properties properties = new Properties();
	        try {
	            InputStream in = Search.class.getResourceAsStream("/" + PROPERTIES_FILENAME);
	            properties.load(in);

	        } catch (IOException e) {
	            System.err.println("There was an error reading " + PROPERTIES_FILENAME + ": " + e.getCause()
	                    + " : " + e.getMessage());
	            System.exit(1);
	        }

	        try {
	            // This object is used to make YouTube Data API requests. The last
	            // argument is required, but since we don't need anything
	            // initialized when the HttpRequest is initialized, we override
	            // the interface and provide a no-op function.
	            youtube = new YouTube.Builder(AuthenticationGoogleAPI.HTTP_TRANSPORT, AuthenticationGoogleAPI.JSON_FACTORY, new HttpRequestInitializer() {
	                public void initialize(HttpRequest request) throws IOException {
	                }
	            }).setApplicationName("youtube-cmdline-search-sample").build();

	            // Prompt the user to enter a query term.
	            //String queryTerm = getInputQuery();
	            String queryTerm = b1.getNome();
	            // Define the API request for retrieving search results.
	            YouTube.Search.List search = youtube.search().list("id,snippet");

	            // Set your developer key from the {{ Google Cloud Console }} for
	            // non-authenticated requests. See:
	            // {{ https://cloud.google.com/console }}
	            String apiKey = properties.getProperty("youtube.apikey");
	            search.setKey(apiKey);
	            search.setQ(queryTerm);

	            // Restrict the search results to only include videos. See:
	            // https://developers.google.com/youtube/v3/docs/search/list#type
	            search.setType("video");

	            // To increase efficiency, only retrieve the fields that the
	            // application uses.
	            search.setFields("items(id/kind,id/videoId,snippet/title,snippet/thumbnails/default/url)");
	            search.setMaxResults(NUMBER_OF_VIDEOS_RETURNED);

	            // Call the API and print results.
	            SearchListResponse searchResponse = search.execute();
	            List<SearchResult> searchResultList = searchResponse.getItems();
	            if (searchResultList != null) {
	                prettyPrint(searchResultList.iterator(), queryTerm);
	                b.add(convertElement(searchResultList.iterator()));
	            }
	        } catch (GoogleJsonResponseException e) {
	            System.err.println("There was a service error: " + e.getDetails().getCode() + " : "
	                    + e.getDetails().getMessage());
	        } catch (IOException e) {
	            System.err.println("There was an IO error: " + e.getCause() + " : " + e.getMessage());
	        } catch (Throwable th) {
	            th.printStackTrace();
	        }
		
		}
		request.setAttribute("songs", b);
		RequestDispatcher dispacher = request.getRequestDispatcher("playlist.jsp");
		dispacher.forward(request, response);

	}
	
	private static void prettyPrint(Iterator<SearchResult> iteratorSearchResults, String query) {

        System.out.println("\n=============================================================");
        System.out.println(
                "   First " + NUMBER_OF_VIDEOS_RETURNED + " videos for search on \"" + query + "\".");
        System.out.println("=============================================================\n");

        if (!iteratorSearchResults.hasNext()) {
            System.out.println(" There aren't any results for your query.");
        }

        while (iteratorSearchResults.hasNext()) {

            SearchResult singleVideo = iteratorSearchResults.next();
            ResourceId rId = singleVideo.getId();

            // Confirm that the result represents a video. Otherwise, the
            // item will not contain a video ID.
            if (rId.getKind().equals("youtube#video")) {
                Thumbnail thumbnail = singleVideo.getSnippet().getThumbnails().getDefault();

                System.out.println(" Video Id" + rId.getVideoId());
                System.out.println(" Title: " + singleVideo.getSnippet().getTitle());
                System.out.println(" Thumbnail: " + thumbnail.getUrl());
                System.out.println("\n-------------------------------------------------------------\n");
            }
        }
    }
    
    private static Brano convertElement(Iterator<SearchResult> iteratorSearchResults) {
    	List<Brano> brani = new ArrayList<Brano>();
    	
    	while (iteratorSearchResults.hasNext()) {

            SearchResult singleVideo = iteratorSearchResults.next();
            ResourceId rId = singleVideo.getId();

            // Confirm that the result represents a video. Otherwise, the
            // item will not contain a video ID.
            if (rId.getKind().equals("youtube#video")) {
            	String titolo = singleVideo.getSnippet().getTitle();
            	String id = rId.getVideoId();
            	Thumbnail thumb = singleVideo.getSnippet().getThumbnails().getDefault();
            	String thumbnail = thumb.getUrl();
            	Brano brano = new Brano(titolo, id, thumbnail);
            	return brano;
            }
        }
    	return null;
    }

}