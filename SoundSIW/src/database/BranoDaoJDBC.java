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
			String insert = "insert into brano(nome,artista,durata) values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, brano.getNome());
			statement.setString(2, brano.getArtista());
			statement.setString(3, brano.getDurata());
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
	public Brano findByPrimaryKey(String nome) {
		
		Connection connection = this.dataSource.getConnection();
		Brano brano = null;
		try {
			PreparedStatement statement;
			String query = "select * from brano where nome = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, nome);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				brano = new Brano();
				brano.setNome(result.getString("nome"));	
				brano.setArtista(result.getString("artista"));
				brano.setDurata(result.getString("durata"));		
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
				brano.setNome(result.getString("nome"));	
				brano.setArtista(result.getString("artista"));
				brano.setDurata(result.getString("durata"));	
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
	public List<Brano> findAllByArtista (String artista) {
		Connection connection = this.dataSource.getConnection();
		List<Brano> temp = new ArrayList<Brano>();
		try {
			Class.forName("org.postgresql.Driver");

			String select = "select * from brano where artista ='"+artista+"'";
			
			PreparedStatement statement = connection.prepareStatement(select);

			ResultSet rs = statement.executeQuery();
			
            while ( rs.next() ) {
               Brano b = new Brano();
                
                 b.setNome(rs.getString(1));
	       	     b.setArtista(rs.getString(2));
	       	     b.setDurata( rs.getString(3));
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
			String update = "update brano SET nome = ?,artista = ?,durata = ? WHERE nome=?";
			PreparedStatement statement = connection.prepareStatement(update);
			
			statement.setString(1, brano.getNome());
			statement.setString(2, brano.getArtista());
			
			
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
			String delete = "delete FROM brano WHERE nome= ? ";
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
