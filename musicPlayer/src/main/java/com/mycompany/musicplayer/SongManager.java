/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.musicplayer;

import java.awt.Component;
import java.io.File;
import java.io.InputStream;
import java.nio.file.*;
import java.util.ArrayList;
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
    
    private void loadFiles(final File root){
        for (final File fileEntry : root.listFiles()) {
            if (fileEntry.isDirectory()) {
                loadFiles(fileEntry);
            } else {
                if(!FilenameUtils.getExtension(fileEntry.getName()).equals("flac")){continue;}//only works with flac files for now
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
    
    public void playSong(Song s){
        //play the song
    }
    
    public SongManager(){
        f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        
    }
    
    
}
