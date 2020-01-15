package object;


public class Brano {

	String titolo;
	String id;
	String thumbnail;
	
	public Brano(String titolo, String id,String thumbnail) {
		
		this.titolo = titolo;
		this.id = id;
		this.thumbnail = thumbnail;
		
	}
	
	public Brano() {
	}

	public String getTitolo() {
		return titolo;
	}
	public void setNome(String titolo) {
		this.titolo = titolo;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
}
