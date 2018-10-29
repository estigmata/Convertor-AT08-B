package org.fundacionjala.convertor.view;

import javax.swing.*;
import java.awt.*;

public class UpperPanel extends JPanel {
    public UpperPanel() {
        initComponents();

    }
    private void initComponents(){
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
//        Panel for the explorer
        JPanel explorer = new JPanel();
        explorer.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        explorer.setBackground(Color.RED);
        this.add(explorer);
//        Panel for the Search Panel

        TabPane searchPanel = new TabPane();
        searchPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(searchPanel);

//        Panel for the Reproductor Panel
        JPanel reproductorPanel = new JPanel();
        reproductorPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(reproductorPanel);
    }
}
