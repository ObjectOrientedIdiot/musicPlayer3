/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.musicplayer;

import java.awt.Component;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.*;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.JFileChooser;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author 1104691
 */
public class SongManager {
    
    JFileChooser f;
    private File directory;
    private ArrayList<Song> workspace = new ArrayList<>();
    public float currentVolume = 37;
    Clip clip;
    FloatControl fc;
    
    private void loadFiles(final File root){
        for (final File fileEntry : root.listFiles()) {
            if (fileEntry.isDirectory()) {
                loadFiles(fileEntry);
            } else {
                if(!FilenameUtils.getExtension(fileEntry.getName()).equals("wav")){continue;}//only works with flac files for now. No:)
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
    
    public ArrayList<Song> getWorkspace(){
        return workspace;
    }
    
    public void playSong(Song s){ //play the song
        URL soundURL = getClass().getResource(s.toString());
        setFile(soundURL);
        play();
    }
    
    public SongManager(){
        f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        
    }
    
    public void setFile(URL url) {
        try {
            AudioInputStream sound = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(sound);
            fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
        }
        catch(Exception e) {
            System.out.println("can't find file bruh");
        }
    }
    public void play() {
            clip.setFramePosition(0);
            clip.start();
        }
    public void setVolume(float volume) {
        currentVolume = volume;
        fc.setValue(currentVolume);
    }
    
}
