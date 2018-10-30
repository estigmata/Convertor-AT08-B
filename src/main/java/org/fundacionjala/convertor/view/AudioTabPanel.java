/*
 * @AudioTabPanel.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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
package org.fundacionjala.convertor.view;

import org.fundacionjala.convertor.utils.AbstractLogger;
import org.fundacionjala.convertor.utils.VLCMediaPlayer;
import org.fundacionjala.convertor.view.finder.AudioFinderPanel;
import org.fundacionjala.convertor.view.finder.FinderPanel;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;


/**
 * Class JPanel-Audio Panel.
 *
 * @author Rodrigo Menacho
 * @version 1.0
 */
class AudioTabPanel extends JPanel {
    private FinderPanel finderPanel;
    private ResultTable resultTableAudio;
    private JScrollPane resultScrollTable;
    private VLCMediaPlayer vlcMediaPlayer;

    /**
     * Constructor.
     */
    AudioTabPanel() {
        AbstractLogger log = AbstractLogger.getInstance();
        log.setLogger(AudioTabPanel.class.getName());
        this.setLayout(new GridBagLayout());
        finderPanel = new AudioFinderPanel();
        finderPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        resultTableAudio = new ResultTable();
        resultScrollTable = new JScrollPane(resultTableAudio);
        final int tWidth = 200;
        final int tHeight = 50;
        resultScrollTable.setPreferredSize(new Dimension(tWidth, tHeight));
        initComponents();
        log.info();
    }

    /**
     * Initialization of Components.
     */
    private void initComponents() {
        final int ten = 10;
        final int three = 3;
        final int thirteen = 30;
        final int threeHundred = 300;
        finderPanel.initBasicComponents();
        vlcMediaPlayer = new VLCMediaPlayer();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.ipady = ten;
        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(new JLabel("Search Panel"), constraints);
        constraints.gridx = 1;
        constraints.gridy = 0;
        this.add(new JLabel("Reproductor Panel"), constraints);
        constraints.ipady = 0;
        constraints.gridx = 0;
        constraints.gridy = 1;
        this.add(finderPanel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.ipadx = threeHundred;
        /*JPanel tempReproductor = new JPanel();
        tempReproductor.add(vlcMediaPlayer);
        tempReproductor.setBorder(BorderFactory.createLineBorder(Color.BLACK));*/
        this.add(vlcMediaPlayer, constraints); //Reproductor Panel
        constraints.ipadx = 0;
        constraints.gridx = 0;
        constraints.gridy = 2;
        this.add(new JLabel("Showed Results:"), constraints);
        constraints.gridx = 1;
        constraints.gridy = 2;
        this.add(new JLabel("Information"), constraints);
        constraints.ipady = threeHundred;
        constraints.weighty = thirteen;
        constraints.gridx = 0;
        constraints.gridy = three;
        this.add(resultScrollTable, constraints);
        constraints.gridx = 1;
        constraints.gridy = three;
        JPanel tempInformation = new JPanel();
        tempInformation.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(tempInformation, constraints); // Information Panel


    }

    /**
     * Getter of default table model.
     *
     * @return the default table.
     */
    public DefaultTableModel getDefaultTableModel() {
        return resultTableAudio.getDefaultTableModel();
    }

    /**
     * Getter FinderClass.
     *
     * @return FinderPanel.
     */
    public FinderPanel getFinderPanel() {
        return finderPanel;
    }

    /**
     * Setter the default table mode.
     *
     * @param defaultTableModel input object.
     */
    public void setDefaultTableModel(final DefaultTableModel defaultTableModel) {
        resultTableAudio.setDefaultTableModel(defaultTableModel);
    }

}
