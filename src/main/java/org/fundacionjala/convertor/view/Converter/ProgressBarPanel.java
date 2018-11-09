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
import javax.swing.JPanel;
import javax.swing.JProgressBar;
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
public class ProgressBarPanel extends JPanel {

    protected JProgressBar status;

    /**
     * Constructor.
     */
    public ProgressBarPanel() {
        status = new JProgressBar();
        initComponents();
    }

    /**
     * Initialization of Components.
     */
    public void initComponents() {
        final int one = 1;
        final int two = 2;
        final int state = 50;
        TitledBorder title = BorderFactory.createTitledBorder("Progres Status");
        this.setBorder(title);
        this.setLayout(new GridBagLayout());
        GridBagConstraints bagConstraints = new GridBagConstraints();
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        this.add(new Label("Status"), bagConstraints);
        bagConstraints.gridx = one;
        bagConstraints.gridy = 0;
        status.setValue(state);
        this.add(status, bagConstraints);
    }

    /**
     * @return .
     */
    public JProgressBar getStatus() {
        return status;
    }
}
