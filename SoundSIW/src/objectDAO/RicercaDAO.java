package objectDAO;

import java.sql.SQLException;
import java.util.List;

import object.Ricerca;

public interface RicercaDAO {

	public void save(Ricerca brano);  // Create
	 
	public void update(Ricerca brano);
	public Ricerca utentePiuAttivo() ; //Update
	public void delete(Ricerca brano);//Delete
	public int percentualeUtente(Ricerca r);
	public int percentualeRicerca(Ricerca r);
	public Ricerca parolaPiuCercata();
	List<Ricerca> findAllByUtente(String utente);
}
