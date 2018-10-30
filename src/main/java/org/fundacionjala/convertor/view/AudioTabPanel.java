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
import org.fundacionjala.convertor.view.finder.AudioFinderPanel;
import org.fundacionjala.convertor.view.finder.FinderPanel;

import javax.swing.*;
import java.awt.*;


/**
 * Class JPanel-Audio Panel.
 *
 * @author Rodrigo Menacho
 * @version 1.0
 */
class AudioTabPanel extends JPanel {
    private FinderPanel finderPanel;
    /**
     * Constructor.
     */
    AudioTabPanel() {
        AbstractLogger log = AbstractLogger.getInstance();
        log.setLogger(AudioTabPanel.class.getName());
        this.setLayout(new GridBagLayout());
        finderPanel = new FinderPanel();
        finderPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
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
        finderPanel.initComponents();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.ipady = ten;
        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(new JLabel("Search Panel"), constraints);

        constraints.ipady = 0;
        constraints.gridx = 0;
        constraints.gridy = 1;
        this.add(finderPanel, constraints);




    }

    /**
     * Getter of default table model.
     *
     * @return the default table.
     */
    /*public DefaultTableModel getDefaultTableModel() {
        return resultTableAudio.getDefaultTableModel();
    }*/

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
    /*public void setDefaultTableModel(final DefaultTableModel defaultTableModel) {
        resultTableAudio.setDefaultTableModel(defaultTableModel);
    }*/

}
