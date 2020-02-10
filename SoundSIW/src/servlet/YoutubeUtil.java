package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.YouTube.Search;
import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.Thumbnail;

import object.Brano;

public class YoutubeUtil {
	private static YoutubeUtil istance = null;
	/**
     * Define a global variable that identifies the name of a file that
     * contains the developer's API key.
     */
    private static final String PROPERTIES_FILENAME = "youtube.properties";

    public static String getPropertiesFilename() {
		return PROPERTIES_FILENAME;
	}

	public static long getNumberOfVideosReturned() {
		return NUMBER_OF_VIDEOS_RETURNED;
	}

	private static final long NUMBER_OF_VIDEOS_RETURNED = 25;
    /**
     * Define a global instance of a Youtube object, which will be used
     * to make YouTube Data API requests.
     */
    
    private static Properties properties;
    
    private static YouTube youtube;
    /**
     * Initialize a YouTube object to search for videos on YouTube. Then
     * display the name and thumbnail image of each video in the result set.
     *
     * @param args command line args.
     */
    private static YouTube.Search.List search ;
    
    public static YoutubeUtil getIstance() {
        if(istance==null)
          istance = new YoutubeUtil();
        return istance;
    }
    
    private YoutubeUtil() {
    	properties = new Properties();
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
	        
	        // Define the API request for retrieving search results.	        
	        search = youtube.search().list("id,snippet");
	        
	        // Set your developer key from the {{ Google Cloud Console }} for
	        // non-authenticated requests. See:
	        // {{ https://cloud.google.com/console }}
	        String apiKey = properties.getProperty("youtube.apikey");
	        search.setKey(apiKey);

	        // Restrict the search results to only include videos. See:
	        // https://developers.google.com/youtube/v3/docs/search/list#type
	        search.setType("video");

	        // To increase efficiency, only retrieve the fields that the
	        // application uses.
	        search.setFields("items(id/kind,id/videoId,snippet/title,snippet/thumbnails/default/url)");
	        search.setMaxResults(NUMBER_OF_VIDEOS_RETURNED);
	    } catch (Throwable t) {
            t.printStackTrace();
        }
	
    }
	    
	public List<SearchResult> search(String s) {
		List<SearchResult> searchResultList;
		try {
	        // Prompt the user to enter a query term.
	        //String queryTerm = getInputQuery();
	        String queryTerm = s;
	        search.setQ(queryTerm);
		    // Call the API and print results.
		    SearchListResponse searchResponse = search.execute();
		    searchResultList = searchResponse.getItems();
		    return searchResultList;
		} catch (GoogleJsonResponseException e) {
            System.err.println("There was a service error: " + e.getDetails().getCode() + " : "
                    + e.getDetails().getMessage());
        } catch (IOException e) {
            System.err.println("There was an IO error: " + e.getCause() + " : " + e.getMessage());
        } catch (Throwable t) {
            t.printStackTrace();
        }
		return null;    
    }
	

	public static void prettyPrint(Iterator<SearchResult> iteratorSearchResults, String query) {

        System.out.println("\n=============================================================");
        System.out.println(
                "   First " + getNumberOfVideosReturned() + " videos for search on \"" + query + "\".");
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
    
    public static Brano convertElement(Iterator<SearchResult> iteratorSearchResults) {
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
    
    private static String getInputQuery() throws IOException {

        String inputQuery = "";

        System.out.print("Please enter a search term: ");
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        inputQuery = bReader.readLine();

        if (inputQuery.length() < 1) {
            // Use the string "YouTube Developers Live" as a default.
            inputQuery = "YouTube Developers Live";
        }
        return inputQuery;
    }
    
    
    public static List<Brano> convertType (Iterator<SearchResult> iteratorSearchResults) {
    	List<Brano> brani = new ArrayList<Brano>();
    	
    	while (iteratorSearchResults.hasNext()) {

            SearchResult singleVideo = iteratorSearchResults.next();
            ResourceId rId = singleVideo.getId();

            // Confirm that the result represents a video. Otherwise, the
            // item vorrwill not contain a video ID.
            if (rId.getKind().equals("youtube#video")) {
            	String titolo = singleVideo.getSnippet().getTitle();
            	String id = rId.getVideoId();
            	Thumbnail thumb = singleVideo.getSnippet().getThumbnails().getDefault();
            	String thumbnail = thumb.getUrl();
            	Brano brano = new Brano(titolo, id, thumbnail);
            	brani.add(brano);
            }
        }
    	
    	return brani;
    }
    /*
    public static List<Ricerca> convertToSearch (Iterator<SearchResult> iteratorSearchResults) {
    	List<Ricerca> brani = new ArrayList<Ricerca>();
    	
    	while (iteratorSearchResults.hasNext()) {

            SearchResult singleVideo = iteratorSearchResults.next();
            ResourceId rId = singleVideo.getId();
            // Confirm that the result represents a video. Otherwise, the
            // item vorrwill not contain a video ID.
            if (rId.getKind().equals("youtube#video")) {
            	String titolo = singleVideo.getSnippet().getTitle();
            	brani.add(titolo);
            }
        }
    	
    	return brani;
    }
     */
}
