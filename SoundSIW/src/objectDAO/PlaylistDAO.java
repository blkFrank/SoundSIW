package objectDAO;

import java.util.List;
import object.Playlist;

public interface PlaylistDAO {

		public void save(Playlist playlist) ;	
		public Playlist findByPrimaryKey(String idplaylist);     // Retrieve
		public List<Playlist> findAll();       
		public void update(Playlist playlist); //Update
		public void delete(Playlist playlist); //Delete	
		
		
	}

	
