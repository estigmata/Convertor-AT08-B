/*
 * @Information.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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

package org.fundacionjala.convertor.view.dynamicpanel;

import org.fundacionjala.convertor.model.objectfile.Asset;
import org.fundacionjala.convertor.model.objectfile.AudioFileAsset;
import org.fundacionjala.convertor.model.objectfile.VideoFileAsset;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

/**
 * This class is the panel of the information.
 */
public class Information extends JPanel {
    private static JLabel path;
    private static JLabel size;
    private static JLabel extension;

    private static JLabel videoCodec;
    private static JLabel resolution;
    private static JLabel aspectRatio;
    private static JLabel frameRate;

    private static JLabel audioCodec;
    private static JLabel channels;

    private JLabel pathLabel;
    private JLabel sizeLabel;
    private JLabel extensionLabel;

    private static JLabel videoCodecLabel;
    private static JLabel resolutionLabel;
    private static JLabel aspectRatioLabel;
    private static JLabel frameRateLabel;

    private static JLabel audioCodecLabel;
    private static JLabel channelsLabel;

    /**
     * The constructor starts with the basic panel.
     */
    public Information() {
        final Font font = new java.awt.Font("Tahoma", 0, 11);
        final Color orangeColor = new java.awt.Color(255, 51, 0);
        this.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.
                        createLineBorder(orangeColor), "Information",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                font, orangeColor));
        this.setVisible(true);
        this.setBackground(Color.WHITE);
        path = new JLabel("");
        size = new JLabel("");
        extension = new JLabel("");
        videoCodec = new JLabel("");
        resolution = new JLabel("");
        aspectRatio = new JLabel("");
        frameRate = new JLabel("");
        audioCodec = new JLabel("");
        channels = new JLabel("");

        pathLabel = new JLabel("Path :");
        sizeLabel = new JLabel("Size :");
        extensionLabel = new JLabel("Extension :");
        videoCodecLabel = new JLabel("Video Codec :");
        resolutionLabel = new JLabel("Resolution :");
        aspectRatioLabel = new JLabel("Aspect Ratio :");
        frameRateLabel = new JLabel("Frame Rate :");
        audioCodecLabel = new JLabel("Audio Codec :");
        channelsLabel = new JLabel("Channels :");
    }

    /**
     * This method start the objects for the view in the panel.
     */
    public void showInformation() {
        final int rows = 9;
        final int cols = 2;
        setLayout(new GridLayout(rows, cols));

        add(pathLabel);
        add(path);

        add(sizeLabel);
        add(size);

        add(extensionLabel);
        add(extension);

        add(videoCodecLabel);
        add(videoCodec);

        add(resolutionLabel);
        add(resolution);

        add(aspectRatioLabel);
        add(aspectRatio);

        add(frameRateLabel);
        add(frameRate);

        add(audioCodecLabel);
        add(audioCodec);

        add(channelsLabel);
        add(channels);
    }

    /**
     * This method set all the information depending about the type of file.
     *
     * @param file Input.
     */
    public static void setInformation(final Asset file) {
        hideInformation(file);
        path.setText(file.getPath());
        size.setText(String.valueOf(file.getFileSize()));
        extension.setText(file.getExtension());
        if (file instanceof VideoFileAsset) {
            videoCodec.setText(((VideoFileAsset) file).getVideoCodec());
            resolution.setText(((VideoFileAsset) file).getResolution());
            aspectRatio.setText(((VideoFileAsset) file).getAspectRatio());
            frameRate.setText(((VideoFileAsset) file).getFrameRate());
            audioCodec.setText(((VideoFileAsset) file).getAudioCodec());
        }
        if (file instanceof AudioFileAsset) {
            audioCodec.setText(((AudioFileAsset) file).getAudioCodec());
            channels.setText(String.valueOf(((AudioFileAsset) file).getChannels()));
        }
    }

    /**
     * This method hide the JObject for show only the appropriate information.
     *
     * @param file Input.
     */
    private static void hideInformation(final Asset file) {
        videoCodecLabel.setVisible(false);
        videoCodec.setVisible(false);
        resolutionLabel.setVisible(false);
        resolution.setVisible(false);
        aspectRatioLabel.setVisible(false);
        aspectRatio.setVisible(false);
        frameRateLabel.setVisible(false);
        frameRate.setVisible(false);
        audioCodecLabel.setVisible(false);
        audioCodec.setVisible(false);
        channelsLabel.setVisible(false);
        channels.setVisible(false);
        if (file instanceof VideoFileAsset) {
            videoCodecLabel.setVisible(true);
            videoCodec.setVisible(true);
            resolutionLabel.setVisible(true);
            resolution.setVisible(true);
            aspectRatioLabel.setVisible(true);
            aspectRatio.setVisible(true);
            frameRateLabel.setVisible(true);
            frameRate.setVisible(true);
            audioCodecLabel.setVisible(true);
            audioCodec.setVisible(true);
        }
        if (file instanceof AudioFileAsset) {
            audioCodecLabel.setVisible(true);
            audioCodec.setVisible(true);
            channelsLabel.setVisible(true);
            channels.setVisible(true);
        }
    }
}
