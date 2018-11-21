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


import org.fundacionjala.convertor.utils.Style;

import javax.swing.DefaultComboBoxModel;
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
    private Style style;

    /**
     *
     */

    public VideoConverterPanel() {
        style = new Style();
        frameRate = new JComboBox<>(new String[]{"24", "25", "27", "29", "30", "60"});
        aspectRatio = new JComboBox<>(new String[]{"4:3", "16:9", "16:10"});
        resolution = new JComboBox<>(new String[]{"640*480", "320*240", "600*350", "624*480",
                "740*480", "1280*720", "1920*1080", "2048*1080", "3840*2160", "4096*2160"});
        videoCodec = new JComboBox<>(new String[]{"libx264", "flv", "mpeg2video", "mpeg4", "h261", "h263", "rawvideo",
                "libvpx", "wmv2"});
        audioCodec = new JComboBox<>(new String[]{"aac", "mp2", "wmav1", "wmav2", "flac"});
        format = new JComboBox<>(new String[]{"mp4", "mpeg", "avi", "mov", "wmv", "flv", "vob", "mxf"});
        audioSampleRate = new JComboBox<>(new String[]{"22050", "44100", "48000"});
        audioBitRate = new JComboBox<>(new String[]{"32", "96", "128", "192", "256", "320"});
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


        format.setFont(style.getFont());
        frameRate.setFont(style.getFont());
        aspectRatio.setFont(style.getFont());
        resolution.setFont(style.getFont());
        videoCodec.setFont(style.getFont());
        audioCodec.setFont(style.getFont());
        audioSampleRate.setFont(style.getFont());
        audioBitRate.setFont(style.getFont());
        audioChannels.setFont(style.getFont());

        labelFormat.setFont(style.getFont());
        labelFrameRate.setFont(style.getFont());
        labelAspectRatio.setFont(style.getFont());
        labelVideoCodec.setFont(style.getFont());
        labelResolution.setFont(style.getFont());
        labelAudioCodec.setFont(style.getFont());
        labelAudioSampleRate.setFont(style.getFont());
        labelBitRate.setFont(style.getFont());
        labelAudioChannels.setFont(style.getFont());

        aspectRatio.addActionListener(x -> {
            String ratio = (String) aspectRatio.getSelectedItem();
            if (ratio.equals("4:3")) {
                String[] resolutionItem = {"320*240", "640*480", "800*600", "960*720", "1024*768", "1280*960",
                        "1400*1050", "1440*1080", "1600*1200", "1856*1392", "1920*1440", "2048*1536"};
                resolution.setModel(new DefaultComboBoxModel<>(resolutionItem));
            }
            if (ratio.equals("16:9")) {
                String[] resolutionItem = {"1024*576", "1152*648", "1280*720", "1366*768", "1600*900",
                        "1920*1080", "2560*1440", "3840*2160"};
                resolution.setModel(new DefaultComboBoxModel<>(resolutionItem));
            }

            if (ratio.equals("16:10")) {
                String[] resolutionItem = {"1280*800", "1440*900", "1680*1050", "1920*1200", "2560*1600"};
                resolution.setModel(new DefaultComboBoxModel<>(resolutionItem));
            }

        });
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
        labelFrameRate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        this.add(labelFrameRate, bagConstraints);

        bagConstraints.gridx = one;
        bagConstraints.gridy = 0;
        this.add(frameRate, bagConstraints);

        bagConstraints.gridx = two;
        bagConstraints.gridy = 0;
        labelAspectRatio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        this.add(labelAspectRatio, bagConstraints);

        bagConstraints.gridx = three;
        bagConstraints.gridy = 0;
        this.add(aspectRatio, bagConstraints);

        bagConstraints.gridx = 0;
        bagConstraints.gridy = one;
        labelResolution.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        this.add(labelResolution, bagConstraints);

        bagConstraints.gridx = one;
        bagConstraints.gridy = one;
        this.add(resolution, bagConstraints);

        bagConstraints.gridx = two;
        bagConstraints.gridy = one;
        labelVideoCodec.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        this.add(labelVideoCodec, bagConstraints);

        bagConstraints.gridx = three;
        bagConstraints.gridy = one;
        this.add(videoCodec, bagConstraints);

        bagConstraints.gridx = 0;
        bagConstraints.gridy = two;
        labelAudioCodec.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        this.add(labelAudioCodec, bagConstraints);

        bagConstraints.gridx = one;
        bagConstraints.gridy = two;
        this.add(audioCodec, bagConstraints);

        bagConstraints.gridx = two;
        bagConstraints.gridy = two;
        labelFormat.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        this.add(labelFormat, bagConstraints);

        bagConstraints.gridx = three;
        bagConstraints.gridy = two;
        this.add(format, bagConstraints);

        bagConstraints.gridx = 0;
        bagConstraints.gridy = three;
        labelAudioSampleRate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        this.add(labelAudioSampleRate, bagConstraints);

        bagConstraints.gridx = 1;
        bagConstraints.gridy = three;
        this.add(audioSampleRate, bagConstraints);

        bagConstraints.gridx = 2;
        bagConstraints.gridy = three;
        labelBitRate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        this.add(labelBitRate, bagConstraints);

        bagConstraints.gridx = three;
        bagConstraints.gridy = three;
        this.add(audioBitRate, bagConstraints);

        bagConstraints.gridx = 0;
        bagConstraints.gridy = four;
        labelAudioChannels.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        this.add(labelAudioChannels, bagConstraints);

        bagConstraints.gridx = 1;
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
     * Getter of the ComboBox - Audio Sample Rate.
     *
     * @return the JComboBox.
     */
    public JComboBox<String> getAudioSampleRate() {
        return audioSampleRate;
    }

    /**
     * Getter of the ComboBox - Audio Bit rate.
     *
     * @return the JComboBox.
     */
    public JComboBox<String> getAudioBitRate() {
        return audioBitRate;
    }

    /**
     * Getter of the ComboBox - Audio Channels.
     *
     * @return the JComboBox.
     */
    public JComboBox<String> getAudioChannels() {
        return audioChannels;
    }
}
