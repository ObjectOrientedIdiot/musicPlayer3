
package com.mycompany.musicplayer;

import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;

public class Frame extends javax.swing.JFrame {
    
    SongManager smInstance;
    Song selected;
    RTUpdater rtU;

    public Frame() {
        initComponents();
        setLocationRelativeTo(null);
        smInstance = new SongManager();
        rtU = new RTUpdater(rDurationSlider,smInstance,mList);
        rtU.start();
    }
    
    private void drawSongButtons(){
        String[] songNames = smInstance.getWorkspace().stream()
                .map(Song::toString)
                .toArray(String[]::new);
        
        mList.setModel(new DefaultComboBoxModel<>(songNames));
    }
    
    private void drawSongButtons(String search){
        String[] songNames = smInstance.getWorkspace().stream()
                .map(Song::toString)
                .filter(s->s.toLowerCase().contains(search.toLowerCase()))
                .toArray(String[]::new);
        
        mList.setModel(new DefaultComboBoxModel<>(songNames));
    }
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rFrame = new javax.swing.JPanel();
        rVolume = new javax.swing.JSlider();
        rDurationSlider = new javax.swing.JSlider();
        mFrame = new javax.swing.JPanel();
        mSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        mList = new javax.swing.JList<>();
        topMenu = new javax.swing.JMenuBar();
        jFileOptions = new javax.swing.JMenu();
        setFile = new javax.swing.JMenuItem();
        refreshFile = new javax.swing.JMenuItem();
        jPlaybackOptions = new javax.swing.JMenu();
        playPause = new javax.swing.JMenuItem();
        nextSong = new javax.swing.JMenuItem();
        prevSong = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        rFrame.setBackground(new java.awt.Color(255, 255, 255));
        rFrame.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        rVolume.setMaximum(6);
        rVolume.setMinimum(-80);
        rVolume.setValue(-37);
        rVolume.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rVolumeMouseReleased(evt);
            }
        });

        rDurationSlider.setValue(0);
        rDurationSlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rDurationSliderMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout rFrameLayout = new javax.swing.GroupLayout(rFrame);
        rFrame.setLayout(rFrameLayout);
        rFrameLayout.setHorizontalGroup(
            rFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rDurationSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rVolume, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        rFrameLayout.setVerticalGroup(
            rFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(rFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rDurationSlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rFrameLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(rVolume, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        mFrame.setBackground(new java.awt.Color(255, 255, 255));
        mFrame.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        mSearch.setText("Search Here");
        mSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                mSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                mSearchFocusLost(evt);
            }
        });
        mSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mSearchKeyReleased(evt);
            }
        });

        mList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "set your music directory to get started (Ctrl+O)" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        mList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mListMouseClicked(evt);
            }
        });
        mList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mListKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(mList);

        javax.swing.GroupLayout mFrameLayout = new javax.swing.GroupLayout(mFrame);
        mFrame.setLayout(mFrameLayout);
        mFrameLayout.setHorizontalGroup(
            mFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(mSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE))
                .addContainerGap())
        );
        mFrameLayout.setVerticalGroup(
            mFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                .addContainerGap())
        );

        topMenu.setRequestFocusEnabled(false);
        topMenu.setVerifyInputWhenFocusTarget(false);

        jFileOptions.setText("File");

        setFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        setFile.setText("Set File Path");
        setFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setFileActionPerformed(evt);
            }
        });
        jFileOptions.add(setFile);

        refreshFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        refreshFile.setText("Refresh");
        refreshFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshFileActionPerformed(evt);
            }
        });
        jFileOptions.add(refreshFile);

        topMenu.add(jFileOptions);

        jPlaybackOptions.setText("Playback");

        playPause.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_SPACE, 0));
        playPause.setText("Play/Pause");
        playPause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                playPauseMousePressed(evt);
            }
        });
        jPlaybackOptions.add(playPause);

        nextSong.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_RIGHT, 0));
        nextSong.setText("Next Song");
        nextSong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nextSongMousePressed(evt);
            }
        });
        jPlaybackOptions.add(nextSong);

        prevSong.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_LEFT, 0));
        prevSong.setText("Previous Song");
        prevSong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                prevSongMousePressed(evt);
            }
        });
        jPlaybackOptions.add(prevSong);

        topMenu.add(jPlaybackOptions);

        setJMenuBar(topMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setFileActionPerformed
        smInstance.setDirectory(jFileOptions);
        drawSongButtons();
    }//GEN-LAST:event_setFileActionPerformed

    private void rVolumeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rVolumeMouseReleased
        try {
            smInstance.setVolume(rVolume.getValue());
        }
        catch(Exception e) {
            System.out.println("No Song Selected!");
        }
    }//GEN-LAST:event_rVolumeMouseReleased

    private void mListKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mListKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_SPACE ) {
            smInstance.pauseOrResume();
        }
        if(evt.getKeyCode() == KeyEvent.VK_LEFT ) {
            smInstance.prevSong(mList);
        }
        if(evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            smInstance.nextSong(mList);
        }
    }//GEN-LAST:event_mListKeyReleased

    private void rDurationSliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rDurationSliderMouseReleased
        if(selected != null) {
            smInstance.setDuration(rDurationSlider.getValue());
        }
    }//GEN-LAST:event_rDurationSliderMouseReleased

    private void mListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mListMouseClicked
        try { //Gets the selected file and plays the song.
            selected = smInstance.getSongFromName(mList.getSelectedValue());
            System.out.println(selected);
            smInstance.playSong(selected);
            rDurationSlider.setMaximum((int)smInstance.getMaxDuration());
            rDurationSlider.setValue(0);
        }
        catch(Exception e) {
            e.printStackTrace(System.out);
        }
    }//GEN-LAST:event_mListMouseClicked

    private void mSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mSearchKeyReleased
        drawSongButtons(mSearch.getText());
    }//GEN-LAST:event_mSearchKeyReleased

    private void mSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mSearchFocusGained
        mSearch.setText("");
    }//GEN-LAST:event_mSearchFocusGained

    private void mSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mSearchFocusLost
        mSearch.setText("Search Here");
    }//GEN-LAST:event_mSearchFocusLost

    private void refreshFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshFileActionPerformed
        smInstance.refresh();
    }//GEN-LAST:event_refreshFileActionPerformed

    private void playPauseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playPauseMousePressed
        smInstance.pauseOrResume();
    }//GEN-LAST:event_playPauseMousePressed

    private void nextSongMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextSongMousePressed
        smInstance.nextSong(mList);
    }//GEN-LAST:event_nextSongMousePressed

    private void prevSongMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prevSongMousePressed
        smInstance.prevSong(mList);
    }//GEN-LAST:event_prevSongMousePressed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jFileOptions;
    private javax.swing.JMenu jPlaybackOptions;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mFrame;
    private javax.swing.JList<String> mList;
    private javax.swing.JTextField mSearch;
    private javax.swing.JMenuItem nextSong;
    private javax.swing.JMenuItem playPause;
    private javax.swing.JMenuItem prevSong;
    private javax.swing.JSlider rDurationSlider;
    private javax.swing.JPanel rFrame;
    private javax.swing.JSlider rVolume;
    private javax.swing.JMenuItem refreshFile;
    private javax.swing.JMenuItem setFile;
    private javax.swing.JMenuBar topMenu;
    // End of variables declaration//GEN-END:variables
}
