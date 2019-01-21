import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlbumDao {
	public Album findAlbum (long albumId) throws SQLException, ClassNotFoundException {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			connection = new ChinookDatabase().connect();
			statement = connection.prepareStatement("SELECT * FROM Album WHERE AlbumId = ?");
			statement.setLong(1, albumId);
			result = statement.executeQuery();
			
			if (result.next()) {
				long id = result.getLong("AlbumId");
				String name = result.getString("Title");
				
				return new Album (id, name);
			} else {
				return null;
			}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				ChinookDatabase.closeQuietly(connection,statement,result);
			}
			}
		
		public List<Album> findAllArtistAlbums(long id) throws ClassNotFoundException, SQLException {
			Connection connection = null;
			PreparedStatement statement = null;
			ResultSet result = null;
			
			List<Album> allAlbums = new ArrayList<>();
			
			try {
				connection = new ChinookDatabase().connect();
				statement = connection.prepareStatement("SELECT * from Album WHERE ArtistId = ?");
				statement.setLong(1, id);
				result = statement.executeQuery();
				
			
				
				while (result.next()) {
					Album album = new Album();
					
					long albumId = result.getLong("AlbumId");
					String albumName = result.getString("Title");
					
					album.setAlbumId(albumId);
					album.setAlbumName(albumName);
					
					allAlbums.add(album);
					
					
				}
					
						
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally { ChinookDatabase.closeQuietly(connection, statement, result);}
			
			return allAlbums;
		}
		
		
		public Album findAlbumByName (String albumName) throws ClassNotFoundException, SQLException {
			Connection connection = null;
			PreparedStatement statement = null;
			ResultSet result = null;
			
			try {
				connection = new ChinookDatabase().connect();
				statement = connection.prepareStatement("SELECT * FROM Album WHERE AlbumName = ?");
				statement.setString(1, albumName);
				result = statement.executeQuery();
				
				if (result.next()) {
					String name = result.getString("Title");
					Long id = result.getLong("AlbumId");
					
					
					return new Album(id, name);
					
				} else {
					return null;
				}
				} catch (SQLException e) {
					throw new RuntimeException(e);
				} finally {
					ChinookDatabase.closeQuietly(connection, statement, result);
				}
		}
	
		public void createAlbum (Album album, long artistId) throws ClassNotFoundException, SQLException {
			
			Connection connection = null;
			PreparedStatement statement = null;
			ResultSet result = null;
			
			try {
				connection = new ChinookDatabase().connect();
				statement = connection.prepareStatement("INSERT INTO Album(Title, ArtistId) VALUES (?,?)");
				
				statement.setString(1, album.getAlbumName());
				statement.setLong(2, artistId);
				
				statement.executeUpdate();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				ChinookDatabase.closeQuietly(connection, statement, result);
			}
		}
	
	
}
