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
package org.fundacionjala.convertor.view.Converter;


import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class FinderPanel.
 *
 * @author Abel Gustavo Mallcu Chiri
 * @version 1.0
 */
public class ConverterPanel extends JPanel {
    private BasicConverterPanel basicConverterPanel;
    private AudioConverterPanel audioConverterPanel;
    private VideoConverterPanel videoConverterPanel;
    private ProgressBarPanel progressBarPanel;

    /**
     * Constructor.
     */
    public ConverterPanel() {
        TitledBorder title = BorderFactory.createTitledBorder("Converter");
        this.setBorder(title);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        basicConverterPanel = new BasicConverterPanel();
        this.add(basicConverterPanel);
        audioConverterPanel = new AudioConverterPanel();
        audioConverterPanel.setVisible(false);
        this.add(audioConverterPanel);
        videoConverterPanel = new VideoConverterPanel("Video Advanced Search");
        videoConverterPanel.setVisible(false);
        this.add(videoConverterPanel);
        progressBarPanel = new ProgressBarPanel();
        progressBarPanel.setVisible(false);
        this.add(progressBarPanel);
        basicConverterPanel.getMultimediaBox().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                String a = (String) basicConverterPanel.getMultimediaBox().getSelectedItem();
                if (a.equals("Video")) {
                    audioConverterPanel.setVisible(false);
                    videoConverterPanel.setVisible(true);
                    progressBarPanel.setVisible(true);
                }
                if (a.equals("Audio")) {
                    audioConverterPanel.setVisible(true);
                    videoConverterPanel.setVisible(false);
                    progressBarPanel.setVisible(true);
                }

            }
        });
        initComponents();
    }

    /**
     * Initialization of Components.
     */
    public void initComponents() {
    }

    /**
     * @return .
     */
    public BasicConverterPanel getBasicConverterPanel() {
        return basicConverterPanel;
    }

    /**
     * @return .
     */
    public AudioConverterPanel getAudioConverterPanel() {
        return audioConverterPanel;
    }

    /**
     * @return .
     */
    public VideoConverterPanel getVideoConverterPanel() {
        return videoConverterPanel;
    }

    /**
     * @return .
     */
    public ProgressBarPanel getProgressBarPanel() {
        return progressBarPanel;
    }
}
