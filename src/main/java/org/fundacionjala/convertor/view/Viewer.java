package org.fundacionjala.convertor.view;

import javax.swing.*;
import java.awt.*;

/**
 * Class of Viewer.
 */
public class Viewer extends JFrame {
    private Finder finder;

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
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
    }

    /**
     * Initialization of Components.
     */
    private void initComponents() {
        TabPane tabPane = new TabPane();
        tabPane.initComponents();
        finder = new Finder(tabPane);
        finder.initComponents();
        finder.Structure();
        this.add(tabPane, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
        String[] columnNames = {"Path", "File Name"};
        String data[][] = {};
        JTable resultTable = new JTable(data, columnNames);
        resultTable.setVisible(true);
        tabPane.getAudioPanel().add(resultTable);
    }

    /**
     * Getter for the searchButton.
     *
     * @return the JObject
     */
    public JButton getSearchButton() {
        return finder.getSearchButton();
    }

    /**
     * Getter for the Path.
     *
     * @return the JObject.
     */
    public JTextField getPath() {
        return finder.getPath();
    }


    //Ignore This, just its for tests
    public static void main(String[] args) {
        Viewer viewer = new Viewer();
    }

}
