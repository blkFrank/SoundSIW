package object;

public class BranoAscoltato {
	
	String nomeBrano;
	 
	public BranoAscoltato(String nome) {
		this.nomeBrano = nome;
		
	}
	
	public BranoAscoltato() {
	}
	
	
	public String getNome() {
		return nomeBrano;
	}
	public void setNome(String nome) {
		this.nomeBrano = nome;
	}
	
}
