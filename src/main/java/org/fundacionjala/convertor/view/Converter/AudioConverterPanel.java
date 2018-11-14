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
 * @author Abel Gustavo Mallcu Chiri.
 * @version 1.0
 */
public class AudioConverterPanel extends JPanel {


    protected JComboBox<String> channelConverter;
    private JComboBox<String> audioCodecConverter;
    private JComboBox<String> formatCodecConverter;

    private JLabel labelChannel;
    private JLabel labelAudioCodec;
    private JLabel labelFormatCode;

    /**
     * Constructor.
     */
    public AudioConverterPanel() {
        audioCodecConverter = new JComboBox<>(new String[]{"", "MP3", "WMAV2"});
        channelConverter = new JComboBox<>(new String[]{"", "1", "2", "3"});
        formatCodecConverter = new JComboBox<>(new String[]{"", "MP3", "WAP"});
        labelChannel = new JLabel("Channel :");
        labelAudioCodec = new JLabel("AudioCodec :");
        labelFormatCode = new JLabel("Format :");

        initComponents();
    }

    /**
     * Initialization of Components.
     */
    public void initComponents() {
        final int one = 1;
        final int two = 2;
        final Font font = new java.awt.Font("Tahoma", 0, 11);
        final Color orangeColor = new java.awt.Color(255, 51, 0);
        this.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.
                        createLineBorder(orangeColor), "Audio Converter",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                font, orangeColor));
        this.setLayout(new GridBagLayout());

        GridBagConstraints bagConstraints = new GridBagConstraints();
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;

        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        labelAudioCodec.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        this.add(labelAudioCodec, bagConstraints);

        bagConstraints.gridx = one;
        bagConstraints.gridy = 0;
        this.add(audioCodecConverter, bagConstraints);

        bagConstraints.gridx = 0;
        bagConstraints.gridy = one;
        labelChannel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        this.add(labelChannel, bagConstraints);

        bagConstraints.gridx = one;
        bagConstraints.gridy = one;
        this.add(channelConverter, bagConstraints);

        bagConstraints.gridx = 0;
        bagConstraints.gridy = two;
        labelFormatCode.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        this.add(labelFormatCode, bagConstraints);

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
