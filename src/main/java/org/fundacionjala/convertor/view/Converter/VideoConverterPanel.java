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


import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;


/**
 * Class FinderPanel.
 *
 * @author Abel Mallcu Chiri.
 * @version 1.0
 */
public class VideoConverterPanel extends JPanel {


    private JComboBox<String> format;
    protected JComboBox<String> frameRate;
    private JComboBox<String> aspectRatio;
    protected JComboBox<String> resolution;
    private JComboBox<String> videoCodec;
    private JComboBox<String> audioCodec;
    private JComboBox<String> audioSampleRate;
    private JComboBox<String> audioBitRate;
    private JComboBox<String> audioChannels;

    private JLabel labelFormat;
    private JLabel labelFrameRate;
    private JLabel labelAspectRatio;
    private JLabel labelVideoCodec;
    private JLabel labelResolution;
    private JLabel labelAudioCodec;
    private JLabel labelAudioSampleRate;
    private JLabel labelBitRate;
    private JLabel labelAudioChannels;

    /**
     *
     */

    public VideoConverterPanel() {

        frameRate = new JComboBox<>(new String[]{"24", "25", "27", "29", "30", "60"});
        aspectRatio = new JComboBox<>(new String[]{"4:3", "12:5", "12:7", "17:9", "13:10"});
        resolution = new JComboBox<>(new String[]{"640*480", "320*240", "600*350", "624*480",
                "740*480", "1280*720", "1920*1080", "2048*1080", "3840*2160", "4096*2160"});
        videoCodec = new JComboBox<>(new String[]{"libx264"});
        audioCodec = new JComboBox<>(new String[]{"aac"});
        format = new JComboBox<>(new String[]{"avi"});
        audioSampleRate = new JComboBox<>(new String[]{"48000"});
        audioBitRate = new JComboBox<>(new String[]{"32768"});
        audioChannels = new JComboBox<>(new String[]{"1", "2"});
        labelFormat = new JLabel("Format :");
        labelFrameRate = new JLabel("Frame Rate :");
        labelAspectRatio = new JLabel("Aspect Ratio :");
        labelVideoCodec = new JLabel("Video Codec :");
        labelResolution = new JLabel("Resolution :");
        labelAudioCodec = new JLabel("Audio Codec :");
        labelAudioChannels = new JLabel("Audio Channels :");
        labelAudioSampleRate = new JLabel("Audio Sample Rate :");
        labelBitRate = new JLabel("Audio Bit Rate :");

        initComponents();
    }

    /**
     * Initialization of Components.
     */
    public void initComponents() {
        final int one = 1;
        final int two = 2;
        final int three = 3;
        final int four = 4;
        final Font font = new java.awt.Font("Tahoma", 0, 11);
        final Color orangeColor = new java.awt.Color(255, 51, 0);
        this.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.
                        createLineBorder(orangeColor), "Video Conveter",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                font, orangeColor));
        this.setLayout(new GridBagLayout());
        GridBagConstraints bagConstraints = new GridBagConstraints();


        bagConstraints.fill = GridBagConstraints.HORIZONTAL;

        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        this.add(labelFrameRate, bagConstraints);

        bagConstraints.gridx = one;
        bagConstraints.gridy = 0;
        this.add(frameRate, bagConstraints);

        bagConstraints.gridx = two;
        bagConstraints.gridy = 0;
        this.add(labelAspectRatio, bagConstraints);

        bagConstraints.gridx = three;
        bagConstraints.gridy = 0;
        this.add(aspectRatio, bagConstraints);

        bagConstraints.gridx = 0;
        bagConstraints.gridy = one;
        this.add(labelResolution, bagConstraints);

        bagConstraints.gridx = one;
        bagConstraints.gridy = one;
        this.add(resolution, bagConstraints);

        bagConstraints.gridx = two;
        bagConstraints.gridy = one;
        this.add(labelVideoCodec, bagConstraints);

        bagConstraints.gridx = three;
        bagConstraints.gridy = one;
        this.add(videoCodec, bagConstraints);

        bagConstraints.gridx = 0;
        bagConstraints.gridy = two;
        this.add(labelAudioCodec, bagConstraints);

        bagConstraints.gridx = one;
        bagConstraints.gridy = two;
        this.add(audioCodec, bagConstraints);

        bagConstraints.gridx = two;
        bagConstraints.gridy = two;
        this.add(labelFormat, bagConstraints);

        bagConstraints.gridx = three;
        bagConstraints.gridy = two;
        this.add(format, bagConstraints);

        bagConstraints.gridx = 0;
        bagConstraints.gridy = three;
        this.add(labelAudioSampleRate, bagConstraints);

        bagConstraints.gridx = one;
        bagConstraints.gridy = three;
        this.add(audioSampleRate, bagConstraints);

        bagConstraints.gridx = two;
        bagConstraints.gridy = three;
        this.add(labelBitRate, bagConstraints);

        bagConstraints.gridx = three;
        bagConstraints.gridy = three;
        this.add(audioBitRate, bagConstraints);

        bagConstraints.gridx = 0;
        bagConstraints.gridy = four;
        this.add(labelAudioChannels, bagConstraints);

        bagConstraints.gridx = one;
        bagConstraints.gridy = four;
        this.add(audioChannels, bagConstraints);
    }

    /**
     * @return .
     */
    public JComboBox<String> getFrameRate() {
        return frameRate;
    }


    /**
     * @return .
     */
    public JComboBox<String> getAspectRatio() {
        return aspectRatio;
    }


    /**
     * @return .
     */
    public JComboBox<String> getResolution() {
        return resolution;
    }


    /**
     * @return .
     */
    public JComboBox<String> getVideoCodec() {
        return videoCodec;
    }


    /**
     * @return .
     */
    public JComboBox<String> getAudioCodec() {
        return audioCodec;
    }

    /**
     * @return .
     */
    public JComboBox<String> getFormat() {
        return format;
    }

    /**
     * @return .
     */
    public JComboBox<String> getAudioSampleRate() {
        return audioSampleRate;
    }

    /**
     * @return .
     */
    public JComboBox<String> getAudioBitRate() {
        return audioBitRate;
    }

    /**
     * @return .
     */
    public JComboBox<String> getAudioChannels() {
        return audioChannels;
    }
}
