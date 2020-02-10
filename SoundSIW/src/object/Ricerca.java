package object;

public class Ricerca {

	private static int id=0;
	private String utente;
	private String risultato;
	
	public Ricerca() {
		Ricerca.id++;
		this.utente = "";
		this.risultato = "";
	}
	public Ricerca(String utente, String risultato) {
		Ricerca.id++;
		this.utente = utente;
		this.risultato = risultato;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		Ricerca.id = id;
	}
	public String getUtente() {
		return utente;
	}
	public void setUtente(String utente) {
		this.utente = utente;
	}
	public String getRisultato() {
		return risultato;
	}
	public void setRisultato(String risultato) {
		this.risultato = risultato;
	}

}
