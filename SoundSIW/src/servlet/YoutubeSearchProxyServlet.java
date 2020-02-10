package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.api.services.youtube.model.SearchResult;

import database.DAOFactory;
import object.News;
import objectDAO.NewsDAO;
import objectDAO.RicercaDAO;

/**
 * Servlet implementation class YoutubeSearchProxyServlet
 */
@WebServlet("/YoutubeSearchProxyServlet")
public class YoutubeSearchProxyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YoutubeSearchProxyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private static YoutubeUtil youtubeUtil;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		youtubeUtil = YoutubeUtil.getIstance();
        String queryTerm = request.getParameter("search");
        List<SearchResult> searchResultList = youtubeUtil.search(queryTerm);
        List<String> risultati;
        
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
	 	RicercaDAO ricercaDao = factory.getRicercaDAO();
	 	
         if (searchResultList != null) {
            
        	 //risultati = youtubeUtil.convertToSearch(searchResultList.iterator());
        }
         /*
        for (String i : risultati) {
        	 ricercaDao.save(i);
		}
         */
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
