package object;

import java.util.List;

public class Playlist {
	
	
	String idPlaylist;
	String nome;
	String utente;
		 
	public Playlist(String id,String nome, String utente) {
		this.idPlaylist=id;
		this.nome = nome;
		this.utente = utente;
		
	}
	
	public Playlist() {
	}
	
	public String getIdPlaylist() {
		return idPlaylist;
	}
	public void setId(String id) {
		this.idPlaylist = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUtente() {
		return utente;
	}
	public void setUtente(String utente) {
		this.utente = utente;
	}
	
	
	
	
	
}
	

	