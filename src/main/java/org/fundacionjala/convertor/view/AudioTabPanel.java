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
        finderPanel.initComponents();
        JLabel resultTitle = new JLabel("Results");
        createTable();
        this.add(finderPanel, BorderLayout.NORTH);
        this.add(resultTitle);
        this.add(tableContainer, BorderLayout.SOUTH);
        tableContainer.setPreferredSize(new Dimension(400, 50));
    }

    /**
     * Creation of the table.
     */
    private void createTable() {
        DefaultTableModel columnNames = new DefaultTableModel();
        columnNames.addColumn("Path");
        columnNames.addColumn("File Name");
        resultTable = new JTable(columnNames);
        tableContainer = new JScrollPane(resultTable);
    }

    /**
     * Getter ResultTable.
     *
     * @return JTable.
     */
    public JTable getResultTable() {
        return resultTable;
    }

    /**
     * Getter FinderClass.
     *
     * @return FinderPanel.
     */
    public FinderPanel getFinderPanel() {
        return finderPanel;
    }
}
