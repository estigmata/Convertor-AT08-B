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
import org.fundacionjala.convertor.view.Converter.ConverterPanel;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.*;


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
    private JComboBox<String> multimediaBox;


    private JLabel labelPath;
    private JLabel labelSize;
    private JLabel labelName;
    private JLabel labelMultimedia;
    private JPanel conatainer;

    /**
     * Constructor.
     */
    public BasicSearchPanel() {
        this.setName("Basic Search");
        path = new JTextField("");
        searchButton = new JButton();
        fileName = new JTextField();
        size = new JTextField();
        browseChooser = new BrowseChooser();
        browseChooser.setBackground(Color.WHITE);
        browseChooser.setPath(path);

        searchButton.setBackground(Color.WHITE);
        searchButton.setIcon(new javax.swing.ImageIcon("Image\\search.PNG"));
searchButton.setBorder(null);

        multimediaBox = new JComboBox<>(new String[]{"All", "Video", "Audio"});
        labelPath = new JLabel("What find ? :");
        labelSize = new JLabel("Size :");
        labelName = new JLabel("Name :");
        labelMultimedia = new JLabel("Multimedia :");

        conatainer = new JPanel(new GridBagLayout());
        this.setBackground(Color.WHITE);
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

this.setBackground(Color.WHITE);
        conatainer.setBackground(Color.WHITE);

        this.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.
                        createLineBorder(new java.awt.Color(255, 51, 0)), "Basic Search",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("Tahoma", 0, 11),
                new java.awt.Color(255, 51, 0)));
        GridBagConstraints bagConstraints = new GridBagConstraints();
        bagConstraints.insets = new Insets(1, 1, 1, 1);
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;

        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        bagConstraints.anchor = GridBagConstraints.LINE_END;
        bagConstraints.ipady = 0;
        bagConstraints.weightx = 0.6;
        bagConstraints.weighty = 0;
        conatainer.add(labelPath, bagConstraints);

        bagConstraints.gridx = one;
        bagConstraints.gridy = 0;
        bagConstraints.anchor = GridBagConstraints.LINE_END;
        bagConstraints.ipady = 0;
        bagConstraints.weightx = 0.4;
        bagConstraints.weighty = 0;
        conatainer.add(path, bagConstraints);

        bagConstraints.gridx = 3;
        bagConstraints.gridy = 0;
        bagConstraints.anchor = GridBagConstraints.PAGE_END;
        bagConstraints.ipady = 0;
        bagConstraints.weightx = 0.4;
        bagConstraints.weighty = 0;
        conatainer.add(browseChooser, bagConstraints);

        bagConstraints.gridx = 0;
        bagConstraints.gridy = one;
        bagConstraints.anchor = GridBagConstraints.LINE_END;
        bagConstraints.ipady = 0;
        bagConstraints.weightx = 0.6;
        bagConstraints.weighty = 0;
        conatainer.add(labelName, bagConstraints);

        bagConstraints.gridx = one;
        bagConstraints.gridy = one;
        bagConstraints.anchor = GridBagConstraints.LINE_END;
        bagConstraints.ipady = 0;
        bagConstraints.weightx = 0.6;
        bagConstraints.weighty = 0;
        conatainer.add(fileName, bagConstraints);

        bagConstraints.gridx = two;
        bagConstraints.gridy = 1;
        bagConstraints.anchor = GridBagConstraints.LINE_END;
        bagConstraints.ipady = 0;
        bagConstraints.weightx = 0.6;
        bagConstraints.weighty = 0;
        conatainer.add(labelSize, bagConstraints);

        bagConstraints.gridx = 3;
        bagConstraints.gridy = 1;
        bagConstraints.anchor = GridBagConstraints.PAGE_END;
        bagConstraints.ipady = 0;
        bagConstraints.weightx = 0.4;
        bagConstraints.weighty = 0;
        conatainer.add(size, bagConstraints);

        bagConstraints.gridx = 0;
        bagConstraints.gridy = tree;
        bagConstraints.anchor = GridBagConstraints.LINE_END;
        bagConstraints.ipady = 0;
        bagConstraints.weightx = 0.6;
        bagConstraints.weighty = 0;
        conatainer.add(labelMultimedia, bagConstraints);

        bagConstraints.gridx = one;
        bagConstraints.gridy = tree;
        bagConstraints.anchor = GridBagConstraints.PAGE_END;
        bagConstraints.ipady = 0;
        bagConstraints.weightx = 0.4;
        bagConstraints.weighty = 0;
        conatainer.add(multimediaBox, bagConstraints);


        bagConstraints.gridx = 3;
        bagConstraints.gridy = four;
        conatainer.add(searchButton, bagConstraints);


        this.add(conatainer);
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
