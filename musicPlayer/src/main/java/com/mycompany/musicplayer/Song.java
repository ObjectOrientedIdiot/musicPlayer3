
package com.mycompany.musicplayer;

import java.io.File;

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
