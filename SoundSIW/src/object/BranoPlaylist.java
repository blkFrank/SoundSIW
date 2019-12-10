package object;

public class BranoPlaylist {
	
	String idPlaylist;
	String nomeBrano;
	 
	public BranoPlaylist(String nome, String id) {
		this.nomeBrano = nome;
		this.idPlaylist=id;
	}
	
	public BranoPlaylist() {
	}
	
	public String getIdPlaylist() {
		return idPlaylist;
	}
	public void setIdPlaylist(String id) {
		this.idPlaylist = id;
	}
	public String getNome() {
		return nomeBrano;
	}
	public void setNome(String nome) {
		this.nomeBrano = nome;
	}

	
	
	
	
	
	
}
	

	
