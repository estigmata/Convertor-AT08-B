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
 * @author Abel Gustavo Mallcu Chiri.
 * @version 1.0
 */
public class AudioConverterPanel extends JPanel {


    protected JComboBox<String> channelConverter;
    private JComboBox<String> audioCodecConverter;


    private JComboBox<String> formatCodecConverter;

    /**
     * Constructor.
     */
    public AudioConverterPanel() {
        audioCodecConverter = new JComboBox<>(new String[]{"", "MP3", "WMAV2"});
        channelConverter = new JComboBox<>(new String[]{"", "1", "2", "3"});
        formatCodecConverter = new JComboBox<>(new String[]{"", "MP3", "WAP"});
        initComponents();
    }

    /**
     * Initialization of Components.
     */
    public void initComponents() {
        final int one = 1;
        final int two = 2;
        TitledBorder title = BorderFactory.createTitledBorder("Audio Advanced Converter");
        this.setBorder(title);
        this.setLayout(new GridBagLayout());
        GridBagConstraints bagConstraints = new GridBagConstraints();
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        this.add(new Label("Audio Codec:"), bagConstraints);
        bagConstraints.gridx = one;
        bagConstraints.gridy = 0;
        this.add(audioCodecConverter, bagConstraints);
        bagConstraints.gridx = 0;
        bagConstraints.gridy = one;
        this.add(new JLabel("Channel:"), bagConstraints);
        bagConstraints.gridx = one;
        bagConstraints.gridy = one;
        this.add(channelConverter, bagConstraints);

        bagConstraints.gridx = 0;
        bagConstraints.gridy = two;
        this.add(new JLabel("Format"), bagConstraints);
        bagConstraints.gridx = one;
        bagConstraints.gridy = two;
        this.add(formatCodecConverter, bagConstraints);
    }

    /**
     * @return .
     */
    public JComboBox<String> getChannelConverter() {
        return channelConverter;
    }

    /**
     * @return .
     */
    public JComboBox<String> getAudioCodecConverter() {
        return audioCodecConverter;
    }

    /**
     * @return .
     */
    public JComboBox<String> getFormatCodecConverter() {
        return formatCodecConverter;
    }

}
