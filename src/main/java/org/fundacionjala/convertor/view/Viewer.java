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

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 * Class Viewer.
 *
 * @author Rodrigo Menacho
 * @version 1.0
 */
public final class Viewer extends JFrame {

    private TabPane tabPane;

    /**
     * Constructor.
     */
    public Viewer() {
        super();
        configWindow();
        initComponents();
    }

    /**
     * Config the JFrame.
     */
    private void configWindow() {
        this.setTitle("CONVERTER AT-08");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.pack();
    }

    /**
     * Initialization of Components.
     */
    private void initComponents() {
        tabPane = new TabPane();
        tabPane.initComponents();
        this.getContentPane().add(tabPane);
        this.setVisible(true);
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
     * Getter the result table.
     *
     * @return the object DefaultTableModel.
     */
    public DefaultTableModel getResultTable() {
        return tabPane.getAudioTabPanel().getDefaultTableModel();
    }

    /**
     * Setter for the result table.
     *
     * @param defaultTableModel Input object of defaulttablemodel.
     */
    public void setResultTable(final DefaultTableModel defaultTableModel) {
        tabPane.getAudioTabPanel().setDefaultTableModel(defaultTableModel);
    }

//    //Ignore This, just its for tests
//    public static void main(String[] args) {
//        Viewer viewer = new Viewer();
//    }

}
