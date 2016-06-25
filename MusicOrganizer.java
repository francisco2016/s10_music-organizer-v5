import java.util.ArrayList;
import java.util.Iterator;

/**
 * A class to hold details of audio tracks.
 * Individual tracks may be played.
 * 
 * @author David J. Barnes and Michael KÃ¶lling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing music tracks.
    private ArrayList<Track> tracks;
    // A player for the music tracks.
    private MusicPlayer player;
    // A reader that can read music files and load them as tracks.
    private TrackReader reader;
    // informe por pantalla de si está reproduciendo un track completo o si no. --------------------------- 0054
    private boolean estaRepro;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        tracks = new ArrayList<Track>();
        player = new MusicPlayer();
        reader = new TrackReader();
        estaRepro = false;      //--------------------------- 0054
        readLibrary("audio");
        System.out.println("Music library loaded. " + getNumberOfTracks() + " tracks.");
        System.out.println();
    }

    /**
     * Add a track file to the collection.
     * @param filename The file name of the track to be added.
     */
    public void addFile(String filename)
    {
        tracks.add(new Track(filename));
    }

    /**
     * añade un método a la clase MusicOrganizer llamado findInTitle que tome un único parámetro de tipo String y
     * muestre por pantalla la información de los tracks que contienen dicha cadena en el título de la canción.
     * -------------------------------------------------------------------------------------------------------------  0052
     */
    public void findInTitle(String cadena){//necesitamos un for para recorrer la colección de trakc.
        for(Track track: tracks){
            if(track.getTitle().contains(cadena)){
                System.out.println(track.getDetails());
            }
        }
    }

    /**
     *para poder fijar el valor del atributo anoEdit de la cl Track a un determinado track del organizador.
     * --------------------------------------------------------------------------------------------------------------- 0053
     */
    public void setAnoEdit2(int index, int anoEdicion){
        tracks.get(index).setAnoEdicion(anoEdicion);
    }

    /**
     * isPlaying que cuando sea invocado informe por pantalla de si en este momento se está reproduciendo un track completo o no 
     * --------------------------------------------------------------------------------------------------------------- 00 54
     */
    public void isPlaying(){
        if(estaRepro == true){
            System.out.println("--                              --.");
            System.out.println("En este momento se está reproduciendo uno de los tracks.");
        }
        else{
            System.out.println("--                              --.");
            System.out.println("En este momento no se está reproduciendo ninguno de los tracks.");
        }
    }
    
    /**
     * que muestre los detalles de todos los tracks almacenados en un organizador usando un iterador. ---------------- 0055
     */
    public void listAllTrackWithIterator(){
        Iterator<Track> it = tracks.iterator();
        while(it.hasNext()){
            Track a = it.next();
            System.out.println("--          --");
            System.out.println(a.getDetails());
        }
    }
    
    /**
     *  que permita eliminar del organizador los tracks que contengan un determinado artista usando un iterador. ------- 0055
     */
    public void removeByArtist(String nameArtist){
        Iterator<Track> it = tracks.iterator();
        while(it.hasNext()){
            Track a = it.next();
            if(a.getArtist().contains(nameArtist)){
                it.remove();
            }
        }
    }
    
    /**
     *permita eliminar del organizador los tracks que contengan una determinada cadena en el título de la canción
     *usando un iterador.  ---------------------------------------------------------------------------------------- 0055
     */
    public void removeByTitle(String songTitle){
        Iterator<Track> it = tracks.iterator();
        while(it.hasNext()){
            Track a = it.next();
            if(a.getTitle().contains(songTitle)){
                it.remove();
            }
        }
    }
    
    /**
     * Add a track to the collection.
     * @param track The track to be added.
     */
    public void addTrack(Track track)
    {
        tracks.add(track);
    }

    /**
     * Play a track in the collection.
     * @param index The index of the track to be played.
     */
    public void playTrack(int index)
    {
        if(estaRepro == false){
            if(indexValid(index)) {
                Track track = tracks.get(index);
                player.startPlaying(track.getFilename());
                estaRepro = true;
                System.out.println("Now playing: " + track.getArtist() + " - " + track.getTitle()
                    + " Nº de veces escuchado: " +track.vecesReproducida());
            }
        }
        else{
            System.out.println("--                              --.");
            System.out.println("Error, ya tenemos un track reproduciendose. ");
        }

    }

    /**
     * Play the first track in the collection, if there is one.
     */
    public void playFirst()
    {
        if(estaRepro == false){
            if(tracks.size() > 0) {
                player.startPlaying(tracks.get(0).getFilename());
                tracks.get(0).vecesReproducida();
                estaRepro = true;
            }
        }
        else{
            System.out.println("--                              --.");
            System.out.println("Error, ya tenemos un track reproduciendose. ");
        }
    }

    /**
     * Return the number of tracks in the collection.
     * @return The number of tracks in the collection.
     */
    public int getNumberOfTracks()
    {
        return tracks.size();
    }

    /**
     * List a track from the collection.
     * @param index The index of the track to be listed.
     */
    public void listTrack(int index)
    {
        System.out.print("Track " + index + ": ");
        Track track = tracks.get(index);
        System.out.println(track.getDetails()  );
    }

    /**
     * Show a list of all the tracks in the collection.
     */
    public void listAllTracks()
    {
        System.out.println("Track listing: ******************** ");
        System.out.println();

        for(Track track : tracks) {
            System.out.println(track.getDetails() );
        }
        System.out.println();
    }

    /**
     * List all tracks by the given artist.
     * @param artist The artist's name.
     */
    public void listByArtist(String artist)
    {
        for(Track track : tracks) {
            if(track.getArtist().contains(artist)) {
                System.out.println(track.getDetails());
            }
        }
    }

    /**
     * Remove a track from the collection.
     * @param index The index of the track to be removed.
     */
    public void removeTrack(int index)
    {
        if(indexValid(index)) {
            tracks.remove(index);
        }
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
        estaRepro = false;
    }

    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean indexValid(int index)
    {
        // The return value.
        // Set according to whether the index is valid or not.
        boolean valid;

        if(index < 0) {
            System.out.println("Index cannot be negative: " + index);
            valid = false;
        }
        else if(index >= tracks.size()) {
            System.out.println("Index is too large: " + index);
            valid = false;
        }
        else {
            valid = true;
        }
        return valid;
    }

    private void readLibrary(String folderName)
    {
        ArrayList<Track> tempTracks = reader.readTracks(folderName, ".mp3");

        // Put all thetracks into the organizer.
        for(Track track : tempTracks) {
            addTrack(track);
        }
    }
}
