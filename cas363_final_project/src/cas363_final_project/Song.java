package cas363_final_project;

import java.sql.SQLException;

import javax.persistence.*;

import org.json.JSONException;
import org.json.JSONObject;

@Entity
@Table (name="song")

//I have this problem on all of my classes
//error: Class "cas363_final_project.Song" is managed, but is not listed in the persistence.xml file
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "song_id")
	private String songID;

	@Column(name = "title")
	private String title;
	
	@Column(name = "length")
	private String length;
	
	@Column(name = "file_path")
	private String filePath;

	@Column(name = "release_date")
	private String releaseDate;
	
	@Column(name = "record_date")
	private String recordDate;

	public String getSongId() {
		return songID;
	}
	
	public void setSongID(String songID){
		this.songID = songID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public String getReleaseDate() {
		return releaseDate;
	}
	
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public String getRecordDate() {
		return recordDate;
	}
	
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	
	public JSONObject toJSON(){
		JSONObject songJson = new JSONObject();
		try {
			songJson.put("song_id", this.songID);
			songJson.put("title", this.title);
			songJson.put("length", this.length);
			songJson.put("file_path", this.filePath);
			songJson.put("release_date", this.releaseDate);
			songJson.put("record_date", this.recordDate);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return songJson;
	}
}
