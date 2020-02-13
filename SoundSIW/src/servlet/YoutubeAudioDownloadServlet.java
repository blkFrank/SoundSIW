package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.sapher.youtubedl.YoutubeDL;
import com.sapher.youtubedl.YoutubeDLException;
import com.sapher.youtubedl.YoutubeDLRequest;
import com.sapher.youtubedl.YoutubeDLResponse;

/**
 * Servlet implementation class YoutubeAudioDownloadServlet1
 */
@WebServlet("/YoutubeAudioDownloadServlet")
public class YoutubeAudioDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YoutubeAudioDownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response, String videoUrl) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		// Build request
		
		YoutubeDLRequest DLrequest = new YoutubeDLRequest(videoUrl);
		DLrequest.setOption("extract-audio");	
		DLrequest.setOption("get-url");		
		DLrequest.setOption("audio-format", "mp3");
		
		try {
			YoutubeDLResponse DLresponse = YoutubeDL.execute(DLrequest);
			String json = new Gson().toJson(DLresponse.getOut());
			response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		} catch (YoutubeDLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JsonElement data = new Gson().fromJson(request.getReader(),JsonElement.class);
		HttpSession session = request.getSession();
		
		String id = data.getAsString();
		
		System.out.println("Scarico il brano con id " + id);
		
		String videoUrl = "https://www.youtube.com/watch?v=" + id;
		doGet(request, response, videoUrl);
	}

}
