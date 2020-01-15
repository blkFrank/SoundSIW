package objectDAO;

import java.util.List;
import object.Brano;

public interface BranoDAO {

		public void save(Brano brano);  // Create
		public Brano findByPrimaryKey(String nome);  // Retrieve
		public List<Brano> findAll();       
		public void update(Brano brano); //Update
		public void delete(Brano brano); //Delete
		List<Brano> findAllByTitolo(String titolo);
}








