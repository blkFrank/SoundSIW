package objectDAO;



import object.BranoAscoltato;
import object.BranoPlaylist;

	public interface BranoAscoltatoDAO {

		public void save(BranoAscoltato brano);  // Create
		public BranoAscoltato musicaPiuAscoltata();
		public int percentualeBrano(BranoAscoltato b);
		public void delete(BranoAscoltato brano); //Delete
		
		
	}
	

