package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DatabaseManager;
import object.BranoAscoltato;
import object.Ricerca;
import objectDAO.BranoAscoltatoDAO;
import objectDAO.RicercaDAO;


@WebServlet("/MostraUtentePiuAttivo")
public class MostraUtentePiuAttivo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	    
	public MostraUtentePiuAttivo() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RicercaDAO x= DatabaseManager.getInstance().getDaoFactory().getRicercaDAO();
		BranoAscoltatoDAO x1= DatabaseManager.getInstance().getDaoFactory().getBranoAscoltatoDAO();
				
			// PRIMA STATISTICA
			Ricerca r=x.utentePiuAttivo();
			
			request.setAttribute("utente",r.getUtente());
			double p=x.percentualeUtente(r);
			if(p!=0) {
			request.setAttribute("grafico",p/100);
			int intero=(int) p;
			request.setAttribute("percentuale",intero);
			}
			// SECONDA STATISTICA
			
			Ricerca r2=x.parolaPiuCercata();
			request.setAttribute("ricerca",r2.getRisultato());
			double p3=x.percentualeRicerca(r2);
			if(p3!=0) {
			request.setAttribute("graficoRicerca",p3/100);
			int in=(int) p3;
			request.setAttribute("percentualeRicerca",in);
			}
			// TERZA STATISTICA
			BranoAscoltato b=x1.musicaPiuAscoltata();
			request.setAttribute("brano",b.getNome());
			double p4=x1.percentualeBrano(b);
			if(p4!=0) {
			request.setAttribute("graficoBrano",p4/100);
			int inter=(int) p4;
			request.setAttribute("percentualeBrano",inter);
			}
			
			
			RequestDispatcher rd = request.getRequestDispatcher("statistiche.jsp");
			rd.forward(request, response);
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
}