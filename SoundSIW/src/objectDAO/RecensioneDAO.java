package objectDAO;

import java.util.List;

import object.Recensione;

public interface RecensioneDAO {
	public void save(Recensione recensione);
	public Recensione findByPrimaryKey(String idBrano);
	public List<Recensione> findByUtente(String username);
	public List<Recensione> findAll();
	public void update(Recensione recensione);
	public void delete(Recensione recensione);
}
