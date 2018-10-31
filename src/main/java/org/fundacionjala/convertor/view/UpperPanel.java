package org.fundacionjala.convertor.view;

import org.fundacionjala.convertor.utils.VLCMediaPlayer;
import org.fundacionjala.convertor.view.finder.FinderPanel;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


/**
 * Class of the upper panel who contais 3 panels.
 */
public class UpperPanel extends JPanel {
  private FinderPanel searchPanel;

  /**
   * Constructor for the initialization of the components.
   */
  public UpperPanel() {
    initComponents();

  }

  /**
   * Initialization of the components.
   */
  private void initComponents() {
    this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
//        Panel for the explorer
    JPanel explorer = new JPanel();
    explorer.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    explorer.setBackground(Color.RED);
    this.add(explorer);
//        Panel for the Search Panel
    searchPanel = new FinderPanel();
    searchPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    this.add(searchPanel);

    MediaPlayerPanel mediaPlayer = new MediaPlayerPanel();
    mediaPlayer.setPreferredSize(new Dimension(460, 240));
    mediaPlayer.setBackground(new Color(64, 64, 64));

    this.add(mediaPlayer);
  }

  public FinderPanel getSearchPanel() {
    return searchPanel;
  }
}
