package objectDAO;

import java.util.List;
import object.Utente;

public interface UtenteDAO {
	
	public void save(Utente utente);
	public Utente findByPrimaryKey(String nomeutente);
	public List<Utente> findAll();
	public void update(Utente utente);
	public void delete(Utente utente);
	public void setPassword(Utente utente, String password);
	public Utente findByCredential(String Email, String Password);
	public Utente findByUsername(String username);
	public Utente findAdmin(String Email,String username,String Password);
	public int sizeByGenere(String genere);
	public int sizeUtenti();
	
	
}

