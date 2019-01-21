import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TrackDao {
	
	
	public Track findTrack (long TrackId) throws SQLException, ClassNotFoundException {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			connection = new ChinookDatabase().connect();
			statement = connection.prepareStatement("SELECT * FROM Track WHERE TrackId = ?");
			statement.setLong(1, TrackId);
			result = statement.executeQuery();
			
			if (result.next()) {
				long id = result.getLong("TrackId");
				String name = result.getString("Name");
				
				return new Track(id, name);
			} else {
				return null;
			}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				ChinookDatabase.closeQuietly(connection,statement,result);
			}
	}
	
	public Track findTrackByName (String trackName) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			connection = new ChinookDatabase().connect();
			statement = connection.prepareStatement("SELECT * FROM Track WHERE TrackName = ?");
			statement.setString(1, trackName);
			result = statement.executeQuery();
			
			if (result.next()) {
				String name = result.getString("TrackName");
				Long id = result.getLong("TrackId");
				
				
				return new Track(id, name);
				
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
