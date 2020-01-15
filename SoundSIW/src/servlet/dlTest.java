package servlet;

import com.sapher.youtubedl.YoutubeDL;
import com.sapher.youtubedl.YoutubeDLException;
import com.sapher.youtubedl.YoutubeDLRequest;
import com.sapher.youtubedl.YoutubeDLResponse;

public class dlTest {

	public static void main(String[] args) {
		String id = "9Fl0csDDP0o";
		String videoUrl = "https://www.youtube.com/watch?v=" + id;
		System.out.println(videoUrl);
		// Destination directory
		String directory = "../SoundSIW/WebContent/audio";    
			
		// Build request
		YoutubeDLRequest DLrequest = new YoutubeDLRequest(videoUrl, directory);

		DLrequest.setOption("extract-audio");		
		DLrequest.setOption("audio-format", "mp3");	
		
		// Make request and return response
		try {
			YoutubeDLResponse DLresponse = YoutubeDL.execute(DLrequest);
			String stdOut = DLresponse.getOut(); // Executable output
		} catch (YoutubeDLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
