package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import object.Artista;
import objectDAO.ArtistaDAO;

public class ArtistaDaoJDBC implements ArtistaDAO {
	
	private DataSource dataSource;

	public ArtistaDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Artista artista) {
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "insert into artista(nome,nickname,numeroalbum) values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, artista.getNome());
			statement.setString(2, artista.getNickName());
			statement.setInt(3, artista.getNumeroAlbum());
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
	public Artista findByPrimaryKey(String nickname) {
		Connection connection = this.dataSource.getConnection();
		Artista artista = null;
		try {
			PreparedStatement statement;
			String query = "select * from artista where nickname = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, nickname);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				artista = new Artista();
				artista.setNome(result.getString("nome"));
				artista.setNickName(result.getString("nickname"));	
				artista.setNumeroAlbum(result.getInt("numeroalbum"));				
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
		return artista;
	}
	
	@Override
	public List<Artista> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<Artista> artisti = new LinkedList<>();
		try {
			Artista artista;
			PreparedStatement statement;
			String query = "select * from artista";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				artista = new Artista();
				artista.setNome(result.getString("nome"));
				artista.setNickName(result.getString("nickname"));	
				artista.setNumeroAlbum(result.getInt("numeroalbum"));
				artisti.add(artista);
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
		return artisti;
	}

	@Override
	public void update(Artista artista) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update artista SET  nome = ?,,nickname = ?,numeroalbum = ? WHERE nickname=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, artista.getNome());
			statement.setString(2, artista.getNickName());
			statement.setInt(3, artista.getNumeroAlbum());
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
	public void delete(Artista artista) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM artista WHERE nickname = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, artista.getNickName());
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
