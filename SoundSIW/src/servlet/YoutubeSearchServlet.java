package servlet;


import com.google.api.services.youtube.model.SearchResult;
import java.io.IOException;
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