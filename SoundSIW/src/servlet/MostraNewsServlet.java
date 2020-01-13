package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DatabaseManager;
import object.News;
import objectDAO.NewsDAO;

@WebServlet("/MostraNewsServlet")
public class MostraNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	    
	public MostraNewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewsDAO x= DatabaseManager.getInstance().getDaoFactory().getNewsDAO();
		List<News> nws = x.findAll();
		request.setAttribute("newss", nws);
		RequestDispatcher rd = request.getRequestDispatcher("blog.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
}
