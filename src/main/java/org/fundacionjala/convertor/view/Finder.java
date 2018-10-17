package org.fundacionjala.convertor.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Class for Finder
 */
public class Finder {
    private TabPane tabPane;
    private JButton button;
    private JTextField textField;
    private JLabel label;
    private String path;

    /**
     * Constructor.
     *
     * @param tabPane input.
     */
    public Finder(TabPane tabPane) {
        this.tabPane = tabPane;
        textField = new JTextField("");
        label = new JLabel("What find?:");
        button = new JButton("Find");

    }

    /**
     * Initialization of Components.
     */
    public void initComponents() {
        button.setPreferredSize(new Dimension(50, 50));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                path = textField.getText();
            }
        });
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

    public String getPath() {
        return path;
    }
}
