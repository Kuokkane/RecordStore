import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/track")
public class TrackServlet extends HttpServlet {
	
	// esimerkki urlista: localhost:8080/artist?artistId=1
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String trackId = request.getParameter("trackId");
		long queryId = Long.parseLong(trackId);
		
		TrackDao trackDao = new TrackDao();
		Track track = new Track();
		
			try {
				track = trackDao.findTrack(queryId);
			} catch (ClassNotFoundException | SQLException e) {
				response.getWriter().println("Kappaletta ei löytynyt");
			}
			
		response.getWriter().println(track.getTrackName());
	}
} 


