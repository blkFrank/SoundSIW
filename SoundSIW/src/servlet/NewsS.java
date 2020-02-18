package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DAOFactory;
import object.News;
import objectDAO.NewsDAO;

/**
 * Servlet implementation class NewsServlet
 */
@SuppressWarnings("serial")
@WebServlet("/NewsS")

public class NewsS extends HttpServlet {
		
	 @Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 	String paramTitolo = req.getParameter("titolo");
	 	String paramData = req.getParameter("data"); 
	 	String paramContenuto= req.getParameter("contenuto");
	 	String paramLinkImg = req.getParameter("linkImg");
	 	
	 	
	 	
	 	
	 	if(paramTitolo=="" || paramData=="" || paramContenuto=="" || paramLinkImg=="") {
	 		resp.sendRedirect("GestioneNews.jsp");
	 	}
	 		
	 	
		else {
		 	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		 	NewsDAO newsDao = factory.getNewsDAO();
		 	Date d = Date.valueOf(paramData);
		 	News news = new News(paramTitolo, d , paramContenuto, paramLinkImg);
		 	newsDao.save(news);
		 	System.out.println("News Aggiunta");
		 	resp.sendRedirect("GestioneNews.jsp");
		 	
		 }
	 	
	 }

}



