
package com.mycompany.musicplayer;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.JSlider;

public class RTUpdater extends Thread {
    
    private JSlider cInstance; //component being updated
    private SongManager smInstance;
    private JList mList;
    private Song selected;
    
    public RTUpdater(JSlider c, SongManager sm, JList dp){
        this.cInstance = c;
        this.smInstance = sm;
        this.mList = dp;
    }
    
    @Override
    public void run(){ //Updates the song's duration every second
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(RTUpdater.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(!smInstance.clipReady()){continue;}
            cInstance.setValue((int)smInstance.getDuration());
            System.out.println(""+(int)smInstance.getDuration());
            
            if((int)smInstance.getDuration() == (int)smInstance.getMaxDuration()) { //current song ended
                smInstance.nextSong(mList); //plays next song
                
            }
        }
    }
    
}
