package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import objectDAO.UtenteDAO;
import object.Utente;

public class UtenteDaoJDBC implements UtenteDAO {

	private DataSource dataSource;

	public UtenteDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Utente utente) {
		
		Connection connection = this.dataSource.getConnection();
		try {
			
			String insert = "insert into utente(username,password,email,registrato) values (?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, utente.getUsername());
			statement.setString(2, utente.getPassword());
			statement.setString(3, utente.getEmail());
			statement.setBoolean(4, utente.isRegistrato());
			
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
	public Utente findByPrimaryKey(String username) {
		
		Connection connection = this.dataSource.getConnection();
		Utente utente = null;
		try {
			PreparedStatement statement;
			String query = "select * from utente where username = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				utente = new Utente();
				utente.setUsername(result.getString("username"));				
				utente.setPassword(result.getString("password"));
				utente.setEmail(result.getString("email"));
				utente.setRegistrato(result.getBoolean("registrato"));
				utente.setRegistrato(result.getBoolean("genere"));
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
		return utente;
			
	
	}
	
	
	@Override
	public List<Utente> findAll() {
		
		Connection connection = this.dataSource.getConnection();
		List<Utente> utenti = new LinkedList<>();
		try {
			Utente utente;
			PreparedStatement statement;
			String query = "select * from utente";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				utente = new Utente();
				utente.setUsername(result.getString("username"));				
				utente.setPassword(result.getString("password"));
				utente.setEmail(result.getString("email"));
				utente.setRegistrato(result.getBoolean("registrato"));
				
		        utenti.add(utente);
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
		return utenti;
		
	}

	
	@Override
	public void update(Utente utente) {
		
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update utente SET username = ?, password = ?,email = ? registrato=? WHERE username=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, utente.getUsername());
			statement.setString(2, utente.getPassword());
			statement.setString(3, utente.getEmail());
			statement.setBoolean(4, utente.isRegistrato());
			System.out.println("aggiorno");
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
	public void delete(Utente utente) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM utente WHERE email = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, utente.getEmail());
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
	public void setPassword(Utente utente, String password) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update utente SET password = ? WHERE email=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, password);
			statement.setString(2, utente.getEmail());
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
	public Utente findByCredential(String Email, String Password) {
		Connection connection = this.dataSource.getConnection();
		Utente utente = new Utente();
		try {
			
			PreparedStatement statement;
			String query = "select * from utente where email = ? and password = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, Email);
			statement.setString(2, Password);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				utente = new Utente();
				utente.setEmail(result.getString("email"));
				utente.setUsername(result.getString("username"));				
				utente.setPassword(result.getString("password"));
				utente.setRegistrato(result.getBoolean("registrato"));
				
				
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
		return utente;
	}

	@Override
	public Utente findByUsername(String username) {
		Connection connection = this.dataSource.getConnection();
		Utente utente = new Utente ();
		try {
			PreparedStatement statement;
			String query = "select * from utente where username = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				utente = new Utente();
				utente.setEmail(result.getString("email"));
				utente.setUsername(result.getString("username"));				
				utente.setPassword(result.getString("password"));
				utente.setRegistrato(result.getBoolean("registrato"));
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
		return utente;
	}

	@Override
	public int sizeByGenere(String genere) {
		Connection connection = this.dataSource.getConnection();

		try {
			Class.forName("org.postgresql.Driver");
		
			
			
			String select = "SELECT count(*) FROM utente WHERE genere='"+genere+"';";
			
			PreparedStatement statement = connection.prepareStatement(select);

			ResultSet rs = statement.executeQuery();
			
            while ( rs.next() ) {
            	return rs.getInt(1);
            }
            

		}
		catch (SQLException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally {
			
			try {
				connection.close();
			} 
			
			catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return 0;
	}
	
	@Override
	public int sizeUtenti() {
		
		Connection connection = this.dataSource.getConnection();		
		try {
				Class.forName("org.postgresql.Driver");
				String select = "SELECT count(*) FROM utente";
				PreparedStatement statement = connection.prepareStatement(select);

				ResultSet rs = statement.executeQuery();
				
	            while ( rs.next() ) {
	                 return rs.getInt(1);
	            }
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
		return 0;
		
	}


	
	}