import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/artist")
public class ArtistServlet extends HttpServlet {
	
	private AlbumDao albumDao = new AlbumDao();
	private ArtistDao artistDao = new ArtistDao();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String artistId = request.getParameter("artistId");
		long queryId = Long.parseLong(artistId);
		
		
		Artist artist = new Artist();
		List<Album> albums = new ArrayList<>();
		
			try {
				artist = artistDao.findArtist(queryId);
				
				albums = albumDao.findAllArtistAlbums(artist.getArtistId());
			} catch (ClassNotFoundException | SQLException e) {
				response.getWriter().println("Artistia ei löytynyt");
			}
			
			request.setAttribute("artist", artist);
			request.setAttribute("albums", albums);
			
			request.getRequestDispatcher("/WEB-INF/views/etusivu.jsp").include(request, response);
	}
} 	 
