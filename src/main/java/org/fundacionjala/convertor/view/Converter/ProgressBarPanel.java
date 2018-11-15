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

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;

/**
 * Class FinderPanel.
 *
 * @author Abel Gustavo Mallcu Chiri.
 * @version 1.0
 */
public class ProgressBarPanel extends JPanel {

    protected JProgressBar status;
    private final int oneHundred = 100;

    /**
     * Constructor.
     */
    public ProgressBarPanel() {
        status = new JProgressBar();
        status.setMinimum(0);
        status.setMaximum(oneHundred);
        initComponents();
    }

    /**
     * Initialization of Components.
     * init components
     */
    public void initComponents() {
        final int one = 1;

        final Font font = new java.awt.Font("Tahoma", 0, 11);
        final Color orangeColor = new java.awt.Color(255, 51, 0);
        this.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.
                        createLineBorder(orangeColor), "Basic Search",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                font, orangeColor));

        this.setLayout(new GridBagLayout());

        GridBagConstraints bagConstraints = new GridBagConstraints();
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        this.add(new Label("Status"), bagConstraints);

        bagConstraints.gridx = one;
        bagConstraints.gridy = 0;
        status.setValue(0);

        this.add(status, bagConstraints);
    }

    /**
     * @return .
     */
    public JProgressBar getStatus() {
        return status;
    }

    /**
     * This method updates the progress bar while the conversion its executed.
     *
     * @param percentage Input percentage.
     */
    public void setValue1(final int percentage) {
        System.out.println(percentage);
        status.setValue(percentage);
        status.update(status.getGraphics());
        status.setStringPainted(true);
    }
}
