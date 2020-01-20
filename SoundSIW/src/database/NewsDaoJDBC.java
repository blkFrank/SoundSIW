package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import object.News;
import objectDAO.NewsDAO;

public class NewsDaoJDBC implements NewsDAO {

	private DataSource dataSource;
	
	public NewsDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void save(News news) {
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "insert into news(titolo, data, contenuto) values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, news.getTitolo());
			statement.setDate(2, news.getData());
			statement.setString(3, news.getContenuto());
			statement.executeUpdate();
		} catch(SQLException e) {
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
	public News findByPrimaryKey(String titolo) {
		Connection connection = this.dataSource.getConnection();
		News news = null;
		try {
			PreparedStatement statement;
			String query = "select * from news where titolo = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, titolo);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				news = new News();
				news.setTitolo(result.getString("titolo"));	
				news.setData(result.getDate("data"));
				news.setContenuto(result.getString("contenuto"));		
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
		return news;
	}

	@Override
	public List<News> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<News> newsList = new LinkedList<>();
		try {
			News news;
			PreparedStatement statement;
			String query = "select * from news";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				news = new News();
				news.setTitolo(result.getString("titolo"));	
				news.setData(result.getDate("data"));
				news.setContenuto(result.getString("contenuto"));	
				newsList.add(news);
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
		return newsList;
	}

	@Override
	public void update(News news) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update news SET titolo = ?, data = ?, contenuto = ? WHERE titolo = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, news.getTitolo());
			statement.setDate(2, news.getData());
			statement.setString(3, news.getContenuto());
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
	public void delete(News news) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM news WHERE titolo= ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, news.getTitolo());
			
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
