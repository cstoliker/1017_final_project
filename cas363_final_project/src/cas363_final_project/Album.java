package cas363_final_project;

import java.sql.SQLException;

import javax.persistence.*;

import org.json.JSONException;
import org.json.JSONObject;

@Entity
@Table (name="album")

//I have this problem on all of my classes
//error: Class "cas363_final_project.Album" is managed, but is not listed in the persistence.xml file
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "album_id")
	private String albumID;

	@Column(name = "title")
	private String title;
	
	@Column(name = "release_date")
	private String releaseDate;
	
	@Column(name = "cover_image_path")
	private String coverImagePath;

	@Column(name = "recording_company_name")
	private String recordingCompanyName;
	
	@Column(name = "number_of_tracks")
	private String numberOfTracks;
	
	@Column(name = "PMRC_rating")
	private String pmrcRating;
	
	@Column(name = "length")
	private String length;

	public String getAlbumId() {
		return albumID;
	}
	
	public void setAlbumID(String albumID){
		this.albumID = albumID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public String getCoverImagePath() {
		return coverImagePath;
	}

	public void setCoverImagePath(String coverImagePath) {
		this.coverImagePath = coverImagePath;
	}
	
	public String getRecordingCompanyName() {
		return recordingCompanyName;
	}
	
	public void setRecordingCompanyName(String recordingCompanyName) {
		this.recordingCompanyName = recordingCompanyName;
	}
	
	public String getNumberOfTracks() {
		return numberOfTracks;
	}
	
	public void setNumberOfTracks(String numberOfTracks) {
		this.numberOfTracks = numberOfTracks;
	}
	
	public String getPMRCRating( ) {
		return pmrcRating;
	}
	
	public void setPMRCRating(String pmrcRating) {
		this.pmrcRating = pmrcRating;
	}
	
	public String getLength() {
		return length;
	}
	
	public void setLength(String length) {
		this.length = length;
	}
	
	public JSONObject toJSON(){
		JSONObject albumJson = new JSONObject();
		try {
			albumJson.put("title", this.title);
			albumJson.put("release_date", this.releaseDate);
			albumJson.put("cover_image_path", this.coverImagePath);
			albumJson.put("recording_company_name", this.recordingCompanyName);
			albumJson.put("number_of_tracks", this.numberOfTracks);
			albumJson.put("PMRC_rating", this.pmrcRating);
			albumJson.put("length", this.length);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return albumJson;
	}
}
