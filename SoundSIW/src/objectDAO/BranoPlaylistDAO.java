package objectDAO;

import java.util.List;
import object.BranoPlaylist;

public interface BranoPlaylistDAO {

	public void save(BranoPlaylist brano);  // Create
	public BranoPlaylist findByPlaylist(String a); 
	public BranoPlaylist findByPlaylistAndNome(String i,String n); 
	public List<BranoPlaylist> findAll();
	public List<BranoPlaylist> findAllByPlaylist(String p);
	public void delete(BranoPlaylist brano); //Delete
	
	
}







