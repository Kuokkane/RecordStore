
public class Album {
	
private long albumId;
private String albumName;

public Album() {}

public Album(long albumId, String albumName) {
	super();
	this.albumId = albumId;
	this.albumName = albumName;
}
public long getAlbumId() {
	return albumId;
}
public void setAlbumId(long albumId) {
	this.albumId = albumId;
}
public String getAlbumName() {
	return albumName;
}
public void setAlbumName(String albumName) {
	this.albumName = albumName;
}

}