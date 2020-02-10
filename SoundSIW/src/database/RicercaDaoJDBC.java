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
			String insert = "insert into ricerca(id, utente, risultato) values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setInt(1, ricerca.getId());
			statement.setString(2, ricerca.getUtente());
			statement.setString(3, ricerca.getRisultato());
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
	public List<Ricerca> findByPrimaryKey(int id) {
		Connection connection = this.dataSource.getConnection();
		Ricerca ricerca = null;
		List<Ricerca> listRicerca = new LinkedList<Ricerca>();
		try {
			PreparedStatement statement;
			String query = "select * from brano where id = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				ricerca = new Ricerca();
				ricerca.setId(result.getInt("id"));	
				ricerca.setUtente(result.getString("utente"));
				ricerca.setRisultato(result.getString("risultato"));	
				listRicerca.add(ricerca);
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}	
		return listRicerca;
	}

	@Override
	public void update(Ricerca ricerca) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Ricerca ricerca) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM ricerca WHERE id= ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setInt(1, ricerca.getId());
			
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
