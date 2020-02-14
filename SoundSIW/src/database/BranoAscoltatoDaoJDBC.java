package database;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import object.BranoAscoltato;
import object.BranoPlaylist;
import objectDAO.BranoAscoltatoDAO;

public class BranoAscoltatoDaoJDBC implements  BranoAscoltatoDAO{

	
	private DataSource dataSource;

	public BranoAscoltatoDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(BranoAscoltato brano) {
		
		Connection connection = this.dataSource.getConnection();
		
		try {
			
			String insert = "insert into branoPlaylist(nomeBrano) values (?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, brano.getNome());
			
			
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
	public void delete(BranoAscoltato brano) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete from branoPlaylist where nomeBrano= ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, brano.getNome());
			
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

	
}
