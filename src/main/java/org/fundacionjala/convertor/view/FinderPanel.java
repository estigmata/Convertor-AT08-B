/*
 * FinderPanel.java Copyright (c) 2018 Jalasoft.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jalasoft, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package org.fundacionjala.convertor.view;

import javax.swing.*;
import java.awt.*;

/**
 * Class FinderPanel.
 */
public class FinderPanel extends JPanel{
    private JButton searchButton;
    private JTextField path;
    private JLabel label;


    /**
     * Constructor.
     */
    public FinderPanel() {
        path = new JTextField("");
        label = new JLabel("What find?:");
        searchButton = new JButton("Find");
        this.setLayout(new GridLayout(0, 3));
        this.setVisible(true);

    }

    /**
     * Initialization of Components.
     */
    void initComponents() {
        this.add(label);
        this.add(path);
        this.add(searchButton);
    }

    /**
     * Getter of the search button.
     *
     * @return JButton Object.
     */
    public JButton getSearchButton() {
        return searchButton;
    }

    /**
     * Getter of the Path.
     *
     * @return String.
     */
    public String getPathText() {
        return path.getText();
    }
}
