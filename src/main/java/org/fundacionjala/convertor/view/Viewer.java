package org.fundacionjala.convertor.view;

import javax.swing.*;
import java.awt.*;

/**
 * Class of Viewer.
 */
public class Viewer extends JFrame {
    private JLabel title;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JTabbedPane tabbedPane;

    /**
     * Contructor.
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
        GridLayout gridLayout = new GridLayout(1, 1);
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
        Finder finder = new Finder(tabPane);
        finder.initComponents();
        finder.Structure();
        this.add(tabPane, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);

    }

    public static void main(String[] args) {
        Viewer viewer = new Viewer();
    }
}
