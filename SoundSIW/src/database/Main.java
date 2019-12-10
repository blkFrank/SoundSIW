package database;

import java.io.FileNotFoundException;

import objectDAO.ArtistaDAO;
import objectDAO.BranoDAO;
import object.Artista;
import object.Brano;
	
public class Main {

		public static void main(String args[]) throws FileNotFoundException {
					
			DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		
			UtilDao util = factory.getUtilDAO();

			util.dropDatabase();
			util.createDatabase();
			
			BranoDAO bd=factory.getBranoDAO();
			
			Brano b1=new Brano("Redemption Song","Bob Marley","03:00");
			Brano b2=new Brano("One Love","Bob Marley","03:00");
			Brano b3=new Brano("Buffalo Soldier","Bob Marley","03:00");
			Brano b4=new Brano("No woman no cry","Bob Marley","03:00");
			Brano b5=new Brano("Is this love","Bob Marley","03:00");
			
			Brano b6=new Brano("Bohemian Rhapsody","Queen","03:00");
			Brano b7=new Brano("We will rock you","Queen","03:00");
			Brano b8=new Brano("Somebody to love","Queen","03:00");
			Brano b9=new Brano("Under Pressure","Queen","03:00");
			Brano b10=new Brano("We are the champion","Queen","03:00");
			
			Brano b11=new Brano("When i'm gone","Eminem","03:00");
			Brano b12=new Brano("Not Afraid","Eminem","03:00");
			Brano b13=new Brano("Mocking bird","Eminem","03:00");
			Brano b14=new Brano("Lose yourself","Eminem","03:00");
			Brano b15=new Brano("Rap God","Eminem","03:00");
			
			Brano b16=new Brano("Alba Chiara","Vasco Rossi","03:00");
			Brano b17=new Brano("Quante Volte","Vasco Rossi","03:00");
			Brano b18=new Brano("Liberi Liberi","Vasco Rossi","03:00");
			Brano b19=new Brano("Siamo solo noi","Vasco Rossi","03:00");
			Brano b20=new Brano("Vita spericolata","Vasco Rossi","03:00");
			
			Brano b21=new Brano("Let it be","Beatles","03:00");
			Brano b22=new Brano("Hey jude","Beatles","03:00");
			Brano b23=new Brano("Something","Beatles","03:00");
			Brano b24=new Brano("Come togheter","Beatles","03:00");
			Brano b25=new Brano("Yellow Submarine","Beatles","03:00");
			
			Brano b26=new Brano("Diamonds","Rihanna","03:00");
			Brano b27=new Brano("Umbrella","Rihanna","03:00");
			Brano b28=new Brano("Stay","Rihanna","03:00");
			Brano b29=new Brano("Work","Rihanna","03:00");
			Brano b30=new Brano("Man Down","Rihanna","03:00");
			
			Brano b31=new Brano("A te","Jovanotti","03:00");
			Brano b32=new Brano("Per Te","Jovanotti","03:00");
			Brano b33=new Brano("Estate","Jovanotti","03:00");
			Brano b34=new Brano("Gli Immortali","Jovanotti","03:00");
			Brano b35=new Brano("Chiaro di luna","Jovanotti","03:00");
			
			Brano b36=new Brano("Certe notti","Ligabue","03:00");
			Brano b37=new Brano("Ho messo via","Ligabue","03:00");
			Brano b38=new Brano("Ti sento","Ligabue","03:00");
			Brano b39=new Brano("Tu sei lei","Ligabue","03:00");
			Brano b40=new Brano("L'amore conta","Ligabue","03:00");
			
			Brano b41=new Brano("Forever Young","Bob Dylan","03:00");
			Brano b42=new Brano("Shelter from the storm","Bob Dylan","03:00");
			Brano b43=new Brano("Mr tambourine man","Bob Dylan","03:00");
			Brano b44=new Brano("Blowin in the wind","Bob Dylan","03:00");
			Brano b45=new Brano("Hurricane","Bob Dylan","03:00");
			
			Brano b46=new Brano("Azure","Paul Kalkbrenner","03:00");
			Brano b47=new Brano("Sky and Sand","Paul Kalkbrenner","03:00");
			Brano b48=new Brano("Cloud rider","Paul Kalkbrenner","03:00");
			Brano b49=new Brano("Aaron","Paul Kalkbrenner","03:00");
			Brano b50=new Brano("Revolte","Paul Kalkbrenner","03:00");
			
			bd.save(b1);
			bd.save(b2);
			bd.save(b3);
			bd.save(b4);
			bd.save(b5);
			
			bd.save(b6);
			bd.save(b7);
			bd.save(b8);
			bd.save(b9);
			bd.save(b10);
			
			bd.save(b11);
			bd.save(b12);
			bd.save(b13);
			bd.save(b14);
			bd.save(b15);
			
			bd.save(b16);
			bd.save(b17);
			bd.save(b18);
			bd.save(b19);
			bd.save(b20);
			
			bd.save(b21);
			bd.save(b22);
			bd.save(b23);
			bd.save(b24);
			bd.save(b25);
			
			bd.save(b26);
			bd.save(b27);
			bd.save(b28);
			bd.save(b29);
			bd.save(b30);
			
			bd.save(b31);
			bd.save(b32);
			bd.save(b33);
			bd.save(b34);
			bd.save(b35);
			
			bd.save(b36);
			bd.save(b37);
			bd.save(b38);
			bd.save(b39);
			bd.save(b40);
			
			bd.save(b41);
			bd.save(b42);
			bd.save(b43);
			bd.save(b44);
			bd.save(b45);
			
			bd.save(b46);
			bd.save(b47);
			bd.save(b48);
			bd.save(b49);
			bd.save(b50);
			
			ArtistaDAO ad=factory.getArtistaDAO();
			
			Artista a1=new Artista("Bob Marley","Bob Marley",20);
			Artista a2=new Artista("Queen","Queen",28);
			Artista a3=new Artista("Beatles","Beatles",17);
			Artista a4=new Artista("Jovanotti","Jovanotti",6);
			Artista a5=new Artista("Rihanna","Rihanna",8);
			Artista a6=new Artista("Bob Dylan","Bob Dylan",38);
			Artista a7=new Artista("Ligabue","Ligabue",21);
			Artista a8=new Artista("Vasco Rossi","Vasco Rossi",13);
			Artista a9=new Artista("Paul Kalkbrenner","Paul Kalkbrenner",9);
			Artista a10=new Artista("Eminem","Eminem",14);
			
			ad.save(a1);
			ad.save(a2);
			ad.save(a3);
			ad.save(a4);
			ad.save(a5);
			ad.save(a6);
			ad.save(a7);
			ad.save(a8);
			ad.save(a9);
			ad.save(a10);		
		}		
}
