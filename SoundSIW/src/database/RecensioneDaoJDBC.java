package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import object.Recensione;
import object.Utente;
import objectDAO.RecensioneDAO;

public class RecensioneDaoJDBC implements RecensioneDAO {
	
	private DataSource dataSource;

	public RecensioneDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void save(Recensione recensione) {
		// TODO Auto-generated method stub
		Connection connection = this.dataSource.getConnection();
		try {
			
			String insert = "insert into recensione(idBrano, oneStar, twoStars, threeStars, fourStars, fiveStars) values (?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, recensione.getIdBrano());
			statement.setInt(2, recensione.getOneStar());
			statement.setInt(3, recensione.getTwoStars());
			statement.setInt(4, recensione.getThreeStars());
			statement.setInt(5, recensione.getFourStars());
			statement.setInt(6, recensione.getFiveStars());
			
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
	public Recensione findByPrimaryKey(String idBrano) {
		// TODO Auto-generated method stub
		Connection connection = this.dataSource.getConnection();
		Recensione recensione = null;
		try {
			PreparedStatement statement;
			String query = "select * from recensione where idBrano = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, idBrano);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				recensione = new Recensione();
				recensione.setIdBrano(result.getString("idBrano"));				
				recensione.setOneStar(result.getInt("oneStar"));
				recensione.setTwoStars(result.getInt("twoStars"));
				recensione.setThreeStars(result.getInt("threeStars"));
				recensione.setFourStars(result.getInt("fourStars"));
				recensione.setFiveStars(result.getInt("fiveStars"));
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
		return recensione;
	}

	@Override
	public List<Recensione> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<Recensione> recensioni = new LinkedList<>();
		try {
			Recensione recensione;
			PreparedStatement statement;
			String query = "select * from recensione";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				recensione = new Recensione();
				recensione.setIdBrano(result.getString("idBrano"));				
				recensione.setOneStar(result.getInt("oneStar"));
				recensione.setTwoStars(result.getInt("twoStar"));
				recensione.setThreeStars(result.getInt("threeStar"));
				recensione.setFourStars(result.getInt("fourStar"));
				recensione.setFiveStars(result.getInt("fiveStar"));
		        recensioni.add(recensione);
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}	 finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return recensioni;
	}

	@Override
	public void update(Recensione recensione) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Recensione recensione) {
		// TODO Auto-generated method stub
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM recensione WHERE idBrano = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, recensione.getIdBrano());
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
	public List<Recensione> findByUtente(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
