/**
 * @(#)MediaPlayerPanel.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * <p>
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE filePath that
 * accompanied this code).
 * <p>
 * Please contact Fundacion Jala, 2643 Av Melchor Perez de Olguin, Colquiri
 * Sud, Cochabamba, Bolivia. www.fundacion-jala.org if you need additional
 * information or have any questions.
 */

package org.fundacionjala.convertor.view;

import org.fundacionjala.convertor.utils.Validator;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Class Media Player, class main container embedded media player component.
 *
 * @author Nestor Otondo [nestor.otondo@fundacion-jala.org]
 * @author Abel Gustavo Mallcu Chiri.
 * @version 1.0
 */
public class MediaPlayerPanel extends JPanel {
    private static EmbeddedMediaPlayerComponent player;
    private static String filePath;
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 100;
    private static final int WIDTH = 350;
    private static final int HEIGHT = 240;
    private Validator validator;

    /**
     * Method constructor, initialize player, Media Player instance and create buttons.
     */
    public MediaPlayerPanel() {
        validator = new Validator();
        player = new EmbeddedMediaPlayerComponent();
        iniMediaPlayer();
        createButtons();
    }

    /**
     * Setting values and player embedded component.
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
     * Create and settings player control buttons.
     */
    private void createButtons() {
        JPanel buttonsContainer = new JPanel();
        JButton btnStart = new JButton();
        JButton btnPlayPause = new JButton();
        JToggleButton btnMute = new JToggleButton();
        btnStart.setBackground(Color.WHITE);
        btnPlayPause.setBackground(Color.WHITE);
        btnMute.setBackground(Color.WHITE);

        btnStart.setIcon(new javax.swing.ImageIcon("Image\\start.PNG"));
        btnPlayPause.setIcon(new javax.swing.ImageIcon("Image\\pause.PNG"));
        btnMute.setIcon(new javax.swing.ImageIcon("Image\\audio.PNG"));

        JSlider sldVolume = new JSlider();
        sldVolume.setMinimum(MIN_VALUE);
        sldVolume.setMaximum(MAX_VALUE);
        sldVolume.setValue(MAX_VALUE);

        btnStart.addActionListener(e -> {
            Path path = Paths.get(filePath);
            if (validator.isAudio(path) || validator.isVideo(path)) {
                player.getMediaPlayer().playMedia(filePath);
            } else {
                new ErrorMessage("Non-Multimedia file !!!");
            }

        });
        btnPlayPause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                // btnPlayPause.setText(player.getMediaPlayer().isPlaying() ? "[Play]" : "[Pause]");

                if (player.getMediaPlayer().isPlaying()) {
                    btnPlayPause.setIcon(new javax.swing.ImageIcon("Image\\pause.PNG"));
                } else {
                    btnPlayPause.setIcon(new javax.swing.ImageIcon("Image\\play.PNG"));
                }
                player.getMediaPlayer().setPause(player.getMediaPlayer().isPlaying());
            }
        });
        btnMute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
                btnMute.setIcon(new javax.swing.ImageIcon("Image\\mute.PNG"));
                player.getMediaPlayer().mute(abstractButton.getModel().isSelected());


            }
        });
        sldVolume.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(final ChangeEvent e) {

                Object source = e.getSource();
                btnMute.setIcon(new javax.swing.ImageIcon("Image\\audio.PNG"));
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

    /**
     * Setter for reproduce the video.
     *
     * @param filePath input File
     */
    public static void setFilePath(final String filePath) {
        MediaPlayerPanel.filePath = filePath;
    }
}
