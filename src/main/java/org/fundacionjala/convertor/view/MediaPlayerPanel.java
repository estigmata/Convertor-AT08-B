/**
 *
 * @(#)MediaPlayerPanel.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * Please contact Fundacion Jala, 2643 Av Melchor Perez de Olguin, Colquiri
 * Sud, Cochabamba, Bolivia. www.fundacion-jala.org if you need additional
 * information or have any questions.
 *
 */

package org.fundacionjala.convertor.view;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 *
 * Class Media Player, class main container embedded media player component.
 *
 * @author Nestor Otondo [nestor.otondo@fundacion-jala.org]
 * @version 1.0
 *
 */
public class MediaPlayerPanel extends JPanel {
  private static EmbeddedMediaPlayerComponent player;
  private static File file;
  private static final int MIN_VALUE = 0;
  private static final int MAX_VALUE = 100;
  private static final int WIDTH = 460;
  private static final int HEIGHT = 240;

  /**
   *
   * Method constructor, initialize file, player, Media Player instance and create buttons.
   *
   */
  public MediaPlayerPanel() {
    file = new File("C:\\Videos\\Terminator.mp4");
    player = new EmbeddedMediaPlayerComponent();
    iniMediaPlayer();
    createButtons();
  }

  /**
   *
   * Setting values and player embedded component.
   *
   */
  private void iniMediaPlayer() {
    this.setMinimumSize(new Dimension(MAX_VALUE, MAX_VALUE));
    this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    player.setSize(this.getSize());
    player.setVisible(true);
    this.add(player);
  }

  /**
   *
   * Create and settings player control buttons.
   *
   */
  private void createButtons() {
    JPanel buttonsContainer = new JPanel();
    JButton btnStart = new JButton("[Start]");
    JButton btnPlayPause = new JButton("[Pause]");
    JToggleButton btnMute = new JToggleButton("[Mute]");
    btnMute.setFont(new Font("Tahoma", Font.PLAIN, 11));
    btnMute.setPreferredSize(new Dimension(75, 35));
    btnMute.setBorderPainted(false);
    btnMute.setForeground(new Color(255, 255, 255));
    btnMute.setBackground(new Color(102, 102, 102));
    JSlider sldVolume = new JSlider();
    sldVolume.setMinimum(MIN_VALUE);
    sldVolume.setMaximum(MAX_VALUE);
    sldVolume.setValue(MAX_VALUE);

    btnStart.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        player.getMediaPlayer().playMedia(file.getAbsolutePath());
      }
    });
    btnPlayPause.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        btnPlayPause.setText(player.getMediaPlayer().isPlaying() ? "[Play]" : "[Pause]");
        player.getMediaPlayer().setPause(player.getMediaPlayer().isPlaying() ? true : false);
      }
    });
    btnMute.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent actionEvent) {
        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
        player.getMediaPlayer().mute(abstractButton.getModel().isSelected());
      }
    });
    sldVolume.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(final ChangeEvent e) {

        Object source = e.getSource();
        player.getMediaPlayer().setVolume(((JSlider) source).getValue());
      }
    });

    buttonsContainer.setLayout(new BoxLayout(buttonsContainer, BoxLayout.LINE_AXIS));
    buttonsContainer.add(btnStart);
    buttonsContainer.add(btnPlayPause);
    buttonsContainer.add(btnMute);
    buttonsContainer.add(sldVolume);
    this.add(buttonsContainer, BorderLayout.CENTER);
  }
}
