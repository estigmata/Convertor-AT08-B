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
public class BasicSearchPanel extends JPanel {
    private JButton searchButton;
    private static JTextField path;
    private JTextField fileName;
    private JTextField size;
    private BrowseChooser browseChooser;
    protected JComboBox<String> multimediaBox;
    private JComboBox<String> sizeBox;

    /**
     * Constructor.
     */
    public BasicSearchPanel() {
        this.setName("Basic Search");
        path = new JTextField("");
        searchButton = new JButton("Find");
        fileName = new JTextField();
        size = new JTextField();
        this.setVisible(true);
        browseChooser = new BrowseChooser();
        browseChooser.setPath(path);

        multimediaBox = new JComboBox<>(new String[]{"All", "Video", "Audio"});

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
        TitledBorder title = BorderFactory.createTitledBorder("Basic Search");
        this.setBorder(title);
        this.setLayout(new GridBagLayout());
        GridBagConstraints bagConstraints = new GridBagConstraints();
        //bagConstraints.insets = new Insets(2, 2, 2, 2);
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;

        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        this.add(new Label("What Find?"), bagConstraints);
        bagConstraints.gridx = one;
        bagConstraints.gridy = 0;
        this.add(path, bagConstraints);
        bagConstraints.gridx = two;
        bagConstraints.gridy = 0;
        this.add(browseChooser, bagConstraints);
        bagConstraints.gridx = 0;
        bagConstraints.gridy = one;
        this.add(new JLabel("File Name:"), bagConstraints);
        bagConstraints.gridx = one;
        bagConstraints.gridy = one;
        this.add(fileName, bagConstraints);
        bagConstraints.gridx = 0;
        bagConstraints.gridy = two;
        this.add(new JLabel("Size:"), bagConstraints);
        bagConstraints.gridx = one;
        bagConstraints.gridy = two;
        this.add(size, bagConstraints);

        bagConstraints.gridx = 0;
        bagConstraints.gridy = tree;
        this.add(new JLabel("Multimedia:"), bagConstraints);
        bagConstraints.gridx = one;
        bagConstraints.gridy = tree;
        this.add(multimediaBox, bagConstraints);


        bagConstraints.gridx = two;
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
    public static JTextField getPath() {
        return path;
    }

    /**
     * Getter for the Combo extension.
     *
     * @return the JComboBox
     */
    public JComboBox<String> getMultimediaBox() {
        return multimediaBox;
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

}
