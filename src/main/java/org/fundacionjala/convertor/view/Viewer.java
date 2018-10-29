/*
 * @Viewer.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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

import org.fundacionjala.convertor.utils.AbstractLogger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Class Viewer.
 *
 * @author Rodrigo Menacho
 * @version 1.0
 */
public final class Viewer extends JFrame {

    private TabPane tabPane;
    private ResultTablePanel downPanel;

    /**
     * Constructor.
     */
    public Viewer() {
        super();
        AbstractLogger log = AbstractLogger.getInstance();
        log.setLogger(Viewer.class.getName());
        log.info();
        initComponents();
        configWindow();
    }

    /**
     * Config the JFrame.
     */
    private void configWindow() {
        this.setTitle("CONVERTER AT-08");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(500,500));
        this.pack();
        this.setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * Initialization of Components.
     */
    private void initComponents() {
        tabPane = new TabPane();
        //DECLARACION PANELES
        Container principalPane = this.getContentPane();
        principalPane.setLayout(new BoxLayout(principalPane, BoxLayout.Y_AXIS));

        UpperPanel upperPanel= new UpperPanel();
        principalPane.add(upperPanel);

        DownPanel downPanel = new DownPanel();
        downPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        principalPane.add(downPanel);
    }

    /**
     * Getter for the searchButton.
     *
     * @return the JObject
     */
    public JButton getSearchButton() {
        return tabPane.getAudioTabPanel().getFinderPanel().getSearchButton();
    }

    /**
     * Getter for the Path.
     *
     * @return the JObject.
     */
    public String getPath() {
        return tabPane.getAudioTabPanel().getFinderPanel().getPath().getText();
    }

    /**
     * Getter of the File Name String.
     *
     * @return String
     */
    public String getFileName() {
        return tabPane.getAudioTabPanel().getFinderPanel().getFileName().getText();
    }

    /**
     * Getter of the Size String.
     *
     * @return String
     */
    public String getSizeField() {
        return tabPane.getAudioTabPanel().getFinderPanel().getSizeField().getText();
    }

    /**
     * Getter the result table.
     *
     * @return the object DefaultTableModel.
     */
    public DefaultTableModel getResultTable() {
        return downPanel.getResultTable().getDefaultTableModel();
    }

    /**
     * Setter for the result table.
     *
     * @param defaultTableModel Input object of defaulttablemodel.
     */
    public void setResultTable(final DefaultTableModel defaultTableModel) {
        downPanel.getResultTable().setDefaultTableModel(defaultTableModel);
    }

    /**
     * Getter of the Extension Combo Box.
     *
     * @return JComboBox
     */
    public JComboBox getComboExtension() {
        return tabPane.getAudioTabPanel().getFinderPanel().getExtensionBox();
    }

    /**
     * Getter of the Size Combo box.
     *
     * @return JComboBox
     */
    public JComboBox getComboSize() {
        return tabPane.getAudioTabPanel().getFinderPanel().getSizeBox();
    }
}
