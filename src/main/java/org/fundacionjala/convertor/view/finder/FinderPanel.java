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


import org.fundacionjala.convertor.view.BrowseChooser;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;

/**
 * Class FinderPanel.
 *
 * @author Rodrigo Menacho
 * @version 1.0
 */
public abstract class FinderPanel extends JPanel {
    private JButton searchButton;
    private JTextField path;
    private JTextField fileName;
    protected JComboBox extensionBox;
    private JTextField size;
    private BrowseChooser browseChooser;


    /**
     * Constructor.
     */
    public FinderPanel() {
        path = new JTextField("");
        searchButton = new JButton("Find");
        fileName = new JTextField();
        size = new JTextField();
        this.setVisible(true);
        browseChooser = new BrowseChooser();
        browseChooser.setPath(path);

    }

    /**
     * Initialization of Components.
     */
    public void initBasicComponents() {
        final int twoHundred = 200;
        final int three = 3;
        final int four = 4;
        this.setLayout(new GridBagLayout());
        GridBagConstraints bagConstraints = new GridBagConstraints();
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        this.add(new Label("What Find?:"), bagConstraints);
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 0;
        bagConstraints.ipadx = twoHundred;
        this.add(path, bagConstraints);
        bagConstraints.ipadx = 0;
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 0;
        this.add(browseChooser, bagConstraints);
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 1;
        this.add(new JLabel("By File Name:"), bagConstraints);
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 1;
        this.add(fileName, bagConstraints);
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 2;
        this.add(new JLabel("Extension:"), bagConstraints);
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 2;
        this.add(extensionBox, bagConstraints);
        bagConstraints.gridx = 0;
        bagConstraints.gridy = three;
        this.add(new JLabel("Size:"), bagConstraints);
        bagConstraints.gridx = 1;
        bagConstraints.gridy = three;
        this.add(size, bagConstraints);
        bagConstraints.gridx = 2;
        bagConstraints.gridy = four;
        this.add(searchButton, bagConstraints);
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
     * @return object.
     */
    public JTextField getPath() {
        return path;
    }
}