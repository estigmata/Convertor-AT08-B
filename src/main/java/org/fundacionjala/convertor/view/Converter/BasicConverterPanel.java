/**
 * @BasicConverterPanel.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * <p>
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 * <p>
 * Please contact Fundacion Jala, 2643 Av Melchor Perez de Olguin, Colquiri
 * Sud, Cochabamba, Bolivia. www.fundacion-jala.org if you need additional
 * information or have any questions.
 */
package org.fundacionjala.convertor.view.Converter;

import org.fundacionjala.convertor.view.BrowseChooser;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;


/**
 * Class FinderPanel.
 *
 * @author Abel Mallcu Chiri.
 * @author Nestor Otondo.
 * @version 1.0
 */
public class BasicConverterPanel extends JPanel {

    private JPanel container;
    private JButton btnConverter;
    private static JTextField outputPath;
    private JTextField outputFileName;
    private static JTextField currentPath;
    private static String fileToConvert;
    private BrowseChooser browseChooser;
    protected JComboBox<String> multimediaBox;
    private JLabel labelOutPath;
    private JLabel labelOutputName;
    private JLabel labelCurrentPath;
    private JLabel labelMultimediaBox;

    /**
     * Constructor.
     */
    public BasicConverterPanel() {
        final int ten = 10;
        outputPath = new JTextField("");
        outputPath.setColumns(ten);
        btnConverter = new JButton("Converter");
        outputFileName = new JTextField();
        currentPath = new JTextField();
        this.setVisible(true);
        browseChooser = new BrowseChooser();
        browseChooser.setPath(outputPath);
        multimediaBox = new JComboBox<>(new String[]{"Video", "Audio"});
        labelOutPath = new JLabel("Output File :");
        labelOutputName = new JLabel("File Name :");
        labelCurrentPath = new JLabel("Current Path :");
        labelMultimediaBox = new JLabel("Multimedia :");

        container = new JPanel(new GridBagLayout());
        initComponents();
    }

    /**
     * Initialization of Components.
     */
    public void initComponents() {

        final int one = 1;
        final int two = 2;
        final int tree = 3;
        final int four = 4;
        final int six = 6;

        this.setBackground(Color.WHITE);
        container.setBackground(Color.WHITE);
        final Font font = new java.awt.Font("Tahoma", 0, 11);
        final Color orangeColor = new java.awt.Color(255, 51, 0);
        this.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.
                        createLineBorder(orangeColor), "Basic Search",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                font, orangeColor));

        GridBagConstraints bagConstraints = new GridBagConstraints();
        bagConstraints.insets = new Insets(1, 1, 1, 1);
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;

        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        labelOutputName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        container.add(labelOutputName, bagConstraints);
        bagConstraints.gridx = one;
        bagConstraints.gridy = 0;
        container.add(outputFileName, bagConstraints);

        bagConstraints.gridx = 0;
        bagConstraints.gridy = one;
        labelCurrentPath.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        container.add(labelCurrentPath, bagConstraints);
        bagConstraints.gridx = one;
        bagConstraints.gridy = one;
        container.add(currentPath, bagConstraints);


        bagConstraints.gridx = 0;
        bagConstraints.gridy = tree;
        labelOutPath.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        container.add(labelOutPath, bagConstraints);
        bagConstraints.gridx = one;
        bagConstraints.gridy = tree;
        container.add(outputPath, bagConstraints);
        bagConstraints.gridx = two;
        bagConstraints.gridy = tree;
        container.add(browseChooser, bagConstraints);


        bagConstraints.gridx = 0;
        bagConstraints.gridy = four;
        labelMultimediaBox.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        container.add(labelMultimediaBox, bagConstraints);
        bagConstraints.gridx = one;
        bagConstraints.gridy = four;
        container.add(multimediaBox, bagConstraints);


        bagConstraints.gridx = one;

        bagConstraints.gridy = six;
        container.add(btnConverter, bagConstraints);
        this.add(container);
    }

    /**
     * @return .
     */
    public JButton getConverterButton() {
        return btnConverter;
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
        return outputFileName;
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

    /**
     * @param fileName .
     */
    public static void setFileToConvert(final String fileName) {
        fileToConvert = fileName;
    }

    /**
     * @param pathSource .
     */
    public static void setPathSource(final String pathSource) {
        currentPath.setText(pathSource);
    }

    /**
     * @param pathDestination .
     */
    public static void setPathDestination(final String pathDestination) {
        outputPath.setText(pathDestination);
    }

    /**
     * @return .
     */
    public static String getFileToConvert() {
        return fileToConvert;
    }

    /**
     *
     */
    private void converterFile() {
        //TODO
    }
}
