package database;

import objectDAO.ArtistaDAO;
import objectDAO.BranoDAO;
import objectDAO.BranoPlaylistDAO;
import objectDAO.NewsDAO;
import objectDAO.PlaylistDAO;
import objectDAO.UtenteDAO;

//@SuppressWarnings("deprecation")
public class PostgresDAOfactory extends DAOFactory {
	
	private static DataSource dataSource;
	private static PostgresDAOfactory factory;

	static {
		try {
			Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
			
			//remoto
			dataSource = new DataSource("jdbc:postgresql://rogue.db.elephantsql.com:5432/ypygwdlw", "ypygwdlw", "NCQUN2sQR94We3WaocINOiS0aqSGC8h3");
			
		} catch (Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n" + e);
			e.printStackTrace();
		}
	}
	
	public static PostgresDAOfactory getInstance(){
		if (factory == null){
			factory = new PostgresDAOfactory();
		}
		return factory;
	}

	@Override
	public UtenteDAO getUtenteDAO() {
		return new UtenteDaoJDBC(dataSource);
	}

	

	@Override
	public BranoDAO getBranoDAO() {
		return new BranoDaoJDBC(dataSource);
	}

	@Override
	public ArtistaDAO getArtistaDAO() {
		return new ArtistaDaoJDBC(dataSource);
	}

	@Override
	public PlaylistDAO getPlaylistDAO() {
		return new PlaylistDaoJDBC(dataSource);
	}

	@Override
	public BranoPlaylistDAO getBranoPlaylistDAO() {
		return new BranoPlaylistDaoJDBC(dataSource);
	}
	
	
	@Override
	public UtilDao getUtilDAO() {
		return new UtilDao(dataSource);
	}
	@Override
	public NewsDAO getNewsDAO() {
		return new NewsDaoJDBC(dataSource);
	}
	

}
