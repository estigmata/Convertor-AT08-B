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

import org.fundacionjala.convertor.utils.Style;
import org.fundacionjala.convertor.view.BrowseChooser;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
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
 * @author Rodrigo Menacho.
 * @version 1.0
 */
public class BasicConverterPanel extends JPanel {

    private JPanel container;
    private static JButton btnConverter;
    private static JTextField outputPath;
    private static JTextField outputFileName;
    private static JTextField currentPath;
    private static JComboBox<String> multimediaBox;
    private BrowseChooser browseChooser;
    private JLabel labelOutPath;
    private JLabel labelOutputName;
    private JLabel labelCurrentPath;
    private JLabel labelMultimediaBox;
    private Style style;

    /**
     * Constructor.
     */
    public BasicConverterPanel() {

        final int ten = 10;

        style = new Style();

        outputPath = new JTextField("");
        outputPath.setColumns(ten);

        btnConverter = new JButton("Converter");
        btnConverter.setBackground(Color.WHITE);
        btnConverter.setIcon(new javax.swing.ImageIcon("Image\\converter.PNG"));

        outputFileName = new JTextField();
        outputFileName.setColumns(ten);

        currentPath = new JTextField();
        currentPath.setColumns(ten);

        browseChooser = new BrowseChooser();
        browseChooser.setPath(outputPath);
        browseChooser.setBackground(Color.WHITE);


        multimediaBox = new JComboBox<>(new String[]{"Video", "Audio"});
        labelOutPath = new JLabel("Output File :");
        labelOutputName = new JLabel("File Name :");
        labelCurrentPath = new JLabel("Current Path :");
        labelMultimediaBox = new JLabel("Multimedia :");


        btnConverter.setFont(style.getFont());
        outputPath.setFont(style.getFont());
        outputFileName.setFont(style.getFont());
        currentPath.setFont(style.getFont());
        browseChooser.setFont(style.getFont());
        multimediaBox.setFont(style.getFont());

        labelOutPath.setFont(style.getFont());
        labelOutputName.setFont(style.getFont());
        labelCurrentPath.setFont(style.getFont());
        labelMultimediaBox.setFont(style.getFont());


        container = new JPanel(new GridBagLayout());
        this.setVisible(true);
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

        this.setBackground(Color.WHITE);
        container.setBackground(Color.WHITE);
        final Font font = new Font("Tahoma", 0, 11);
        final Color orangeColor = new Color(255, 51, 0);
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.
                        createLineBorder(orangeColor), "Basic Search",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                font, orangeColor));

        GridBagConstraints bagConstraints = new GridBagConstraints();

        bagConstraints.insets = new Insets(0, 0, 0, 0);
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;

        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        labelOutputName.setHorizontalAlignment(SwingConstants.RIGHT);

        container.add(labelOutputName, bagConstraints);
        bagConstraints.gridx = one;
        bagConstraints.gridy = 0;
        container.add(outputFileName, bagConstraints);

        bagConstraints.gridx = 0;
        bagConstraints.gridy = one;
        labelCurrentPath.setHorizontalAlignment(SwingConstants.RIGHT);
        container.add(labelCurrentPath, bagConstraints);

        bagConstraints.gridx = one;
        bagConstraints.gridy = one;
        container.add(currentPath, bagConstraints);

        bagConstraints.gridx = 0;
        bagConstraints.gridy = tree;
        labelOutPath.setHorizontalAlignment(SwingConstants.RIGHT);
        container.add(labelOutPath, bagConstraints);
        bagConstraints.gridx = one;
        bagConstraints.gridy = tree;
        container.add(outputPath, bagConstraints);
        bagConstraints.gridx = two;
        bagConstraints.gridy = tree;

        container.add(browseChooser, bagConstraints);

        bagConstraints.gridx = 0;
        bagConstraints.gridy = four;
        labelMultimediaBox.setHorizontalAlignment(SwingConstants.RIGHT);
        container.add(labelMultimediaBox, bagConstraints);

        bagConstraints.gridx = one;
        bagConstraints.gridy = four;
        container.add(multimediaBox, bagConstraints);

        bagConstraints.gridx = two;
        bagConstraints.gridy = four;

        container.add(btnConverter, bagConstraints);

        this.add(container);
    }

    /**
     * Getter of the Converter Button.
     *
     * @return JButton.
     */
    public static JButton getConverterButton() {
        return btnConverter;
    }

    /**
     * Getter of the outputpath.
     *
     * @return the Jtextfield.
     */
    public JTextField getOutputPath() {
        return outputPath;
    }

    /**
     * Getter of the output Name.
     *
     * @return JTextField
     */
    public JTextField getOutputName() {
        return outputFileName;
    }

    /**
     * Getter of the Text input field - Current Path.
     *
     * @return the JTextField.
     */
    public JTextField getCurrentPath() {
        return currentPath;
    }

    /**
     * Getter of the Browse Chooser.
     *
     * @return The BrowseChooser.
     */
    public BrowseChooser getBrowseChooser() {
        return browseChooser;
    }

    /**
     * Getter of the Combo Box - Multimedia.
     *
     * @return the JComboBox.
     */
    public static JComboBox<String> getMultimediaBox() {
        return multimediaBox;
    }

    /**
     * Setter of the Input Field - Path Source.
     *
     * @param pathSource input source path.
     */
    public static void setPathSource(final String pathSource) {
        currentPath.setText(pathSource);
    }

    /**
     * Setter of the Text input field-Path destination.
     *
     * @param pathDestination input path.
     */
    public static void setPathDestination(final String pathDestination) {
        outputPath.setText(pathDestination);
    }

    /**
     * Setter of the Text field-Output File name.
     *
     * @param outputName input name.
     */
    public static void setOutputFileName(final String outputName) {
        outputFileName.setText(outputName);
    }
}
