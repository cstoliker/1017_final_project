# 1017_final_project
# Caleb Stoliker
# cas363

The project doesn't quite work and I can explain why. Currently the database isn't connected to the front end.  I think this is because I falled to do something with persistence.xml.  I have three errors in this project and they are all the same. Class is managed but not listed in the persistence.xml file.  As of now I'm not sure how to fix this.  That being said, I have finished the architecture for all three web services as well as the html interface and the abilitly to search via artists albums or songs(albeit the search doesn't work due to previously stated issues).

Secondly, I did implement an autocomplete that was working initially, however it failed once I imported jquery-3.4.0.min.

The folder should include:
  index.html
  Artist.java
  ArtistManager.java
  ArtistListWS.java
  Album.java
  AlbumManager.java
  AlbumListWS.java
  Song.java
  SongManager.java
  SongListWS.java
  DbUtilities.java
  style.css
  jquery-3.4.0.min
