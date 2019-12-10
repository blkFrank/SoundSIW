package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import objectDAO.PlaylistDAO;
import object.Playlist;


public class PlaylistDaoJDBC implements PlaylistDAO {
	
	private DataSource dataSource;

	public PlaylistDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	
	public void save(Playlist playlist) {
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "insert into playlist(idPlaylist,nome,utente) values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, playlist.getIdPlaylist());
			statement.setString(2, playlist.getNome());
			statement.setString(3, playlist.getUtente());
			
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
	public Playlist findByPrimaryKey(String idplaylist) {
		Connection connection = this.dataSource.getConnection();
		Playlist playlist = null;
		try {
			PreparedStatement statement;
			String query = "select * from playlist where idplaylist = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, idplaylist);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				playlist = new Playlist();
				playlist.setId(result.getString("idplaylist"));
				playlist.setNome(result.getString("nome"));
				playlist.setUtente(result.getString("utente"));
				

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
		return playlist;
	}

	
	@Override
	public List<Playlist> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<Playlist> playlists = new LinkedList<>();
		try {
			Playlist playlist;
			PreparedStatement statement;
			String query = "select * from playlist";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				playlist = new Playlist();
				playlist.setId(result.getString("idplaylist"));
				playlist.setNome(result.getString("nome"));
				playlist.setUtente(result.getString("utente"));
				
				playlists.add(playlist);
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
		return playlists;
	}

	
	@Override
	public void update(Playlist playlist) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update playlist SET idplaylist = ?, nome=? , utente=? WHERE idplaylist=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, playlist.getIdPlaylist());
			statement.setString(2, playlist.getNome());
			statement.setString(3, playlist.getUtente());
			
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
	public void delete(Playlist playlist) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM playlist WHERE idplaylist = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, playlist.getIdPlaylist());
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
