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
import java.awt.Insets;
import java.awt.Label;

/**
 * Class FinderPanel.
 *
 * @author Rodrigo Menacho
 * @version 1.0
 */
public class FinderPanel extends JPanel {
    private JButton searchButton;
    private JTextField path;
    private JTextField fileName;
    private JTextField size;
    private BrowseChooser browseChooser;
    protected JComboBox<String> extensionBox;
    private JComboBox<String> sizeBox;
    private JComboBox<String> sizeBoxMultimedia;

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
        sizeBoxMultimedia = new JComboBox<>(new String[]{"All", "Video", "Multimedia"});
        sizeBox = new JComboBox<>(new String[]{"Equal to", "Smaller than", "Greater than"});
        extensionBox = new JComboBox<>(new String[]{"mp3", "midi", "m4a"});

        initComponents();
    }

    /**
     * Initialization of Components.
     */
    public void initComponents() {
        final int twoHundred = 200;
        final int ten = 10;
        final int three = 3;
        final int four = 4;

        this.setLayout(new GridBagLayout());
        GridBagConstraints bagConstraints = new GridBagConstraints();
        //bagConstraints.insets = new Insets(2, 2, 2, 2);
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        this.add(new Label("What Find?:"), bagConstraints);

        bagConstraints.gridx = 1;
        bagConstraints.gridy = 0;
        this.add(path, bagConstraints);

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
        this.add(new JLabel("Multimedia"), bagConstraints);

        bagConstraints.gridx = 1;
        bagConstraints.gridy = 2;
        this.add(sizeBoxMultimedia, bagConstraints);

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

    /**
     * Getter for the Combo extension.
     *
     * @return the JComboBox
     */
    public JComboBox<String> getExtensionBox() {
        return extensionBox;
    }

    /**
     * Getter for the Combo size.
     *
     * @return the JComboBox
     */
    public JComboBox<String> getSizeBox() {
        return sizeBox;
    }

    /**
     * Getter of the File Name.
     *
     * @return JTextField
     */
    public JTextField getFileName() {
        return fileName;
    }

    /**
     * Getter of the size field.
     *
     * @return JTextField
     */
    public JTextField getSizeField() {
        return size;
    }

    /**
     * Getter of the size box multimedia :c.
     *
     * @return the String.
     */
    public String getSizeBoxMultimedia() {
        return (String) sizeBoxMultimedia.getSelectedItem();
    }
}
