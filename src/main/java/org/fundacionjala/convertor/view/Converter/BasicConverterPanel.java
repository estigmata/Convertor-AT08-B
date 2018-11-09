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

import org.fundacionjala.convertor.view.BrowseChooser;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;

/**
 * Class FinderPanel.
 *
 * @author Abel Mallcu Chiri.
 * @version 1.0
 */
public class BasicConverterPanel extends JPanel {


    private JButton converterButton;
    private JTextField outputPath;
    private JTextField outputName;
    private JTextField currentPath;
    private BrowseChooser browseChooser;
    protected JComboBox<String> multimediaBox;


    /**
     * Constructor.
     */
    public BasicConverterPanel() {
        this.setName("Settings");
        outputPath = new JTextField("");
        converterButton = new JButton("Converter");
        outputName = new JTextField();
        currentPath = new JTextField();
        this.setVisible(true);
        browseChooser = new BrowseChooser();
        browseChooser.setPath(outputPath);

        multimediaBox = new JComboBox<>(new String[]{"Video", "Audio"});

        initComponents();
    }

    /**
     * Initialization of Components.
     */
    public void initComponents() {
        final int four = 4;
        final int tree = 3;
        final int one = 1;
        final int two = 2;
        final int five = 0;
        TitledBorder title = BorderFactory.createTitledBorder("Output Setting");
        this.setBorder(title);
        this.setLayout(new GridBagLayout());
        GridBagConstraints bagConstraints = new GridBagConstraints();
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;

        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        this.add(new JLabel("File Name:"), bagConstraints);
        bagConstraints.gridx = one;
        bagConstraints.gridy = 0;
        this.add(outputName, bagConstraints);

        bagConstraints.gridx = 0;
        bagConstraints.gridy = one;
        this.add(new JLabel("Current Path:"), bagConstraints);
        bagConstraints.gridx = one;
        bagConstraints.gridy = one;
        this.add(currentPath, bagConstraints);


        bagConstraints.gridx = 0;
        bagConstraints.gridy = tree;
        this.add(new Label("Output file"), bagConstraints);
        bagConstraints.gridx = one;
        bagConstraints.gridy = tree;
        this.add(outputPath, bagConstraints);
        bagConstraints.gridx = two;
        bagConstraints.gridy = tree;
        this.add(browseChooser, bagConstraints);


        bagConstraints.gridx = 0;
        bagConstraints.gridy = four;
        this.add(new JLabel("Multimedia:"), bagConstraints);
        bagConstraints.gridx = one;
        bagConstraints.gridy = four;
        this.add(multimediaBox, bagConstraints);


        bagConstraints.gridx = tree;

        bagConstraints.gridy = five;
        this.add(converterButton, bagConstraints);
    }

    /**
     * @return .
     */
    public JButton getConverterButton() {
        return converterButton;
    }

    /**
     * @return .
     */
    public JTextField getOutputPath() {
        return outputPath;
    }

    /**
     * @return .
     */
    public JTextField getOutputName() {
        return outputName;
    }

    /**
     * @return .
     */
    public JTextField getCurrentPath() {
        return currentPath;
    }

    /**
     * @return .
     */
    public BrowseChooser getBrowseChooser() {
        return browseChooser;
    }

    /**
     * @return .
     */
    public JComboBox<String> getMultimediaBox() {
        return multimediaBox;
    }


}
