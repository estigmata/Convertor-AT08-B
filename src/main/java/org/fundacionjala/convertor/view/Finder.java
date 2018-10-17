package org.fundacionjala.convertor.view;

import javax.swing.*;
import java.awt.*;

/**
 * Class for Finder
 */
public class Finder {
    private TabPane tabPane;
    private JButton searchButton;
    private JTextField path;
    private JLabel label;

    /**
     * Constructor.
     *
     * @param tabPane input.
     */
    public Finder(TabPane tabPane) {
        this.tabPane = tabPane;
        path = new JTextField("");
        label = new JLabel("What find?:");
        searchButton = new JButton("Find");

    }

    /**
     * Initialization of Components.
     */
    void initComponents() {
        searchButton.setPreferredSize(new Dimension(50, 50));
    }

    /**
     * Making the structure.
     */
    public void Structure() {
        tabPane.setLayout(new GridLayout(3, 5));
        tabPane.getAudioPanel().add(label);
        tabPane.getAudioPanel().add(path);
        tabPane.getAudioPanel().add(searchButton);
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JTextField getPath() {
        return path;
    }
}
