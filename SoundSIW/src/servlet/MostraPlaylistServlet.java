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
	
	private static YoutubeUtil youtubeUtil;
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
			try {
				youtubeUtil = YoutubeUtil.getIstance();
	            String queryTerm = b1.getNome();
	            // Define the API request for retrieving search results.
	            List<SearchResult> searchResultList = youtubeUtil.search(queryTerm);
	          
	            if (searchResultList != null) {
	                youtubeUtil.prettyPrint(searchResultList.iterator(), queryTerm);
	                b.add(youtubeUtil.convertElement(searchResultList.iterator()));
	            }
	        } catch (Throwable th) {
	            th.printStackTrace();
	        }
		
		}
		request.setAttribute("songs", b);
		RequestDispatcher dispacher = request.getRequestDispatcher("playlist.jsp");
		dispacher.forward(request, response);

	}
	

}