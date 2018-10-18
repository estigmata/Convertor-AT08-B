package org.fundacionjala.convertor.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Class of the tabs.
 */
public class TabPane extends JPanel {
    private JTabbedPane tabbedPane;
    private JComponent audioPanel;
    private JComponent videoPanel;
    private JComponent converterPanel;
    /**
     * Constructor.
     */
    TabPane() {
        tabbedPane = new JTabbedPane();
        audioPanel = new JPanel();
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
     * Audio Tab
     */
    private void addAudioTab() {
        tabbedPane.addTab("Audio", new AudioPanel());
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
     * Converter Tab
     */
    private void addConverterTab() {
        tabbedPane.addTab("Converter", converterPanel);
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
    }

    /**
     * Getter audio panel.
     *
     * @return Component.
     */
    public JComponent getAudioPanel() {
        return audioPanel;
    }

    public JComponent getVideoPanel() {
        return videoPanel;
    }

    public JComponent getConverterPanel() {
        return converterPanel;
    }
}
