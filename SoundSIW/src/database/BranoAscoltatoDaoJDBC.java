package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import object.BranoAscoltato;
import object.BranoPlaylist;
import object.Ricerca;
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
			
			String insert = "insert into branoascoltato(nomeBrano) values (?)";
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
			String delete = "delete from branoascoltato where nomeBrano= ? ";
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

	public BranoAscoltato musicaPiuAscoltata() {
		Connection connection = this.dataSource.getConnection();
		List<BranoAscoltato> newsList = new LinkedList<>();
		try {
			BranoAscoltato b;
			PreparedStatement statement;
			String query = "select * from branoascoltato where nomeBrano!=' ' ";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				b = new BranoAscoltato();
				b.setNome(result.getString("nomeBrano"));	
				
				
				newsList.add(b);
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
			BranoAscoltato branoPiuAscoltato=new BranoAscoltato();
			int cont=0;
			int max=0;
			
			
				
				
			
			for(int i=0;i<newsList.size()-1;i++) {
				
				for(int j=i+1;j<newsList.size();j++) {
								
							
									if(newsList.get(i).getNome().equals(newsList.get(j).getNome())) {
										cont++;
							}
								
				}
				if(cont>max) {
					max=cont;
					branoPiuAscoltato=newsList.get(i);
				}
				cont=0;
			}
			
			
		
			return branoPiuAscoltato;
}
	public int percentualeBrano(BranoAscoltato br ) {
		Connection connection = this.dataSource.getConnection();
		List<BranoAscoltato> newsList = new LinkedList<>();
		try {
			BranoAscoltato b;
			PreparedStatement statement;
			String query = "select * from branoascoltato where nomeBrano!=' ' ";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				b = new BranoAscoltato();
				b.setNome(result.getString("nomeBrano"));	
				
				
				newsList.add(b);
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
		int cont=0;					for(int i=0;i<newsList.size();i++) {
							if(newsList.get(i).getNome().equals(br.getNome())) {
								cont++;
							}
							
						}
	int percentuale=0;
	if(cont!=0) {
	percentuale=(cont*100)/newsList.size();
	}
	return percentuale;
	}
}
