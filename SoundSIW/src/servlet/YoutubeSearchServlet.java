package servlet;


import com.google.api.services.youtube.model.SearchResult;

import database.DatabaseManager;
import object.Brano;
import object.BranoPlaylist;
import object.Recensione;
import objectDAO.BranoDAO;
import objectDAO.BranoPlaylistDAO;
import objectDAO.RecensioneDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/YoutubeSearchServlet")

public class YoutubeSearchServlet extends HttpServlet {
	
	private static YoutubeUtil youtubeUtil;
    
	private static List<Recensione> getRecensione(List<Brano> songResult, RecensioneDAO reviewDao){
		List<Recensione> results = new ArrayList <Recensione>();
		for (int i=0; i<songResult.size(); i++) {
			Recensione review = reviewDao.findByPrimaryKey(songResult.get(i).getId()); 
			if (review != null) {
				results.add(review);
			} else {
				results.add(new Recensione());
			}
			
		}
		
		return results;
	}
	
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doGet(request, response);
	}
    
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		youtubeUtil = YoutubeUtil.getIstance();
            String queryTerm = request.getParameter("search");
            List<SearchResult> searchResultList = youtubeUtil.search(queryTerm);
    		RecensioneDAO reviewDao = DatabaseManager.getInstance().getDaoFactory().getRecensioneDAO();
            List<Brano> songResult;
            List<Recensione> reviewResult;
            if (searchResultList != null) {
            	songResult = youtubeUtil.convertType(searchResultList.iterator());
            	reviewResult = getRecensione(songResult, reviewDao);
            	youtubeUtil.prettyPrint(searchResultList.iterator(), queryTerm);
            	request.setAttribute("songs", songResult);
            	request.setAttribute("reviews", reviewResult);
            }
            
		RequestDispatcher dispacher = request.getRequestDispatcher("albums-store.jsp");
		dispacher.forward(request, response);
    }

   
   
}