package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import objectDAO.BranoPlaylistDAO;
import object.BranoPlaylist;



public class BranoPlaylistDaoJDBC implements BranoPlaylistDAO {
	
	private DataSource dataSource;

	public BranoPlaylistDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(BranoPlaylist brano) {
		
		Connection connection = this.dataSource.getConnection();
		
		try {
			
			String insert = "insert into branoPlaylist(nomeBrano,idplaylist) values (?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, brano.getNome());
			statement.setString(2, brano.getIdPlaylist());
			
			
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

	public BranoPlaylist findByPlaylist(String idPlaylist) {
		Connection connection = this.dataSource.getConnection();
		BranoPlaylist brano = null;
		try {
			PreparedStatement statement;
			String query = "select * from branoPlaylist where idplaylist = ?";
			statement = connection.prepareStatement(query);
			statement.setString(2, idPlaylist);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				brano = new BranoPlaylist();
				
					
				brano.setNome(result.getString("nomeBrano"));
				brano.setIdPlaylist(result.getString("idplaylist"));
				
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
		return brano;
	}
	

	@Override
	public List<BranoPlaylist> findAll() {
		
		Connection connection = this.dataSource.getConnection();
		List<BranoPlaylist> brani = new LinkedList<>();
		try {
			BranoPlaylist brano;
			PreparedStatement statement;
			String query = "select * from branoPlaylist";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				brano = new BranoPlaylist();
				
					
				brano.setNome(result.getString("nomeBrano"));	
				brano.setIdPlaylist(result.getString("idPlaylist"));	
				
			    brani.add(brano);
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
		return brani;
		
	}

	@Override
	public List<BranoPlaylist> findAllByPlaylist (String p) {
		Connection connection = this.dataSource.getConnection();
		List<BranoPlaylist> temp = new ArrayList<BranoPlaylist>();
		try {
			Class.forName("org.postgresql.Driver");

			String select = "select * from branoPlaylist where idplaylist ='"+p+"'";
			
			PreparedStatement statement = connection.prepareStatement(select);

			ResultSet rs = statement.executeQuery();
			
            while ( rs.next() ) {
               BranoPlaylist b = new BranoPlaylist();
                
                
	       	     b.setNome(rs.getString(1));
	       	     b.setIdPlaylist(rs.getString(2));
	       	     temp.add(b);
            }
            

            return temp;
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			try {
				connection.close();
			} 
			
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	
	@Override
	public void delete(BranoPlaylist brano) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete from branoPlaylist where nomeBrano= ? and idplaylist=? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, brano.getNome());
			statement.setString(2, brano.getIdPlaylist());
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
	public BranoPlaylist findByPlaylistAndNome(String i, String n) {
			Connection connection = this.dataSource.getConnection();
			BranoPlaylist brano = null;
			try {
				PreparedStatement statement;
				String query = "select * from branoPlaylist where nomeBrano=? and idplaylist = ?";
				statement = connection.prepareStatement(query);
				statement.setString(1,i);
				statement.setString(2,n);
				ResultSet result = statement.executeQuery();
				if (result.next()) {
					brano = new BranoPlaylist();
					brano.setNome(result.getString("nomeBrano"));
					brano.setIdPlaylist(result.getString("idplaylist"));
					
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
			return brano;
	}
}

	

	



