package org.fundacionjala.convertor.view;

import javax.swing.*;
import java.awt.*;

/**
 * Class for Finder
 */
public class Finder {
    private TabPane tabPane;
    private JButton button;
    private JTextField textField;
    private JLabel label;

    /**
     * Contructor
     *
     * @param tabPane input.
     */
    public Finder(TabPane tabPane) {
        this.tabPane = tabPane;
        button = new JButton("Find");
        textField = new JTextField("");
        label = new JLabel("What find?:");
    }

    /**
     * Initialization of Components.
     */
    public void initComponents() {
        button.setPreferredSize(new Dimension(50, 50));
    }

    /**
     * Making the structure.
     */
    public void Structure() {
        tabPane.setLayout(new GridLayout(3, 5));
        tabPane.getAudioPanel().add(label);
        tabPane.getAudioPanel().add(textField);
        tabPane.getAudioPanel().add(button);
    }
//This part will be the connection with the controller (William Renato)
    /**
     * Getter.
     *
     * @return OBJ.
     */
    public JButton getButton() {
        return button;
    }

    /**
     * Getter.
     *
     * @return OBJ.
     */
    public JTextField getTextField() {
        return textField;
    }
}
