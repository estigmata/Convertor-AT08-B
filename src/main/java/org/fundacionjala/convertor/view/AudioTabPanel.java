/*
 * @AudioTabPanel.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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
 *
 * @author Rodrigo Menacho
 * @version 1.0
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
