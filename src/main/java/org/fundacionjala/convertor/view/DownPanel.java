/*
 * @DownPanel.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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


import org.fundacionjala.convertor.model.objectfile.Asset;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 *
 */
public class DownPanel extends JPanel {
    private ResultTablePanel resultTablePanel;

    /**
     *
     */
    public DownPanel() {
        resultTablePanel = new ResultTablePanel();
        initComponents();
    }

    /**
     *
     */
    private void initComponents() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(resultTablePanel);
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.add(new JLabel("SETTINGS"));
        rightPanel.add(new JLabel("Archive source path:"));
        rightPanel.add(new JTextField());
        rightPanel.add(new JLabel("Archive destination path:"));
        rightPanel.add(new JTextField());
        rightPanel.add(new JLabel("Convert to:"));
        rightPanel.add(new JComboBox<>());
        this.add(rightPanel);
    }

    /**
     * Method to obtain result table panel.
     *
     * @return the panel.
     */
    public ResultTablePanel getResultTablePanel() {
        return resultTablePanel;
    }

    public JPanel getFilesPanel(ArrayList<Asset> files) {
        return resultTablePanel;
    }
}
