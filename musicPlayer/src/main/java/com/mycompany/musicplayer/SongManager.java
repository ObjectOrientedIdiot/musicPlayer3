
package com.mycompany.musicplayer;

import java.awt.Component;
import java.io.File;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.JFileChooser;
import javax.swing.JList;
import org.apache.commons.io.FilenameUtils;

public class SongManager {
    
    JFileChooser f;
    private File directory;
    private ArrayList<Song> workspace = new ArrayList<>();
    private float currentVolume = -37;
    private boolean paused = false;
    private Song currentSong;
    Clip clip;
    FloatControl fc;
    
    private void loadFiles(final File root){ //loads songs in a given directory into workspace as Songs
        for (final File fileEntry : root.listFiles()) {
            if (fileEntry.isDirectory()) {
                loadFiles(fileEntry);
            } else {
                if(!FilenameUtils.getExtension(fileEntry.getName()).equals("wav")){continue;} //can only be wav because we stupid
                Song s = new Song(fileEntry);
                workspace.add(s);
            }
        }
        System.out.println(workspace);
    }
    
    public void setDirectory(Component parent){
        f.showOpenDialog(null);
        directory = f.getSelectedFile();
        loadFiles(directory);
        System.out.println(f.getSelectedFile());
    }
    
    public void refresh(){
        loadFiles(directory);
    }
    
    public ArrayList<Song> getWorkspace(){ //returns workspace
        return workspace;
    }
    
    public Song getSongFromName(String name){ //returns song from workspace corresponding to the name of the file
        for(Song s: workspace){
            if(s.getFile().getName().equals(name)){
                return s;
            }
        }
        System.out.println(workspace);
        return (null);
    }
    
    public void playSong(Song s){ //play the song
        if(clip != null) {
            clip.stop();
        }
        setFile(s.getFile());
        currentSong = s;
        play();
    }
    
    public Song nextSong(JList mList){ //advances to the next song, returns next song played
        int currentSongIndex = workspace.indexOf(currentSong)+1;
        Song s = workspace.get(currentSongIndex >= workspace.size() ? 0 : currentSongIndex);
        playSong(s);
        int nextIndex = mList.getSelectedIndex()+1; //next index of mList
        mList.setSelectedIndex(nextIndex>=mList.getModel().getSize() ? 0 : nextIndex); //sets selected to next index
        return s;
    }
    
    public Song prevSong(JList mList){ //goes to the previous song, returns previous song played
        int prevSongIndex = workspace.indexOf(currentSong)-1;
        Song s = workspace.get(prevSongIndex < 0  ? workspace.size()-1 : prevSongIndex);
        playSong(s);
        int prevIndex = mList.getSelectedIndex()-1; //next index of mList
        mList.setSelectedIndex(prevIndex<0 ? mList.getModel().getSize()-1 : prevIndex); //sets selected to previous index
        return s;
    }
    
    public SongManager(){
        f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        
    }
    
    public void setFile(File file) { //Sets the file to the controller
        try {
            AudioInputStream sound = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(sound);
            fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
        }
        catch(Exception e) {
            e.printStackTrace(System.out);
        }
    }
    public void play() { //Plays the song
        clip.setFramePosition(0);
        clip.start();
        fc.setValue(currentVolume);
    }

    
    public void pauseOrResume() { //Pauses or resumes the song
        try {
            if(paused == false) {
                clip.stop();
                paused = true;
            }
            else {
                clip.start();
                paused = false;
            }
        }
        catch(Exception e) {
            e.printStackTrace(System.out);
        }
    }
    
    public void setVolume(float volume) { //Sets the song's volume to the given value
        currentVolume = volume;
        fc.setValue(currentVolume);
    }
    
    public double getDuration() { //Returns the song's current duration
        return clip.getFramePosition();
    }
    
    public double getMaxDuration() { //Returns the song's maximum duration
        return clip.getFrameLength();
    }
    
    public void setDuration(int value) { //Sets the song duration to the given value
        clip.setFramePosition(value);
    }

    public boolean clipReady(){
        return !(clip == null);
    }
    
}
