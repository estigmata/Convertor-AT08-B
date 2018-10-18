package org.fundacionjala.convertor.view;

import javax.swing.*;
import java.awt.*;

/**
 * Class for Finder
 */
public class Finder {
    private JButton searchButton;
    private JTextField path;
    private JLabel label;
    private JPanel panelFinder;

    /**
     * Constructor.
     */
    public Finder() {
        path = new JTextField("");
        label = new JLabel("What find?:");
        searchButton = new JButton("Find");
        panelFinder= new JPanel();
        panelFinder.setLayout(new GridLayout(0, 3));
        panelFinder.setVisible(true);

    }

    /**
     * Initialization of Components.
     */
    void initComponents() {
        panelFinder.add(label);
        panelFinder.add(path);
        panelFinder.add(searchButton);
    }

    public JPanel getPanelFinder() {
        return panelFinder;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JTextField getPath() {
        return path;
    }
}
