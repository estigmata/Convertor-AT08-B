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
public class AudioSearchPanel extends JPanel {
    protected JComboBox<String> channel;
    private JComboBox<String> audioCodec;
    private JLabel labelChannel;
    private JLabel labelAudioCodec;
    private JPanel container;
    private Style style;

    /**
     * Constructor.
     */
    public AudioSearchPanel() {
        style = new Style();

        audioCodec = new JComboBox<>(new String[]{"", "MP3", "WMAV2", "AAC", "PCM_S16LE"});
        channel = new JComboBox<>(new String[]{"", "1", "2", "3"});
        labelChannel = new JLabel("Channel :");
        labelAudioCodec = new JLabel("Audio Codec :");

        audioCodec.setFont(style.getFont());
        channel.setFont(style.getFont());
        labelChannel.setFont(style.getFont());
        labelAudioCodec.setFont(style.getFont());

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
        final Font font = new java.awt.Font("Tahoma", 0, 11);
        final Color orangeColor = new java.awt.Color(255, 51, 0);
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.
                        createLineBorder(orangeColor), "Audio Advanced Search",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                font,
                orangeColor));

        container.setBackground(Color.WHITE);

        GridBagConstraints bagConstraints = new GridBagConstraints();
        bagConstraints.insets = new Insets(1, 1, 1, 1);
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;

        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        labelAudioCodec.setHorizontalAlignment(SwingConstants.RIGHT);
        container.add(labelAudioCodec, bagConstraints);

        bagConstraints.gridx = one;
        bagConstraints.gridy = 0;
        container.add(audioCodec, bagConstraints);

        bagConstraints.gridx = two;
        bagConstraints.gridy = 0;
        labelChannel.setHorizontalAlignment(SwingConstants.RIGHT);
        container.add(labelChannel, bagConstraints);

        bagConstraints.gridx = tree;
        bagConstraints.gridy = 0;
        container.add(channel, bagConstraints);


        this.add(container);

    }

    /**
     * @return value of the channel JComboBox .
     */
    public JComboBox<String> getChannel() {
        return channel;
    }


    /**
     * @return value of the Audio Codec JComboBox.
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
