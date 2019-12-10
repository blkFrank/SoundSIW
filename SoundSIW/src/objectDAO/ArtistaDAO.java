package objectDAO;

import java.util.List;
import object.Artista;


public interface ArtistaDAO {

		public void save(Artista artista);
		public Artista findByPrimaryKey(String nickname);
		public List<Artista> findAll();
		public void update(Artista artista);
		public void delete(Artista artista);
}
