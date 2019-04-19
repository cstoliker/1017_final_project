package cas363_final_project;
//import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.json.JSONArray;
public class SongManager {
	public void createArtist(String songID, String title, String length, String filePath, String releaseDate, String recordDate){
		EntityManagerFactory emFactory = 
				Persistence.createEntityManagerFactory("MusicJPASong");
		
		EntityManager em = emFactory.createEntityManager();
		
		em.getTransaction().begin();
		Song s = new Song();
		
		s.setSongID(songID);
		s.setTitle(title);
		s.setLength(length);
		s.setFilePath(filePath);
		s.setReleaseDate(releaseDate);
		s.setRecordDate(recordDate);
		
		// Add the Song object to the ORM object grid
		em.persist(s);
		
		// Commit transaction
		em.getTransaction().commit();
		
		// Close connection to persistence manager
		em.close();
		emFactory.close();
	}
	
	public Song getSong(String songID){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("MusicJPASong");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Song s = em.find(Song.class, songID);
		
		em.close();
		emFactory.close();
		return s;
	}
	
	@SuppressWarnings("unchecked")
	public JSONArray getSongList(){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("MusicJPASong");
		EntityManager em = emFactory.createEntityManager();
		

		List<String> songIDs = em.createQuery("SELECT s.songID FROM Song s").getResultList();
		JSONArray songListJSON = new JSONArray();
		for(String songID : songIDs){
			Song s = em.find(Song.class, songID);
			songListJSON.put(s.toJSON());
		}
		em.close();
		emFactory.close();
		
		return songListJSON;
	}
	
	public void updateSong(String songID, String title, String length, String filePath, String releaseDate, String recordDate){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("MusicJPASong");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Song s = em.find(Song.class, songID);
		
		if(!title.equals("")) {
			s.setTitle(title);
		}

		if(!length.equals("")) {
			s.setLength(length);
		}
		
		if(!filePath.equals("")) {
			s.setFilePath(filePath);
		}
		
		if(!releaseDate.equals("")) {
			s.setReleaseDate(releaseDate);
		}
		
		if(!recordDate.equals("")) {
			s.setRecordDate(recordDate);
		}
		
		em.persist(s);
		em.getTransaction().commit();
		
		em.close();
		emFactory.close();
	}
	
	public void deleteSong (int songID){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("MusicJPASong");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Song s = em.find(Song.class, songID);
		
		em.remove(s);
		em.getTransaction().commit();
		
		em.close();
		emFactory.close();
	}
}
