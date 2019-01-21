

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/")
public class AllArtistsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArtistDao artistDao = new ArtistDao();
       
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			
			List<Artist> allArtists = new ArrayList<>();
			
			
			
				try {
					allArtists = artistDao.findAll();
				} catch (ClassNotFoundException | SQLException e) {
					response.getWriter().println("Artistia ei löytynyt");
				}
				
				request.setAttribute("allArtists", allArtists);
				request.getRequestDispatcher("/WEB-INF/views/etusivu.jsp").include(request, response);
	}
	


}
