
package com.mycompany.musicplayer;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JSlider;

public class RTUpdater extends Thread {
    
    JSlider cInstance; //component being updated
    SongManager smInstance;
    Song selected;
    
    public RTUpdater(JSlider c, SongManager sm){
        this.cInstance = c;
        this.smInstance = sm;
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
            
            if((int)smInstance.getDuration() == (int)smInstance.getMaxDuration()) {
                selected = smInstance.getWorkspace().get(smInstance.getWorkspace().indexOf(selected) + 1);
                System.out.println("working");
            }
        }
    }
    
}
