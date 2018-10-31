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

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Container;

/**
 * Class Viewer.
 *
 * @author Rodrigo Menacho
 * @version 1.0
 */
public final class Viewer extends JFrame {

    private DownPanel downPanel;
    private UpperPanel upperPanel;

    /**
     * Constructor.
     */
    public Viewer() {
        super();
        downPanel = new DownPanel();
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
        this.pack();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
    }

    /**
     * Initialization of Components.
     */
    private void initComponents() {
        //DECLARACION PANELES
        Container principalPane = this.getContentPane();
        principalPane.setLayout(new BoxLayout(principalPane, BoxLayout.Y_AXIS));

        upperPanel = new UpperPanel();
        principalPane.add(upperPanel);

        downPanel = new DownPanel();
        downPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        principalPane.add(downPanel);
    }

    /**
     * Getter for the searchButton.
     *
     * @return the JObject
     */
    public JButton getSearchButton() {
        return upperPanel.getSearchPanel().getSearchButton();
    }

    /**
     * Getter for the Path.
     *
     * @return the JObject.
     */
    public String getPath() {
        return upperPanel.getSearchPanel().getPath().getText();
    }

    /**
     * Getter of the File Name String.
     *
     * @return String
     */
    public String getFileName() {
        return upperPanel.getSearchPanel().getFileName().getText();
    }

    /**
     * Getter of the Size String.
     *
     * @return String
     */
    public String getSizeField() {
        return upperPanel.getSearchPanel().getSizeField().getText();
    }

    /**
     * Getter the result table.
     *
     * @return the object DefaultTableModel.
     */
    public DefaultTableModel getResultTable() {
        return downPanel.getResultTablePanel().getResultTable();

    }

    /**
     * Getter of the Extension Combo Box.
     *
     * @return JComboBox
     */
    public JComboBox getComboMultimedia() {
        return upperPanel.getSearchPanel().getMultimediaBox();
    }

    /**
     * Getter of the Size Combo box.
     *
     * @return JComboBox
     */
    public JComboBox getComboSize() {
        return upperPanel.getSearchPanel().getSizeBox();
    }
}
