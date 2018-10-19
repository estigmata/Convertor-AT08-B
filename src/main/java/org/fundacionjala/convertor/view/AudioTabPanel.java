/*
 * @AudioTabPanel.java Copyright (c) 2018 Jalasoft.
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

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;


/**
 * Class JPanel-Audio Panel.
 */
public class AudioTabPanel extends JPanel {
    private FinderPanel finderPanel;
    private JScrollPane tableContainer;
    private JTable resultTable;
    private DefaultTableModel defaultTableModel;

    /**
     * Constructor.
     */
    public AudioTabPanel() {
        finderPanel = new FinderPanel();
        this.setLayout(new GridLayout(0, 1));
        initComponents();
    }

    /**
     * Initialization of Components.
     */
    private void initComponents() {
        final int tableContainerWidth = 400;
        final int tableContainerHeight = 50;
        finderPanel.initComponents();
        JLabel resultTitle = new JLabel("Results");
        createTable();
        this.add(finderPanel, BorderLayout.NORTH);
        this.add(resultTitle);
        this.add(tableContainer, BorderLayout.SOUTH);
        tableContainer.setPreferredSize(new Dimension(tableContainerWidth, tableContainerHeight));
    }

    /**
     * Creation of the table.
     */
    private void createTable() {
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Path");
        defaultTableModel.addColumn("File Name");
        resultTable = new JTable(defaultTableModel);
        tableContainer = new JScrollPane(resultTable);
    }

    /**
     * Getter of default table model.
     *
     * @return the default table.
     */
    public DefaultTableModel getDefaultTableModel() {
        return defaultTableModel;
    }

    /**
     * Getter FinderClass.
     *
     * @return FinderPanel.
     */
    public FinderPanel getFinderPanel() {
        return finderPanel;
    }

    /**
     * Setter the default table mode.
     *
     * @param defaultTableModel input object.
     */
    public void setDefaultTableModel(final DefaultTableModel defaultTableModel) {
        this.defaultTableModel = defaultTableModel;
    }
}
