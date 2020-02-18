package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.api.services.youtube.model.SearchResult;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import database.DAOFactory;
import object.BranoAscoltato;
import object.Ricerca;
import objectDAO.BranoAscoltatoDAO;
import objectDAO.RicercaDAO;

@WebServlet("/AggiungiBranoAscoltato")
public class AggiungiBranoAscoltato extends HttpServlet {
	
	
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	 	
	doGet(request, response);
	}
    
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    

        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
	 	BranoAscoltatoDAO branoDao = factory.getBranoAscoltatoDAO();
	 	HttpSession session = request.getSession();
	 	JsonElement data = new Gson().fromJson(request.getReader(),JsonElement.class);
		
		
		String titolo = data.getAsString();
	 	BranoAscoltato b=new BranoAscoltato(titolo);
	 	System.out.println("AGGIUNTOALDATABASE");
		branoDao.save(b);
		
	 	
	 	RequestDispatcher dispacher = request.getRequestDispatcher("albums-store.jsp");
	dispacher.forward(request, response);
    }

   
   
}