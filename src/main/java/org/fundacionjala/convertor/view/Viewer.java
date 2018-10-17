package org.fundacionjala.convertor.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class of Viewer.
 */
public class Viewer extends JFrame {
    private JLabel title;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JTabbedPane tabbedPane;
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

    }

    public Finder getFinder() {
        return finder;
    }

    public static void main(String[] args) {
        Viewer viewer = new Viewer();

        System.out.println(viewer.getFinder().getPath());
    }

}
