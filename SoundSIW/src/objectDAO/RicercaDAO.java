package objectDAO;

import java.util.List;

import object.Ricerca;

public interface RicercaDAO {

	public void save(Ricerca brano);  // Create
	 
	public void update(Ricerca brano); //Update
	public void delete(Ricerca brano); //Delete
	List<Ricerca> findAllByUtente(String utente);
}
