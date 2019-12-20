package objectDAO;

import java.util.List;

import object.News;



public interface NewsDAO {

	public void save(News news);
	public News findByPrimaryKey(String titolo);
	public List<News> findAll();
	public void update(News news); //Update
	public void delete(News news); //Delete	
}
