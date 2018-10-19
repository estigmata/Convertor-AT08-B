/*
 * Viewer.java Copyright (c) 2018 Jalasoft.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jalasoft, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package org.fundacionjala.convertor.view;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;


/**
 * Class of Viewer.
 * <p>
 * Created by Rodrigo Menacho.
 */
public final class Viewer extends JFrame {

    private TabPane tabPane;

    /**
     * Constructor.
     */
    private Viewer() {
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
        this.setResizable(false);
        this.pack();
    }

    /**
     * Initialization of Components.
     */
    private void initComponents() {
        tabPane = new TabPane();
        tabPane.initComponents();
        this.getContentPane().add(tabPane);
        this.pack();
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
        return tabPane.getAudioTabPanel().getFinderPanel().getPathText();
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
    //Ignore This, just its for tests
    /*public static void main(String[] args) {
        Viewer viewer = new Viewer();
    }*/

}
