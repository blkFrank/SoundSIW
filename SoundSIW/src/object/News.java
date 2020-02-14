package object;

import java.sql.Date;

public class News {
	String titolo="";
	Date data=null;
	String contenuto="";
	String linkImg="";
	
	public News(String titolo, Date data, String contenuto, String linkImg) {
		this.titolo = titolo;
		this.data = data;
		this.contenuto = contenuto;
		this.linkImg = linkImg;
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

	public String getLinkImg() {
		return linkImg;
	}

	public void setLinkImg(String linkImg) {
		this.linkImg = linkImg;
	}
	
	
}
