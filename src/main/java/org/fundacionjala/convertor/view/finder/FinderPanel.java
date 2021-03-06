/*
 * @FinderPanel.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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
 */
package org.fundacionjala.convertor.view.finder;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class FinderPanel.
 *
 * @author Rodrigo Menacho
 * @author Abel Gustavo Mallcu Chiri.
 * @version 1.0
 */
public class FinderPanel extends JPanel {


    private BasicSearchPanel basicSearchPanel;
    private AudioSearchPanel audioSearchPanel;
    private VideoSearchPanel videoSearchPanel;

    /**
     * Constructor.
     */
    public FinderPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        basicSearchPanel = new BasicSearchPanel();
        this.add(basicSearchPanel);

        audioSearchPanel = new AudioSearchPanel();
        audioSearchPanel.setVisible(false);
        this.add(audioSearchPanel);

        videoSearchPanel = new VideoSearchPanel();
        videoSearchPanel.setVisible(false);
        this.add(videoSearchPanel);

        final Font font = new java.awt.Font("Tahoma", 0, 11);
        final Color orangeColor = new Color(255, 51, 0);

        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.
                        createLineBorder(orangeColor), "Search",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                font, orangeColor));

        basicSearchPanel.getMultimediaBox().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                String a = (String) basicSearchPanel.getMultimediaBox().getSelectedItem();
                if (a.equals("Video")) {
                    audioSearchPanel.setVisible(false);
                    videoSearchPanel.setVisible(true);
                }
                if (a.equals("Audio")) {
                    audioSearchPanel.setVisible(true);
                    videoSearchPanel.setVisible(false);
                }
                if (a.equals("All")) {
                    audioSearchPanel.setVisible(false);
                    videoSearchPanel.setVisible(false);

                }
            }
        });
        videoSearchPanel.getAspectRatio().addActionListener(x -> {
            String ratio = (String) videoSearchPanel.getAspectRatio().getSelectedItem();
            if (ratio.equals("4:3")) {
                videoSearchPanel.getResolution().removeAllItems();
                String[] resolution = {"", "640*480", "800*600", "960*720", "1024*768", "1280*960", "1400*1050",
                        "1440*1080", "1600*1200", "1856*1392", "1920*1440", "2048*1536"};
                videoSearchPanel.getResolution().setModel(new DefaultComboBoxModel<>(resolution));
            }
            if (ratio.equals("16:9")) {
                videoSearchPanel.getResolution().removeAllItems();
                String[] resolution = {"", "1024*576", "1152*648", "1280*720", "1366*768", "1600*900",
                        "1920*1080", "2560*1440", "3840*2160"};
                videoSearchPanel.getResolution().setModel(new DefaultComboBoxModel<>(resolution));
            }

            if (ratio.equals("16:10")) {
                videoSearchPanel.getResolution().removeAllItems();
                String[] resolution = {"", "1280*800", "1440*900", "1680*1050", "1920*1200", "2560*1600"};
                videoSearchPanel.getResolution().setModel(new DefaultComboBoxModel<>(resolution));
            }

        });
        initComponents();
    }

    /**
     * Initialization of Components.
     */
    public void initComponents() {
        this.setBackground(Color.WHITE);
    }

    /**
     * @return value of BasicSearchPanel  .
     */
    public BasicSearchPanel getBasicSearchPanel() {
        return basicSearchPanel;
    }


    /**
     * @return value of AudioSearchPanel.
     */
    public AudioSearchPanel getAudioSearchPanel() {
        return audioSearchPanel;
    }


    /**
     * @return value of VideoSearchPanel.
     */
    public VideoSearchPanel getVideoSearchPanel() {
        return videoSearchPanel;
    }


}
