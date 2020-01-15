package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import objectDAO.UtenteDAO;
import object.Utente;
import database.DAOFactory;


/**
 * Servlet implementation class RegistrazioneServlet
 */
@SuppressWarnings("serial")
@WebServlet("/Registrazione")
public class Registrazione extends HttpServlet {	
	 @Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 	String paramUsername = req.getParameter("username");
	 	String paramPassword = req.getParameter("password");
	 	String paramEmail= req.getParameter("email");

	 	if(paramEmail=="" || paramUsername=="" || paramPassword=="" ) {
	 		resp.sendRedirect("registrazione.jsp");
	 	} 
	 	else {
		 	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		 	UtenteDAO utenteDao = factory.getUtenteDAO();
		 	Utente utente = utenteDao.findByUsername(paramUsername);
		 	
		 
		 	if(utente.getUsername().equals("")) {
		 	
		 		
		 		Utente nuovoUtente=new Utente(paramUsername,paramPassword,paramEmail);
		 		utenteDao.save(nuovoUtente);
		 		System.out.println("Registrato");
		 		
		 		
		 		resp.sendRedirect("login.jsp");
		 	}else {
		 		resp.sendRedirect("registrazione.jsp");
		 	}
		}	
	 }
}
