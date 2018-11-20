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


    private final JComboBox<String> audioSampleRate;
    private final JLabel labelAudioSampleRate;
    private final JComboBox<String> audioBitRate;
    private final JLabel labelBitRate;
    protected JComboBox<String> channelConverter;
    private JComboBox<String> audioCodecConverter;
    private JComboBox<String> formatCodecConverter;

    private JLabel labelChannel;
    private JLabel labelAudioCodec;
    private JLabel labelFormatCode;
    private Style style;

    /**
     * Constructor.
     */
    public AudioConverterPanel() {
        style = new Style();
        audioCodecConverter = new JComboBox<>(new String[]{"aac", "wmav2", "mp3"});
        channelConverter = new JComboBox<>(new String[]{"1", "2", "3"});
        formatCodecConverter = new JComboBox<>(new String[]{"mp3", "wav ", "3gp", "flac", "m4a"});
        audioSampleRate = new JComboBox<>(new String[]{"22050", "44100", "48000"});
        audioBitRate = new JComboBox<>(new String[]{"32", "96", "128", "192", "256", "320"});

        labelChannel = new JLabel("Channel :");
        labelAudioCodec = new JLabel("AudioCodec :");
        labelFormatCode = new JLabel("Format :");
        labelAudioSampleRate = new JLabel("Audio Sample Rate :");
        labelBitRate = new JLabel("Audio Bit Rate :");


        audioSampleRate.setFont(style.getFont());
        labelAudioSampleRate.setFont(style.getFont());
        audioBitRate.setFont(style.getFont());
        labelBitRate.setFont(style.getFont());
        channelConverter.setFont(style.getFont());
        audioCodecConverter.setFont(style.getFont());
        formatCodecConverter.setFont(style.getFont());
        labelChannel.setFont(style.getFont());
        labelAudioCodec.setFont(style.getFont());
        labelFormatCode.setFont(style.getFont());

        initComponents();
    }

    /**
     * Initialization of Components.
     */
    public void initComponents() {
        final int one = 1;
        final int two = 2;
        final int three = 3;
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

        bagConstraints.gridx = two;
        bagConstraints.gridy = 0;
        labelFormatCode.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        this.add(labelFormatCode, bagConstraints);

        bagConstraints.gridx = three;
        bagConstraints.gridy = 0;
        this.add(formatCodecConverter, bagConstraints);

        bagConstraints.gridx = two;
        bagConstraints.gridy = 1;
        labelAudioSampleRate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        this.add(labelAudioSampleRate, bagConstraints);

        bagConstraints.gridx = three;
        bagConstraints.gridy = 1;
        this.add(audioSampleRate, bagConstraints);

        bagConstraints.gridx = 0;
        bagConstraints.gridy = two;
        labelBitRate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        this.add(labelBitRate, bagConstraints);

        bagConstraints.gridx = 1;
        bagConstraints.gridy = two;
        this.add(audioBitRate, bagConstraints);
    }

    /**
     * This is the getter of the combobox of Audio Channel.
     *
     * @return the JComboBox.
     */
    public JComboBox<String> getChannelConverter() {
        return channelConverter;
    }

    /**
     * This is the getter of the combobox of Audio Codec.
     *
     * @return the JComboBox.
     */
    public JComboBox<String> getAudioCodecConverter() {
        return audioCodecConverter;
    }

    /**
     * This is the getter of the combobox of Format Codec Converter.
     *
     * @return the JComboBox.
     */
    public JComboBox<String> getFormatCodecConverter() {
        return formatCodecConverter;
    }

    /**
     * This is the getter of the ComboBox of Audio Sample rate.
     *
     * @return the JComboBox.
     */
    public JComboBox<String> getAudioSampleRate() {
        return audioSampleRate;
    }

    /**
     * Getter of the Combo Box of Audio bit rate.
     *
     * @return the JComboBox.
     */
    public JComboBox<String> getAudioBitRate() {
        return audioBitRate;
    }
}
