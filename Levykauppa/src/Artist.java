
public class Artist {
private long artistId;
private String artistName;

public Artist(long artistId, String artistName) {
	super();
	this.artistId = artistId;
	this.artistName = artistName;
}

public Artist() {
}

public long getArtistId() {
	return artistId;
}

public void setArtistId(long artistId) {
	this.artistId = artistId;
}

public String getArtistName() {
	return artistName;
}

public void setArtistName(String artistName) {
	this.artistName = artistName;
}

}



