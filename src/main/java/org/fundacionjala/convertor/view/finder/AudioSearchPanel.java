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


import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
public class AudioSearchPanel extends JPanel {
    protected JComboBox<String> channel;
    private JComboBox<String> audioCodec;
    private JLabel labelChannel;
    private JLabel labelAudioCodec;

    private JPanel container;

    /**
     * Constructor.
     */
    public AudioSearchPanel() {
        audioCodec = new JComboBox<>(new String[]{"", "MP3", "WMAV2", "AAC", "PCM_S16LE"});
        channel = new JComboBox<>(new String[]{"", "1", "2", "3"});

        labelChannel = new JLabel("Channel :");
        labelAudioCodec = new JLabel("Audio Codec :");

        container = new JPanel(new GridBagLayout());
        initComponents();
    }

    /**
     * Initialization of Components.
     */
    public void initComponents() {
        final int one = 1;
        final int two = 2;
        final int tree = 3;
        this.setBackground(Color.WHITE);
        final Font font = new java.awt.Font("Tahoma", 0, 11);
        final Color orangeColor = new java.awt.Color(255, 51, 0);
        this.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.
                        createLineBorder(orangeColor), "Audio Advanced Search",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                font,
                orangeColor));
        container.setBackground(Color.WHITE);
        GridBagConstraints bagConstraints = new GridBagConstraints();
        bagConstraints.insets = new Insets(1, 1, 1, 1);
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;

        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        labelAudioCodec.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        container.add(labelAudioCodec, bagConstraints);

        bagConstraints.gridx = one;
        bagConstraints.gridy = 0;
        container.add(audioCodec, bagConstraints);

        bagConstraints.gridx = two;
        bagConstraints.gridy = 0;
        labelChannel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        container.add(labelChannel, bagConstraints);
        bagConstraints.gridx = tree;
        bagConstraints.gridy = 0;

        container.add(channel, bagConstraints);


        this.add(container);

    }

    /**
     * @return channel value.
     */
    public JComboBox<String> getChannel() {
        return channel;
    }

    /**
     * @param channel .
     */
    public void setChannel(final JComboBox<String> channel) {
        this.channel = channel;
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
