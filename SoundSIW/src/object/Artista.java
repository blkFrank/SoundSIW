package object;

public class Artista {
	
	String nome;
	String nickName;
	int numeroAlbum;
	
	public Artista(String nome,String nickName, int numeroAlbum) {
		this.nome = nome;
		this.nickName = nickName;
		this.numeroAlbum = numeroAlbum;
	}
	
	public Artista() {
		this.nome = "";
		
		
		this.nickName = "";
		this.numeroAlbum =0;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNickName() {
		return nickName;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public int getNumeroAlbum() {
		return numeroAlbum;
	}
	
	public void setNumeroAlbum(int numeroAlbum) {
		this.numeroAlbum = numeroAlbum;
	}
}
