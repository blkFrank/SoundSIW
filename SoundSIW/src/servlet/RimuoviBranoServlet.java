package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import database.DAOFactory;
import object.BranoPlaylist;
import objectDAO.BranoPlaylistDAO;

@WebServlet("/RimuoviBranoServlet")

public class RimuoviBranoServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RimuoviBranoServlet() {
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
		JsonElement data = new Gson().fromJson(request.getReader(),JsonElement.class);
		HttpSession session = request.getSession();
		String paramUsername= (String) session.getAttribute("username");
		String brano =data.getAsString();
		System.out.println(brano);
		System.out.println(paramUsername);
		PrintWriter out=response.getWriter();
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		BranoPlaylistDAO bd=factory.getBranoPlaylistDAO();
		BranoPlaylist b=new BranoPlaylist(brano,paramUsername);
	    BranoPlaylist b1=bd.findByPlaylistAndNome(brano,paramUsername);
		if(b1!=null)
		{	
			bd.delete(b);
			
			out.println("<meta http-equiv='refresh' content='3';URL=playlist.jsp'>");
			out.println("<p style='color:red;'> Brano rimosso con successo </p>");
		}
		else
		{
			out.println("<meta http-equiv='refresh' content='3';URL=playlist.jsp'>");
			out.println("<p style='color:red;'> Brano non presente </p>");
			
		}
	}
}
