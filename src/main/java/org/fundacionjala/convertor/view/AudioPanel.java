package org.fundacionjala.convertor.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Audio Panel.
 */
public class AudioPanel extends JPanel {
    private Finder finder;
    private JScrollPane tableContainer;

    /**
     * Constructor.
     */
    public AudioPanel() {
        finder = new Finder();
        tableContainer = new JScrollPane();
        this.setLayout(new GridLayout(0,1));
        initComponents();
    }

    /**
     * Initialization of Components.
     */
    private void initComponents() {
        finder.initComponents();
        DefaultTableModel columnNames = new DefaultTableModel();
        columnNames.addColumn("Path");
        columnNames.addColumn("File Name");
        JTable resultTable = new JTable(columnNames);
        tableContainer = new JScrollPane(resultTable);
        tableContainer.setPreferredSize(new Dimension(400,50));
        JLabel resultTitle = new JLabel("Results");
        this.add(finder.getPanelFinder(), BorderLayout.NORTH);
        this.add(resultTitle);
        this.add(tableContainer, BorderLayout.SOUTH);
    }
}
