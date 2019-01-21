
public class Track {

	private long trackId;
	private String trackName;
	
	public Track(long trackId, String trackName) {
		super();
		this.trackId = trackId;
		this.trackName = trackName;
	}
	
	public Track(){}

	public long getTrackId() {
		return trackId;
	}

	public void setTrackId(long trackId) {
		this.trackId = trackId;
	}

	public String getTrackName() {
		return trackName;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}
	
	
	
}
