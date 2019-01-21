import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistDao {

	public Artist findArtist (long artistId) throws ClassNotFoundException, SQLException {
	
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			connection = new ChinookDatabase().connect();
			statement = connection.prepareStatement("SELECT * FROM Artist WHERE ArtistId = ?");
			statement.setLong(1, artistId);
			result = statement.executeQuery();
			
			if (result.next()) {
				long id = result.getLong("ArtistId");
				String name = result.getString("Name");
				
				return new Artist(id, name);
			} else {
				return null;
			}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				ChinookDatabase.closeQuietly(connection, statement, result);
			}
	}
	
	public List<Artist> findAll() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		List<Artist> allArtists = new ArrayList<>();
		
		try {
			connection = new ChinookDatabase().connect();
			statement = connection.prepareStatement("SELECT * from Artist");
			result = statement.executeQuery();
			
		
			
			while (result.next()) {
				Artist artist = new Artist();
				
				long artistId = result.getLong("ArtistId");
				String artistName = result.getString("Name");
				
				artist.setArtistId(artistId);
				artist.setArtistName(artistName);
				
				allArtists.add(artist);
				
				
			}
				
					
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally { ChinookDatabase.closeQuietly(connection, statement, result);}
		
		return allArtists;
	}
	
	public Artist findArtistByName (String artistName) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			connection = new ChinookDatabase().connect();
			statement = connection.prepareStatement("SELECT * FROM Artist WHERE Name = ?");
			statement.setString(1, artistName);
			result = statement.executeQuery();
			
			if (result.next()) {
				String name = result.getString("Name");
				Long id = result.getLong("ArtistId");
				
				
				return new Artist(id, name);
				
			} else {
				return null;
			}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				ChinookDatabase.closeQuietly(connection, statement, result);
			}
	}
	
}
