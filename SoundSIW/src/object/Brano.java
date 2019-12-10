package object;


public class Brano {

	
	String nome;
	String artista;
	String durata;
	
	
	
	public Brano(String nome, String artista,String durata) {
		
		this.nome = nome;
		this.artista = artista;
		this.durata=durata;
		
	}
	
	public Brano() {
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getArtista() {
		return artista;
	}
	public void setArtista(String artista) {
		this.artista = artista;
	}
	
	public String getDurata() {
		return durata;
	}
	public void setDurata(String artista) {
		this.durata = artista;
	}
	
	
	
	
}
