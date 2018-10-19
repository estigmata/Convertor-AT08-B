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
package org.fundacionjala.convertor.view;

import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;


/**
 * Class FinderPanel.
 *
 * @author Rodrigo Menacho
 * @version 1.0
 */
public class FinderPanel extends JPanel {
    private JButton searchButton;
    private JTextField path;
    private JLabel label;


    /**
     * Constructor.
     */
    public FinderPanel() {
        final int fPanRows = 0;
        final int fPanCols = 3;

        path = new JTextField("");
        label = new JLabel("What find?:");
        searchButton = new JButton("Find");
        this.setLayout(new GridLayout(fPanRows, fPanCols));
        this.setVisible(true);

    }

    /**
     * Initialization of Components.
     */
    void initComponents() {
        this.add(label);
        this.add(path);
        this.add(searchButton);
    }

    /**
     * Getter of the search button.
     *
     * @return JButton Object.
     */
    public JButton getSearchButton() {
        return searchButton;
    }

    /**
     * Getter of the Path.
     *
     * @return String.
     */
    public String getPathText() {
        return path.getText();
    }
}
