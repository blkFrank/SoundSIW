package object;

import java.sql.Date;

public class News {
	String titolo="";
	Date data=null;
	String contenuto="";
	
	public News(String titolo, Date data, String contenuto) {
		this.titolo = titolo;
		this.data = data;
		this.contenuto = contenuto;
	}
	
	public News() {}
	
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public String getTitolo() {return this.titolo;}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public Date getData() {return this.data;}
	
	public void setContenuto(String contenuto) {
		this.contenuto = contenuto;
	}
	
	public String getContenuto() {return contenuto;}
}
