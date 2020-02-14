package database;

import java.io.FileNotFoundException;

import objectDAO.BranoDAO;
import objectDAO.UtenteDAO;
import object.Brano;
	
public class Main {

		public static void main(String args[]) throws FileNotFoundException {
			
			DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		
			UtilDao util = factory.getUtilDAO();

			 util.dropDatabase();
			util.createDatabase();
			
			
			
			
			
		}		
}
