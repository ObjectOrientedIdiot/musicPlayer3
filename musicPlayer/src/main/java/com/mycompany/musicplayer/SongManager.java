
package com.mycompany.musicplayer;

import java.awt.Component;
import java.io.File;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.JFileChooser;
import org.apache.commons.io.FilenameUtils;

public class SongManager {
    
    JFileChooser f;
    private File directory;
    private ArrayList<Song> workspace = new ArrayList<>();
    private float currentVolume = -37;
    boolean paused = false;
    Clip clip;
    FloatControl fc;
    
    private void loadFiles(final File root){
        for (final File fileEntry : root.listFiles()) {
            if (fileEntry.isDirectory()) {
                loadFiles(fileEntry);
            } else {
                if(!FilenameUtils.getExtension(fileEntry.getName()).equals("wav")){continue;}// No:)
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
    
    public ArrayList<Song> getWorkspace(){
        return workspace;
    }
    
    public Song getSongFromName(String name){
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
        play();
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
            System.out.println("No Song Selected!");
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
