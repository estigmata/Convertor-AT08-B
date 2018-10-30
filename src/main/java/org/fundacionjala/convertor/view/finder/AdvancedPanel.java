package org.fundacionjala.convertor.view.finder;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;

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
