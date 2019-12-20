package database;

import objectDAO.ArtistaDAO;
import objectDAO.BranoDAO;
import objectDAO.BranoPlaylistDAO;
import objectDAO.NewsDAO;
import objectDAO.PlaylistDAO;
import objectDAO.UtenteDAO;
import database.UtilDao;

public abstract class DAOFactory {

	public static final int HSQLDB = 1;
	
	public static final int POSTGRESQL = 2;

	public static DAOFactory getDAOFactory(int whichFactory) {
		switch ( whichFactory ) {
		
		case HSQLDB:
			return null;//new HsqldbDAOFactory();
		case POSTGRESQL:
			return new PostgresDAOfactory();
		default:
			return null;
		}
	}
	
	public abstract UtenteDAO getUtenteDAO();
	
	public abstract BranoDAO getBranoDAO();

	public abstract ArtistaDAO getArtistaDAO();
	
	public abstract PlaylistDAO getPlaylistDAO();
	
	public abstract UtilDao getUtilDAO();

	public abstract BranoPlaylistDAO getBranoPlaylistDAO();
	public abstract NewsDAO getNewsDAO();
	
}