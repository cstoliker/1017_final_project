package cas363_final_project;
//import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.json.JSONArray;

public class ArtistManager {
	public void createArtist(String artistID, String firstName, String lastName, String bandName, String bio){
		EntityManagerFactory emFactory = 
				Persistence.createEntityManagerFactory("MusicJPAArtist");
		
		EntityManager em = emFactory.createEntityManager();
		
		em.getTransaction().begin();
		Artist a = new Artist();
		
		a.setArtistID(artistID);
		a.setFirstName(firstName);
		a.setLastName(lastName);
		a.setBandName(bandName);
		a.setBio(bio);
		
		// Add the Artist object to the ORM object grid
		em.persist(a);
		
		// Commit transaction
		em.getTransaction().commit();
		
		// Close connection to persistence manager
		em.close();
		emFactory.close();
	}
	
	public Artist getArtist(String artistID){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("MusicJPAArtist");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Artist a = em.find(Artist.class, artistID);
	
		em.close();
		emFactory.close();
		return a;
	}
	
	@SuppressWarnings("unchecked")
	public JSONArray getArtistList(){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("MusicJPAArtist");
		EntityManager em = emFactory.createEntityManager();

		List<String> artistIDs = em.createQuery("SELECT a.artistID FROM Artist a").getResultList();
		JSONArray artistListJSON = new JSONArray();
		for(String artistID : artistIDs){
			Artist a = em.find(Artist.class, artistID);
			artistListJSON.put(a.toJSON());
		}
		em.close();
		emFactory.close();
		
		return artistListJSON;
	}
	
	public void updateArtist(String artistID, String firstName, String lastName, String bandName, String bio){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("MusicJPAArtist");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Artist a = em.find(Artist.class, artistID);
		
		if(!firstName.equals("")) {
			a.setFirstName(firstName);
		}

		if(!lastName.equals("")) {
			a.setLastName(lastName);
		}
		
		if(!bandName.equals("")) {
			a.setBandName(bandName);
		}
		
		if(!bio.equals("")) {
			a.setBio(bio);
		}
		
		em.persist(a);
		em.getTransaction().commit();
		
		em.close();
		emFactory.close();
	}
	
	public void deleteArtist (int artistID){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("MusicJPAArtist");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Artist a = em.find(Artist.class, artistID);
		
		em.remove(a);
		em.getTransaction().commit();
		
		em.close();
		emFactory.close();
	}
}
