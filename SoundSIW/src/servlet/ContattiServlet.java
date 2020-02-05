package servlet;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/contattiServlet")
public class ContattiServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String paramEmail= req.getParameter("email");
	 	String paramNome = req.getParameter("nome");
	 	String paramOggetto = req.getParameter("oggetto");
	 	String paramMessaggio = req.getParameter("messaggio");
	 	sendEmail(paramEmail,paramNome,paramOggetto,paramMessaggio);
	 	resp.sendRedirect("contact.jsp"); 
	}
	 public void sendEmail(String userEmail, String name, String subject1,String message) {
		 try{
			 	String host ="smtp.gmail.com" ;
	            String user = "soundsiw2020@gmail.com";
	            String pass = "Presidente2020";
	            String to = "soundsiw2020@gmail.com";
	            String from = "soundsiw2020@gmail.com";
	            String subject = subject1;
	            String messageText = message + "\n" +"\nInviato Da: "+name+" con email: "+userEmail;
	            boolean sessionDebug = false;

	            Properties props = System.getProperties();

	            props.put("mail.smtp.starttls.enable", "true");
	            props.put("mail.smtp.host", host);
	            props.put("mail.smtp.port", "587");
	            props.put("mail.smtp.auth", "true");
	            props.put("mail.smtp.starttls.required", "true");

//	            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
	            Session mailSession = Session.getDefaultInstance(props, null);
	            mailSession.setDebug(sessionDebug);
	            Message msg = new MimeMessage(mailSession);
	            msg.setFrom(new InternetAddress(from));
	            InternetAddress[] address = {new InternetAddress(to)};
	            msg.setRecipients(Message.RecipientType.TO, address);
	            msg.setSubject(subject); msg.setSentDate(new Date());
	            msg.setText(messageText);

	           Transport transport=mailSession.getTransport("smtp");
	           transport.connect(host, user, pass);
	           transport.sendMessage(msg, msg.getAllRecipients());
	           transport.close();
	           System.out.println("Messaggio inviato correttamente");
	        }catch(Exception ex)
	        {
	            System.out.println(ex+"problema nell'invio la mail");
	        }
	 }
}