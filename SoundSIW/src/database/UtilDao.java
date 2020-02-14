package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UtilDao {

	private DataSource dataSource;
	
	public UtilDao(DataSource dataSource) {
		this.dataSource=dataSource;
	}

	
	
	public void dropDatabase() {
		Connection connection = dataSource.getConnection();
		try {
			String delete = "drop SEQUENCE if EXISTS sequenza_id;"
					+ "drop table if exists artista;"
					+ "drop table if exists brano;"
					+ "drop table if exists utente;"
				    + "drop table if exists playlist;"
				    + "drop table if exists branoPlaylist;"
				    +"drop table if exists news;"
				    + "drop table if exists ricerca;"
				    + "drop table if exists branoAscoltato;";
			PreparedStatement statement = connection.prepareStatement(delete);
		
			statement.executeUpdate();
			System.out.println("Drop database eseguito");
		
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


	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void createDatabase(){
	
		Connection connection = dataSource.getConnection();
		try {
		
			String create = "create SEQUENCE sequenza_id;"
				 + "create table utente(\"username\" varchar(255) primary key, password varchar(255),email varchar(255),registrato boolean);"
					+ "create table playlist(\"idplaylist\" varchar(255) primary key,nome varchar(255),utente varchar(255));"
					+ "create table brano(\"nome\" varchar(255),artista varchar(255),durata varchar(255));"
					+ "create table artista(\"nickname\" varchar(255) primary key,nome varchar(255), cognome varchar(255),numeroalbum int);"
					+ "create table branoPlaylist(nomeBrano varchar(255),idplaylist varchar(255));"
			        + "create table news( \"titolo\"varchar(255) primary key,data date,contenuto varchar(3000), linkImg varchar(255));"
					+ "create table ricerca(utente varchar(255), risultato varchar(255));"
					+ "create table branoAscoltato(nomeBrano varchar(1000));"; 
			PreparedStatement statement = connection.prepareStatement(create);
		
			statement.executeUpdate();
			System.out.println("Creazione database eseguita");
			System.out.println(create);
		
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


	public  void resetDatabase() {
		
		Connection connection = dataSource.getConnection();
		try {
			String delete = "delete FROM utente";
			
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.executeUpdate();
			
			delete = "delete FROM artista";
			statement = connection.prepareStatement(delete);
			
			delete = "delete FROM brano";
			statement = connection.prepareStatement(delete);
			
			delete = "delete FROM playlist";
			statement = connection.prepareStatement(delete);
			
			delete = "delete FROM branoPlaylist";
			statement = connection.prepareStatement(delete);
			
			delete = "delete FROM ricerca";
			statement = connection.prepareStatement(delete);
			
			delete = "delete FROM branoAscoltato";
			statement = connection.prepareStatement(delete);
			
			statement.executeUpdate();
			System.out.println("Reset database eseguito");

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