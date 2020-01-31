									package servlet;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.YouTube.Search;
import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.Thumbnail;

import object.Brano;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

@WebServlet("/YoutubeSearchServlet")

public class YoutubeSearchServlet extends HttpServlet {
	
	private static YoutubeUtil youtubeUtil;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doGet(request, response);
	}
    
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		youtubeUtil = YoutubeUtil.getIstance();
            String queryTerm = request.getParameter("search");
            List<SearchResult> searchResultList = youtubeUtil.search(queryTerm);
             if (searchResultList != null) {
            	youtubeUtil.prettyPrint(searchResultList.iterator(), queryTerm);
                request.setAttribute("songs", youtubeUtil.convertType(searchResultList.iterator()));
            }
       
		RequestDispatcher dispacher = request.getRequestDispatcher("albums-store.jsp");
		dispacher.forward(request, response);
    }

   
   
}