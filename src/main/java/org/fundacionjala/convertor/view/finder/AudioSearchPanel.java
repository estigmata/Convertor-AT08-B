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
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;


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

    /**
     * Constructor.
     */
    public AudioSearchPanel() {
        audioCodec = new JComboBox<>(new String[]{"", "MP3", "WMAV2"});
        channel = new JComboBox<>(new String[]{"", "1", "2", "3"});

        labelChannel = new JLabel("Channel :");
        labelAudioCodec = new JLabel("Audio Codec :");
        initComponents();
    }

    /**
     * Initialization of Components.
     */
    public void initComponents() {
        final int one = 1;
        TitledBorder title = BorderFactory.createTitledBorder("Audio Advanced Search");
        this.setBorder(title);
        this.setLayout(new GridBagLayout());
        GridBagConstraints bagConstraints = new GridBagConstraints();
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;

        labelAudioCodec.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        this.add(labelAudioCodec, bagConstraints);
        bagConstraints.gridx = one;
        bagConstraints.gridy = 0;
        this.add(audioCodec, bagConstraints);
        bagConstraints.gridx = 0;
        bagConstraints.gridy = one;
        labelChannel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        this.add(labelChannel, bagConstraints);
        bagConstraints.gridx = one;
        bagConstraints.gridy = one;
        this.add(channel, bagConstraints);
        this.setBackground(Color.WHITE);

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
