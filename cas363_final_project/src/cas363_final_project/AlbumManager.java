package cas363_final_project;
//import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.json.JSONArray;
public class AlbumManager {
	public void createAlbum(String albumID, String title, String coverImagePath, 
			String recordingCompanyName, String numberOfTracks, String pmrcRating, String length){
		EntityManagerFactory emFactory = 
				Persistence.createEntityManagerFactory("MusicJPAAlbum");
		
		EntityManager em = emFactory.createEntityManager();
		
		em.getTransaction().begin();
		Album a = new Album();
		
		a.setAlbumID(albumID);
		a.setTitle(title);
		a.setCoverImagePath(coverImagePath);
		a.setRecordingCompanyName(recordingCompanyName);
		a.setNumberOfTracks(numberOfTracks);
		a.setPMRCRating(pmrcRating);
		a.setLength(length);
		
		// Add the Album object to the ORM object grid
		em.persist(a);
		
		// Commit transaction
		em.getTransaction().commit();
		
		// Close connection to persistence manager
		em.close();
		emFactory.close();
	}
	
	public Album getAlbum(String albumID){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("MusicJPAAlbum");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Album a = em.find(Album.class, albumID);
		
		
		
		em.close();
		emFactory.close();
		return a;
	}
	
	@SuppressWarnings("unchecked")
	public JSONArray getAlbumList(){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("MusicJPAAlbum");
		EntityManager em = emFactory.createEntityManager();
		

		List<String> albumIDs = em.createQuery("SELECT a.albumID FROM Album a").getResultList();
		JSONArray albumListJSON = new JSONArray();
		for(String albumID : albumIDs){
			Album a = em.find(Album.class, albumID);
			albumListJSON.put(a.toJSON());
		}
		em.close();
		emFactory.close();
		
		return albumListJSON;
	}
	
	public void updateAlbum(String albumID, String title, String coverImagePath, 
			String recordingCompanyName, String numberOfTracks, String pmrcRating, String length){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("MusicJPAAlbum");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Album a = em.find(Album.class, albumID);
		
		if(!title.equals("")) {
			a.setTitle(title);
		}

		if(!coverImagePath.equals("")) {
			a.setCoverImagePath(coverImagePath);
		}
		
		if(!recordingCompanyName.equals("")) {
			a.setRecordingCompanyName(recordingCompanyName);
		}
		
		if(!numberOfTracks.equals("")) {
			a.setNumberOfTracks(numberOfTracks);
		}
		
		if(!pmrcRating.equals("")) {
			a.setPMRCRating(pmrcRating);
		}
		
		if(!length.equals("")) {
			a.setLength(length);
		}
		
		em.persist(a);
		em.getTransaction().commit();
		
		em.close();
		emFactory.close();
	}
	
	public void deleteAlbum (int albumID){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("MusicJPAAlbum");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Album a = em.find(Album.class, albumID);
		
		em.remove(a);
		em.getTransaction().commit();
		
		em.close();
		emFactory.close();
	}
}
