package org.fundacionjala.convertor.view;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MediaPlayerPanel extends JPanel {
  public static EmbeddedMediaPlayerComponent player;
  public static File file;

  public MediaPlayerPanel() {
    file = new File("C:\\Videos\\Terminator.mp4");
    player = new EmbeddedMediaPlayerComponent();
    iniMediaPlayer();
    createButtons();
  }

  private void iniMediaPlayer() {
    this.setMinimumSize(new Dimension(100, 100));
    this.setPreferredSize(new Dimension(460, 240));
    this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
    player.setSize(this.getSize());
    player.setVisible(true);
    this.add(player);
  }

  private void createButtons() {
    JButton btnStart = new JButton("[Start]");
    JButton btnPlayPause = new JButton("[Pause]");
    btnStart.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        player.getMediaPlayer().playMedia(file.getAbsolutePath());
      }
    });
    btnPlayPause.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        btnPlayPause.setText(player.getMediaPlayer().isPlaying() ? "[Play]" : "[Pause]");
        player.getMediaPlayer().setPause(player.getMediaPlayer().isPlaying() ? true : false);
      }
    });
    this.add(btnStart);
    this.add(btnPlayPause);
  }
}
