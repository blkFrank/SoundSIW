package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import objectDAO.BranoDAO;
import object.Brano;

public class BranoDaoJDBC implements BranoDAO {
	
	private DataSource dataSource;

	public BranoDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Brano brano) {
		
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "insert into brano(id,thumbnail,titolo) values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, brano.getId());
			statement.setString(2, brano.getThumbnail());
			statement.setString(3, brano.getTitolo());
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
	public Brano findByPrimaryKey(String id) {
		
		Connection connection = this.dataSource.getConnection();
		Brano brano = null;
		try {
			PreparedStatement statement;
			String query = "select * from brano where id = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				brano = new Brano();
				brano.setId(result.getString("id"));	
				brano.setThumbnail(result.getString("thumbnail"));
				brano.setTitolo(result.getString("titolo"));		
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
	public List<Brano> findAll() {
		
		Connection connection = this.dataSource.getConnection();
		List<Brano> brani = new LinkedList<>();
		try {
			Brano brano;
			PreparedStatement statement;
			String query = "select * from brano";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				brano = new Brano();
				brano.setId(result.getString("id"));	
				brano.setThumbnail(result.getString("thumbnail"));
				brano.setTitolo(result.getString("titolo"));	
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
	public List<Brano> findAllByTitolo (String titolo) {
		Connection connection = this.dataSource.getConnection();
		List<Brano> temp = new ArrayList<Brano>();
		try {
			Class.forName("org.postgresql.Driver");

			String select = "select * from brano where titolo ='"+titolo+"'";
			
			PreparedStatement statement = connection.prepareStatement(select);

			ResultSet rs = statement.executeQuery();
			
            while ( rs.next() ) {
               Brano b = new Brano();
                
                 b.setId(rs.getString(1));
	       	     b.setThumbnail(rs.getString(2));
	       	     b.setTitolo( rs.getString(3));
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
	public void update(Brano brano) {
		
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update brano SET id = ?,thumbnail = ?,titolo = ? WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(update);
			
			statement.setString(1, brano.getId());
			statement.setString(2, brano.getThumbnail());
			
			
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
	public void delete(Brano brano) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM brano WHERE id= ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, brano.getId());
			
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
