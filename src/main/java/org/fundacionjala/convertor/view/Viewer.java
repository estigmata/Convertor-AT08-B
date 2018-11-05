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


import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Container;

/**
 * Class Viewer.
 *
 * @author Rodrigo Menacho
 * @version 1.0
 */
public final class Viewer extends JFrame {

    private DownPanel downPanel;
    private UpperPanel upperPanel;

    /**
     * Constructor.
     */
    public Viewer() {
        super();
        downPanel = new DownPanel();
        AbstractLogger log = AbstractLogger.getInstance();
        log.setLogger(Viewer.class.getName());
        log.info();
        initComponents();
        configWindow();
    }

    /**
     * Config the JFrame.
     */
    private void configWindow() {
        this.setTitle("CONVERTER AT-08");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
    }

    /**
     * Initialization of Components.
     */
    private void initComponents() {
        //DECLARACION PANELES
        Container principalPane = this.getContentPane();
        principalPane.setLayout(new BoxLayout(principalPane, BoxLayout.Y_AXIS));

        upperPanel = new UpperPanel();
        principalPane.add(upperPanel);

        downPanel = new DownPanel();
        downPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
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
        return upperPanel.getSearchPanel().getBasicSearchPanel().getPath().getText();
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
     * Getter of the ComboChannel Combo Box.
     *
     * @return JComboBox
     */
    public JComboBox getComboChannel() {
        return upperPanel.getSearchPanel().getAudioSearchPanel().getChannel();
    }

    /**
     * Getter of the ComboAudioCodec Combo Box.
     *
     * @return JComboBox
     */
    public JComboBox getComboAudioCodec() {
        return upperPanel.getSearchPanel().getAudioSearchPanel().getAudioCodec();
    }

    /**
     * Getter of the ComboFrameRate Combo Box.
     *
     * @return JComboBox
     */
    public JComboBox getComboFrameRate() {
        return upperPanel.getSearchPanel().getVideoSearchPanel().getFrameRate();
    }

    /**
     * Getter of the ComboAspectRatio Combo Box.
     *
     * @return JComboBox
     */
    public JComboBox getComboAspectRatio() {
        return upperPanel.getSearchPanel().getVideoSearchPanel().getAspectRatio();
    }

    /**
     * Getter of the ComboResolution Combo Box.
     *
     * @return JComboBox
     */
    public JComboBox getComboResolution() {
        return upperPanel.getSearchPanel().getVideoSearchPanel().getResolution();
    }

    /**
     * Getter of the ComboVideoCodec Combo Box.
     *
     * @return JComboBox
     */
    public JComboBox getComboVideoCodec() {
        return upperPanel.getSearchPanel().getVideoSearchPanel().getVideoCodec();
    }

    /**
     * Getter of the ComboAudioCodecVideo Combo Box.
     *
     * @return JComboBox
     */
    public JComboBox getComboAudioCodecVideo() {
        return upperPanel.getSearchPanel().getVideoSearchPanel().getAudioCodec();
    }
}
