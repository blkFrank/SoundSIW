package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import objectDAO.UtenteDAO;
import object.Utente;
import database.DAOFactory;

/**
 * Servlet implementation class LoginServlet 
 */
@SuppressWarnings("serial")

/* linkare la servlet in maniera diversa */

@WebServlet("/login")
public class Login extends HttpServlet {
 

 
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

 HttpSession session = req.getSession();
 String paramEmail= req.getParameter("email");
 String paramPassword = req.getParameter("password");
 
 String admin="admin@gmail.com";
 
 session.setAttribute("loggato", false);

 
 System.out.println(paramEmail+" "+paramPassword);
 DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
 UtenteDAO utenteDao = factory.getUtenteDAO();
 Utente utente = utenteDao.findByCredential(paramEmail, paramPassword);
 
  
 
  
  if(utente!=null && utente.isRegistrato()) { 
   if(utente.getEmail().equals(admin))
   {
    
    session.setAttribute("password", paramPassword);
    session.setAttribute("email", utente.getEmail());
    session.setAttribute("loggato", true);
    session.setAttribute("loggatoAdmin", true);
    session.setAttribute("username", utente.getUsername());
    
    RequestDispatcher disp;
    
    
    disp = req.getRequestDispatcher("index.jsp");
    disp.forward(req, resp);
    return;
   }
   
  session.setAttribute("password", paramPassword);
  session.setAttribute("email", utente.getEmail());
  session.setAttribute("loggato", true);
  session.setAttribute("username", utente.getUsername());
  
  RequestDispatcher disp;
  
  
  disp = req.getRequestDispatcher("index.jsp");
  disp.forward(req, resp);
  
  }else {
  
  resp.sendRedirect("login.jsp");
  
 }
 
 
}

}