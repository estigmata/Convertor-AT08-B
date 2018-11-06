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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;


/**
 * Class FinderPanel.
 *
 * @author Abel Mallcu Chiri.
 * @version 1.0
 */
public class VideoSearchPanel extends JPanel {
    protected JComboBox<String> frameRate;
    private JComboBox<String> aspectRatio;
    protected JComboBox<String> resolution;
    private JComboBox<String> videoCodec;
    private JComboBox<String> audioCodec;

    /**
     * Constructor.
     */
    public VideoSearchPanel() {
        frameRate = new JComboBox<>(new String[]{"Equal to", "Smaller than", "Greater than"});
        aspectRatio = new JComboBox<>(new String[]{"Video", "Multimedia"});
        resolution = new JComboBox<>(new String[]{"899*1024", "1024*1024", "1800*900"});
        videoCodec = new JComboBox<>(new String[]{"Video", "Multimedia"});
        audioCodec = new JComboBox<>(new String[]{"Equal to", "Smaller than", "Greater than"});
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
        TitledBorder title = BorderFactory.createTitledBorder("Video Advanced Search");
        this.setBorder(title);
        this.setLayout(new GridBagLayout());
        GridBagConstraints bagConstraints = new GridBagConstraints();
        //bagConstraints.insets = new Insets(2, 2, 2, 2);
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        this.add(new Label("Frame Rate:"), bagConstraints);
        bagConstraints.gridx = one;
        bagConstraints.gridy = 0;
        this.add(frameRate, bagConstraints);
        bagConstraints.gridx = 0;
        bagConstraints.gridy = one;
        this.add(new JLabel("Aspect Ratio:"), bagConstraints);
        bagConstraints.gridx = one;
        bagConstraints.gridy = one;
        this.add(aspectRatio, bagConstraints);
        bagConstraints.gridx = 0;
        bagConstraints.gridy = two;
        this.add(new JLabel("Resolution"), bagConstraints);
        bagConstraints.gridx = one;
        bagConstraints.gridy = two;
        this.add(resolution, bagConstraints);
        bagConstraints.gridx = 0;
        bagConstraints.gridy = three;
        this.add(new JLabel("Video Codec"), bagConstraints);
        bagConstraints.gridx = one;
        bagConstraints.gridy = three;
        this.add(videoCodec, bagConstraints);
        bagConstraints.gridx = 0;
        bagConstraints.gridy = four;
        this.add(new JLabel("Audio Codec"), bagConstraints);
        bagConstraints.gridx = one;
        bagConstraints.gridy = four;
        this.add(audioCodec, bagConstraints);
    }

    /**
     * @return .
     */
    public JComboBox<String> getFrameRate() {
        return frameRate;
    }

    /**
     * @param frameRate .
     */
    public void setFrameRate(final JComboBox<String> frameRate) {
        this.frameRate = frameRate;
    }

    /**
     * @return .
     */
    public JComboBox<String> getAspectRatio() {
        return aspectRatio;
    }

    /**
     * @param aspectRatio .
     */
    public void setAspectRatio(final JComboBox<String> aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    /**
     * @return .
     */
    public JComboBox<String> getResolution() {
        return resolution;
    }

    /**
     * @param resolution .
     */
    public void setResolution(final JComboBox<String> resolution) {
        this.resolution = resolution;
    }

    /**
     * @return .
     */
    public JComboBox<String> getVideoCodec() {
        return videoCodec;
    }

    /**
     * @param videoCodec .
     */
    public void setVideoCodec(final JComboBox<String> videoCodec) {
        this.videoCodec = videoCodec;
    }

    /**
     * @return .
     */
    public JComboBox<String> getAudioCodec() {
        return audioCodec;
    }

    /**
     * @param audioCodec .
     */
    public void setAudioCodec(final JComboBox<String> audioCodec) {
        this.audioCodec = audioCodec;
    }
}
