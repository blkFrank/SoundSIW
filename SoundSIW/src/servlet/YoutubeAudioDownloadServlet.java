package servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.sapher.youtubedl.YoutubeDL;
import com.sapher.youtubedl.YoutubeDLException;
import com.sapher.youtubedl.YoutubeDLRequest;
import com.sapher.youtubedl.YoutubeDLResponse;

import database.DAOFactory;
import object.BranoPlaylist;
import objectDAO.BranoPlaylistDAO;

@WebServlet("/YoutubeAudioDownloadServlet")

public class YoutubeAudioDownloadServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JsonElement data = new Gson().fromJson(request.getReader(),JsonElement.class);
		HttpSession session = request.getSession();
		
		String id = data.getAsString();
		
		System.out.println("Scarico il brano con id " + id);
		
		String videoUrl = "https://www.youtube.com/watch?v=" + id;
		// Destination directory
		ServletContext application = getServletConfig().getServletContext();
		String directory = System.getProperty("user.home") +"/git/SoundSIW/SoundSIW/WebContent/audio";
		System.out.println("Scarico il brano in " + directory);
		// Build request
		YoutubeDLRequest DLrequest = new YoutubeDLRequest(videoUrl, directory);

		DLrequest.setOption("extract-audio");		
		DLrequest.setOption("audio-format", "mp3");	
		DLrequest.setOption("id");
		
		// Make request and return response
		try {
			YoutubeDLResponse DLresponse = YoutubeDL.execute(DLrequest);
			String stdOut = DLresponse.getOut(); // Executable output
		} catch (YoutubeDLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		String paramUsername= (String) session.getAttribute("username");
		
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		BranoPlaylistDAO bd=factory.getBranoPlaylistDAO();
		BranoPlaylist b=new BranoPlaylist(id,paramUsername);
	    BranoPlaylist b1=bd.findByPlaylistAndNome(id,paramUsername);
		if(b1==null)
		{	
			bd.save(b);
			
		}
		else
		{
			System.out.println("Ciao!");
		}
		
		*/
	}

}
