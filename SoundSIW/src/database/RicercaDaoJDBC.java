package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import object.Brano;
import object.News;
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
			String insert = "insert into ricerca(utente, risultato) values (?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			
			statement.setString(1, ricerca.getUtente());
			statement.setString(2, ricerca.getRisultato());
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
	public void update(Ricerca ricerca) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Ricerca ricerca) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM ricerca WHERE utente= ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, ricerca.getUtente());
			statement.setString(2, ricerca.getRisultato());
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
	public Ricerca utentePiuAttivo() {
		Connection connection = this.dataSource.getConnection();
		List<Ricerca> newsList = new LinkedList<>();
		try {
			Ricerca r;
			PreparedStatement statement;
			String query = "select * from ricerca where utente!=' ' ";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				r = new Ricerca();
				r.setUtente(result.getString("utente"));	
				r.setRisultato(result.getString("risultato"));
				
				newsList.add(r);
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
			Ricerca utentePiuAttivo=new Ricerca();
			int cont=0;
			int max=0;
			
			
				
				
			
			for(int i=0;i<newsList.size()-1;i++) {
				System.out.println(newsList.get(i).getUtente());
				for(int j=i+1;j<newsList.size();j++) {
								
							
									if(newsList.get(i).getUtente().equals(newsList.get(j).getUtente())) {
										cont++;
							}
								
				}
				if(cont>max) {
					max=cont;
					utentePiuAttivo=newsList.get(i);
				}
				cont=0;
			}
			
			
		
			return utentePiuAttivo;
}


public int percentualeUtente(Ricerca ri) {
	Connection connection = this.dataSource.getConnection();
	List<Ricerca> newsList = new LinkedList<>();
	try {
		Ricerca r;
		PreparedStatement statement;
		String query = "select * from ricerca where utente!=' ' ";
		statement = connection.prepareStatement(query);
		ResultSet result = statement.executeQuery();
		while (result.next()) {
			r = new Ricerca();
			r.setUtente(result.getString("utente"));	
			r.setRisultato(result.getString("risultato"));
			
			newsList.add(r);
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
						if(newsList.get(i).getUtente().equals(ri.getUtente())) {
							cont++;
						}
						
					}
int percentuale=0;
if(cont!=0) {
percentuale=(cont*100)/newsList.size();
}
return percentuale;
}

public Ricerca parolaPiuCercata() {
	
	Connection connection = this.dataSource.getConnection();
	List<Ricerca> newsList = new LinkedList<>();
	try {
		Ricerca r;
		PreparedStatement statement;
		String query = "select * from ricerca where utente!=' ' ";
		statement = connection.prepareStatement(query);
		ResultSet result = statement.executeQuery();
		while (result.next()) {
			r = new Ricerca();
			r.setUtente(result.getString("utente"));	
			r.setRisultato(result.getString("risultato"));
			
			newsList.add(r);
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
	Ricerca parolaPiuCercata=new Ricerca();
	int cont=0;
	int max=0;
	
	
		
		
	
	for(int i=0;i<newsList.size()-1;i++) {
		System.out.println(newsList.get(i).getUtente());
		for(int j=i+1;j<newsList.size();j++) {
						
					
							if(newsList.get(i).getRisultato().equals(newsList.get(j).getRisultato())) {
						
								cont++;
					}
						
		}
		if(cont>max) {
			max=cont;
			parolaPiuCercata=newsList.get(i);
		}
		cont=0;
	}
	
	

	return parolaPiuCercata;
}
public int percentualeRicerca(Ricerca ri) {
	Connection connection = this.dataSource.getConnection();
	List<Ricerca> newsList = new LinkedList<>();
	try {
		Ricerca r;
		PreparedStatement statement;
		String query = "select * from ricerca where utente!=' ' ";
		statement = connection.prepareStatement(query);
		ResultSet result = statement.executeQuery();
		while (result.next()) {
			r = new Ricerca();
			r.setUtente(result.getString("utente"));	
			r.setRisultato(result.getString("risultato"));
			
			newsList.add(r);
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
						if(newsList.get(i).getRisultato().equals(ri.getRisultato())) {
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