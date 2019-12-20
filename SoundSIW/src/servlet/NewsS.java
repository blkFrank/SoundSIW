package servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
	 	String data = req.getParameter("data");
	 	String paramContenuto= req.getParameter("contenuto");
	 	
	 	SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
	 	java.util.Date date=null;
		try {
			date = sdf1.parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	java.sql.Date paramData = new java.sql.Date(date.getTime());
	 	if(paramTitolo=="" || paramData==null || paramContenuto=="" ) {
	 		resp.sendRedirect("GestioneNews.jsp");
	 	}
	 		
	 	
		else {
		 	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		 	NewsDAO newsDao = factory.getNewsDAO();
		 	News news = new News(paramTitolo, paramData, paramContenuto);
		 	newsDao.save(news);
		 	System.out.println("News Aggiunta");
		 	resp.sendRedirect("GestioneNews.jsp");
		 	
		 }
	 	
	 }

}

