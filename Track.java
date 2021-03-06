/**
 * Store the details of a music track,
 * such as the artist, title, and file name.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class Track
{
    // The artist.
    private String artist;
    // The track's title.
    private String title;
    // Where the track is stored.
    private String filename;
        // El objetivo de este atributo es llevar la cuenta de las veces que se ha reproducido una canci�n.
    private int playCount;
    // indica el a�o de edicci�n del track.  ----------------0053
    private int anoEdit;

    /**
     * Constructor for objects of class Track.
     * @param artist The track's artist.
     * @param title The track's title.
     * @param filename The track file. 
     */
    public Track(String artist, String title, String filename)
    {
        setDetails(artist, title, filename);
        playCount = 0;
        anoEdit = 0;
    }
    
    /**
     * Constructor for objects of class Track.
     * It is assumed that the file name cannot be
     * decoded to extract artist and title details.
     * @param filename The track file. 
     */
    public Track(String filename)
    {
        setDetails("unknown", "unknown", filename);
    }
    
    /**
     * mt para contar las veces que se ha reproducido una canci�n. -------------------------  0052
     */
    public int vecesReproducida(){
         playCount ++;
         return  playCount;
    }
    
    /**
     * incrementa el contador de reproduciones en 1.�----------------------------------------  0052
     */
    public void sumaReproduciones(){
        playCount ++;
    }
    
    /**
     * para asignar un valor al at. anoEdit
     */
    public void setAnoEdicion(int anoE){
      if(anoE < 1916 || anoE > 2016){ 
          anoEdit = 1977;
      }
      else{
          anoEdit = anoE;
      }
    }
    
    /**
     * retorna el valor del at. anoEdit     ---------------------------------------------------0053
     */
    public int getAnoEdicion(){
        return anoEdit;
    }
    
    /**
     * pone el contador de reproduciones a cero
     */
    public void contadorR_0(){
        playCount = 0;
    }
    
    /**
     * Return the artist.
     * @return The artist.
     */
    public String getArtist()
    {
        return artist;
    }
    
    /**
     * Return the title.
     * @return The title.
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * Return the file name.
     * @return The file name.
     */
    public String getFilename()
    {
        return filename;
    }
        
    /**
     * Return details of the track: artist, title and file name.
     * @return The track's details.
     */
    public String getDetails()
    {
         return artist + ": " +title + " (file: " + filename + ").\n                            A�o de producci�n; " +
                            anoEdit+ " Veces reproducida: " +playCount ;
    }
    
    /**
     * Set details of the track.
     * @param artist The track's artist.
     * @param title The track's title.
     * @param filename The track file. 
     */
    private void setDetails(String artist, String title, String filename)
    {
        this.artist = artist;
        this.title = title;
        this.filename = filename;
    }
    
    
}






















