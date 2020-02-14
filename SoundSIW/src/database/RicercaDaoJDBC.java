package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import object.Brano;
import object.Ricerca;
import objectDAO.RicercaDAO;

public class RicercaDaoJDBC implements RicercaDAO {

	private DataSource dataSource;

	public RicercaDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public void save(Ricerca ricerca) {
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "insert into ricerca(utente, risultato) values (?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			
			statement.setString(1, ricerca.getUtente());
			statement.setString(2, ricerca.getRisultato());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				
				throw new PersistenceException(e.getMessage());
			}
		}

	}

	
	@Override
	public void update(Ricerca ricerca) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Ricerca ricerca) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM ricerca WHERE utente= ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, ricerca.getUtente());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}

	}

	@Override
	public List<Ricerca> findAllByUtente(String ricerca) {
		// TODO Auto-generated method stub
		return null;
	}

}
