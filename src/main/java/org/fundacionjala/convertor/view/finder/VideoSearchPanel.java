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


import org.fundacionjala.convertor.utils.Style;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;


/**
 * Class FinderPanel.
 *
 * @author Abel Gustavo Mallcu Chiri.
 * @version 1.0
 */
public class VideoSearchPanel extends JPanel {
    protected JComboBox<String> frameRate;
    private JComboBox<String> aspectRatio;
    protected JComboBox<String> resolution;
    private JComboBox<String> videoCodec;
    private JComboBox<String> audioCodec;
    private JLabel labelFrameRate;
    private JLabel labelAspectRatio;
    private JLabel labelResolution;
    private JLabel labelVideoCodec;
    private JLabel labelAudioCodec;
    private JPanel container;
    private Style style;


    /**
     *
     */
    public VideoSearchPanel() {
        style = new Style();

        frameRate = new JComboBox<>(new String[]{"", "0", "24", "25", "27", "29", "30", "60"});
        aspectRatio = new JComboBox<>(new String[]{"", "4:3", "16:9", "16:10"});
        resolution = new JComboBox<>(new String[]{"", "320*240", "600*350", "624*480", "640*480",
                "740*480", "1280*720", "1920*1080", "2048*1080", "3840*2160", "4096*2160"});
        videoCodec = new JComboBox<>(new String[]{"", "MPEG4", "AAC", "H264",
                "AVS", "MJPEG", "VP7", "WMV"});
        audioCodec = new JComboBox<>(new String[]{"", "MP3", "WMAV2", "AAC", "PCM_S16LE"});

        labelFrameRate = new JLabel("Frame Rate :");
        labelAspectRatio = new JLabel("Aspect Ratio :");
        labelResolution = new JLabel("Resolution :");
        labelVideoCodec = new JLabel("Video Codec :");
        labelAudioCodec = new JLabel("Audio Codec :");


        frameRate.setFont(style.getFont());
        aspectRatio.setFont(style.getFont());
        resolution.setFont(style.getFont());
        videoCodec.setFont(style.getFont());
        audioCodec.setFont(style.getFont());
        labelFrameRate.setFont(style.getFont());
        labelAspectRatio.setFont(style.getFont());
        labelResolution.setFont(style.getFont());
        labelVideoCodec.setFont(style.getFont());
        labelAudioCodec.setFont(style.getFont());

        container = new JPanel(new GridBagLayout());

        this.setBackground(Color.WHITE);

        initComponents();
    }

    /**
     * Initialization of Components.
     */
    public void initComponents() {
        final int one = 1;
        final int two = 2;
        final int three = 3;


        this.setBackground(Color.WHITE);
        final Font font = new java.awt.Font("Tahoma", 0, 11);
        final Color orangeColor = new Color(255, 51, 0);
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.
                        createLineBorder(orangeColor), "Video Advanced Search",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                font, orangeColor));

        container.setBackground(Color.WHITE);

        GridBagConstraints bagConstraints = new GridBagConstraints();
        bagConstraints.insets = new Insets(1, 1, 1, 1);
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;

        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        labelFrameRate.setHorizontalAlignment(SwingConstants.RIGHT);
        container.add(labelFrameRate, bagConstraints);

        bagConstraints.gridx = one;
        bagConstraints.gridy = 0;
        container.add(frameRate, bagConstraints);

        bagConstraints.gridx = two;
        bagConstraints.gridy = 0;
        labelAspectRatio.setHorizontalAlignment(SwingConstants.RIGHT);
        container.add(labelAspectRatio, bagConstraints);

        bagConstraints.gridx = three;
        bagConstraints.gridy = 0;
        container.add(aspectRatio, bagConstraints);

        bagConstraints.gridx = 0;
        bagConstraints.gridy = one;
        labelResolution.setHorizontalAlignment(SwingConstants.RIGHT);

        container.add(labelResolution, bagConstraints);
        bagConstraints.gridx = one;
        bagConstraints.gridy = one;
        container.add(resolution, bagConstraints);

        bagConstraints.gridx = two;
        bagConstraints.gridy = one;
        labelVideoCodec.setHorizontalAlignment(SwingConstants.RIGHT);
        container.add(labelVideoCodec, bagConstraints);

        bagConstraints.gridx = three;
        bagConstraints.gridy = one;
        container.add(videoCodec, bagConstraints);

        bagConstraints.gridx = 0;
        bagConstraints.gridy = two;
        labelAudioCodec.setHorizontalAlignment(SwingConstants.RIGHT);
        container.add(labelAudioCodec, bagConstraints);

        bagConstraints.gridx = 1;
        bagConstraints.gridy = two;
        container.add(audioCodec, bagConstraints);
        this.add(container);
    }

    /**
     * @return value of the FrameRate JComboBox.
     */
    public JComboBox<String> getFrameRate() {
        return frameRate;
    }


    /**
     * @return value of the AspectRatio JComboBox.
     */
    public JComboBox<String> getAspectRatio() {
        return aspectRatio;
    }


    /**
     * @return value of the Resolution JComboBox.
     */
    public JComboBox<String> getResolution() {
        return resolution;
    }


    /**
     * @return value of the VideoCodec JComboBox.
     */
    public JComboBox<String> getVideoCodec() {
        return videoCodec;
    }


    /**
     * @return value of the AudioCodec JComboBox.
     */
    public JComboBox<String> getAudioCodec() {
        return audioCodec;
    }

    /**
     * @param audioCodec add of the FrameRate JComboBox.
     */
    public void setAudioCodec(final JComboBox<String> audioCodec) {
        this.audioCodec = audioCodec;
    }
}
