/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.musicplayer;

import java.awt.Component;
import java.io.InputStream;
import java.nio.file.*;
import java.util.ArrayList;
import javax.swing.JFileChooser;

/**
 *
 * @author 1104691
 */
public class SongManager {
    
    JFileChooser f;
    private Path directory;
    private ArrayList<Song> workspace = new ArrayList<>(); //list of all songs to work with
    private ArrayList<Song> display = new ArrayList<>(); //list of displayed files
    
    public void setDirectory(Component parent){
        f.showOpenDialog(null);
        System.out.println(f.getSelectedFile());
    }
    
    public SongManager(){
        f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        
    }
    
    
}
