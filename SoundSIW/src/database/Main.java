package database;

import java.io.FileNotFoundException;

import objectDAO.ArtistaDAO;
import objectDAO.BranoDAO;
import objectDAO.UtenteDAO;
import object.Artista;
import object.Brano;
	
public class Main {

		public static void main(String args[]) throws FileNotFoundException {
			
			DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		
			UtilDao util = factory.getUtilDAO();

			util.dropDatabase();
			util.createDatabase();
			
			BranoDAO bd=factory.getBranoDAO();
			
					
			UtenteDAO u=factory.getUtenteDAO();
			
			ArtistaDAO ad=factory.getArtistaDAO();
			
			
		}		
}
