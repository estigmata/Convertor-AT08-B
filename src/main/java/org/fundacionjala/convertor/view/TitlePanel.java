package org.fundacionjala.convertor.view;

import javax.swing.*;

public class TitlePanel extends JPanel {
    private JLabel title;



    /**
     * Constructor for the initialization of the components.
     */
    public TitlePanel() {
        title = new JLabel();
        title.setIcon(new javax.swing.ImageIcon("C:\\Users\\GUSTAVO\\Desktop\\logo.PNG"));
        initComponents();
    }

    /**
     * Initialization of the .
     */
    private void initComponents() {
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.add(title);
    }

}
