/*
 * @TabPane.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.event.KeyEvent;

/**
 * Class of the tabs.
 *
 * @author Rodrigo Menacho
 * @version 1.0
 */
public class TabPane extends JPanel {
    private JTabbedPane tabbedPane;
    private JPanel videoPanel;
    private JPanel converterPanel;
    private AudioTabPanel audioTabPanel;

    /**
     * Constructor.
     */
    TabPane() {
        AbstractLogger log = AbstractLogger.getInstance();
        log.setLogger(TabPane.class.getName());
        tabbedPane = new JTabbedPane();
        audioTabPanel = new AudioTabPanel();
        videoPanel = new JPanel();
        converterPanel = new JPanel();
        log.info();
        initComponents();
    }

    /**
     * Initialization of components.
     */
    void initComponents() {
        addAudioTab();
        addVideoTab();
        addConverterTab();
        //Add the tabbed pane to this panel.
        add(tabbedPane);
        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }

    /**
     * Audio Tab.
     */
    private void addAudioTab() {
        tabbedPane.addTab("Audio", audioTabPanel);
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
    }

    /**
     * Video Tab.
     */
    private void addVideoTab() {
        tabbedPane.addTab("Video", videoPanel);
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
    }

    /**
     * Converter Tab.
     */
    private void addConverterTab() {
        tabbedPane.addTab("Converter", converterPanel);
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
    }

    /**
     * Getter audio panel.
     *
     * @return JAudioPanel.
     */
    public AudioTabPanel getAudioTabPanel() {
        return audioTabPanel;
    }

    /**
     * Getter Video panel.
     *
     * @return JVideoPanel.
     */
    public JPanel getVideoPanel() {
        return videoPanel;
    }

    /**
     * Getter Converter Panel.
     *
     * @return JConverterPanel.
     */
    public JPanel getConverterPanel() {
        return converterPanel;
    }

}
