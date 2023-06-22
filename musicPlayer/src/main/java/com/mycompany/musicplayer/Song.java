/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.musicplayer;

import java.io.File;

/**
 *
 * @author 1104691
 */
public class Song {
    
    protected File filePath;
    protected String name;
    
    public Song(File filePath){
        this.filePath = filePath;
        this.name = filePath.getName();
        
    }
    
    public File getFile(){
        return filePath;
    }
    
    @Override
    public String toString(){
        return name;
    }
    
}
