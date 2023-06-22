/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.musicplayer;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JSlider;

/**
 *
 * @author thesi
 */
public class RTUpdater extends Thread {
    
    JSlider cInstance; //component being updated
    SongManager smInstance;
    
    public RTUpdater(JSlider c, SongManager sm){
        this.cInstance = c;
        this.smInstance = sm;
    }
    
    @Override
    public void run(){
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(RTUpdater.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(!smInstance.clipReady()){continue;}
            cInstance.setValue((int)smInstance.getDuration());
            System.out.println(""+(int)smInstance.getDuration());
        }
    }
    
}
