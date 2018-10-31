package org.fundacionjala.convertor.view.finder;

import javax.swing.JPanel;

/**
 * Class of the advanced search panel.
 */
public abstract class AdvancedPanel extends JPanel {
    /**
     * Constructor of the advanced panel.
     */
    public AdvancedPanel() {
        initComponents();
    }

    /**
     * Initialization of the components.
     */
    public abstract void initComponents();
}
