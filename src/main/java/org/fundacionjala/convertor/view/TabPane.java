/*
 * TabPane.java Copyright (c) 2018 Jalasoft.
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

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.event.KeyEvent;

/**
 * Class of the tabs.
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
        tabbedPane = new JTabbedPane();
        audioTabPanel = new AudioTabPanel();
        videoPanel = new JPanel();
        converterPanel = new JPanel();
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
