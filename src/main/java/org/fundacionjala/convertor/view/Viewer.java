package org.fundacionjala.convertor.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
        return finder.getSearchButton();
    }

    /**
     * Getter for the Path.
     *
     * @return the JObject.
     */
    public String getPath() {
        return finder.getPath().getText();
    }


    //Ignore This, just its for tests
    public static void main(String[] args) {
        Viewer viewer = new Viewer();
    }

}
