import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/album")
public class AlbumServlet extends HttpServlet {
	
	// esimerkki urlista: localhost:8080/artist?artistId=1
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String albumId = request.getParameter("albumId");
		long queryId = Long.parseLong(albumId);
		
		AlbumDao albumDao = new AlbumDao();
		Album album = new Album();
		
			try {
				album = albumDao.findAlbum(queryId);
			} catch (ClassNotFoundException | SQLException e) {
				response.getWriter().println("Albumia ei löytynyt");
			}
			
		response.getWriter().println(album.getAlbumName());
	}
}