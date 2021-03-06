/*
 * @Viewer.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * Please contact Fundacion Jala, 2643 Av Melchor Perez de Olguin, Colquiri
 * Sud, Cochabamba, Bolivia. www.fundacion-jala.org if you need additional
 * information or have any questions.
 */
package org.fundacionjala.convertor.view;

import org.fundacionjala.convertor.utils.AbstractLogger;
import org.fundacionjala.convertor.view.finder.BasicSearchPanel;


import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;


/**
 * Class Viewer.
 *
 * @author Rodrigo Menacho
 * @author Abel Gustavo Mallcu Chiri.
 * @version 1.0
 */
public final class Viewer extends JFrame {

    private TitlePanel titlePanel;
    private DownPanel downPanel;
    private UpperPanel upperPanel;
    private static AbstractLogger log = AbstractLogger.getInstance();

    /**
     * Constructor.
     */
    public Viewer() {
        super();
        log.setLogger(Viewer.class.getName());
        log.info("Set Viewer");
        this.setIconImage(new javax.swing.ImageIcon("Image\\monkey2.PNG").getImage());
    }

    /**
     * Config the JFrame.
     */
    public void configWindow() {
        final int widthAll = 800;
        final int heightAll = 620;
        final int heightMin = 650;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(widthAll, heightAll));
        this.setMinimumSize(new Dimension(widthAll, heightMin));
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setBackground(Color.BLACK);
    }

    /**
     * Initialization of Components.
     */
    public void initComponents() {
        final int width = 800;
        final int heigth1 = 25;
        final int heigth2 = 250;
        final int heigth3 = 320;

        Container principalPane = this.getContentPane();

        principalPane.setLayout(new BoxLayout(principalPane, BoxLayout.Y_AXIS));

        titlePanel = new TitlePanel();
        titlePanel.setSize(new Dimension(width, heigth1));
        principalPane.add(titlePanel);

        upperPanel = new UpperPanel();
        upperPanel.setSize(new Dimension(width, heigth2));
        principalPane.add(upperPanel);

        downPanel = new DownPanel();
        downPanel.setSize(new Dimension(width, heigth3));
        principalPane.add(downPanel);

    }

    /**
     * Getter for the searchButton.
     *
     * @return the JObject
     */
    public JButton getSearchButton() {
        return upperPanel.getSearchPanel().getBasicSearchPanel().getSearchButton();
    }

    /**
     * Getter for the Path.
     *
     * @return the JObject.
     */
    public String getPath() {
        return BasicSearchPanel.getPath().getText();
    }

    /**
     * Getter of the File Name String.
     *
     * @return String
     */
    public String getFileName() {
        return upperPanel.getSearchPanel().getBasicSearchPanel().getFileName().getText();
    }

    /**
     * Getter of the Size String.
     *
     * @return String
     */
    public String getSizeField() {
        return upperPanel.getSearchPanel().getBasicSearchPanel().getSizeField().getText();
    }

    /**
     * Getter of the down panel.
     *
     * @return the Down panel object.
     */
    public DownPanel getDownPanel() {
        return downPanel;
    }

    /**
     * Getter of the ComboMultimedia Combo Box.
     *
     * @return JComboBox
     */
    public JComboBox getComboMultimedia() {
        return upperPanel.getSearchPanel().getBasicSearchPanel().getMultimediaBox();
    }

    /**
     * Getter of the upper panel.
     *
     * @return the Upper panel object
     */
    public UpperPanel getUpperPanel() {
        return upperPanel;
    }


}
