/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.musicplayer;

import java.io.File;
import org.jaudiotagger.audio.AudioFile;

/**
 *
 * @author 1104691
 */
public class Song {
    
    protected File filePath;
    protected String fileType;
    protected String title;
    protected String[] artists;
    protected String genre;
    protected String album;
    protected int duration;
    protected int bitDepth;
    protected int sampleRate;
    
    public Song(File filePath){
        this.filePath = filePath;
    }
    
    public File getFile(){
        return filePath;
    }
    
}
