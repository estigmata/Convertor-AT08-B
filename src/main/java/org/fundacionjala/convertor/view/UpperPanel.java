package org.fundacionjala.convertor.view;

import org.fundacionjala.convertor.utils.VLCMediaPlayer;
import org.fundacionjala.convertor.view.finder.FinderPanel;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.Color;


/**
 * Class of the upper panel who contais 3 panels.
 */
public class UpperPanel extends JPanel {
    /**
     * Constructor for the initialization of the components.
     */
    public UpperPanel() {
        initComponents();

    }

    /**
     * Initialization of the components.
     */
    private void initComponents() {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
//        Panel for the explorer
        JPanel explorer = new JPanel();
        explorer.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        explorer.setBackground(Color.RED);
        this.add(explorer);
//        Panel for the Search Panel
        FinderPanel searchPanel = new FinderPanel();
        searchPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(searchPanel);

//        Panel for the Reproductor Panel
        VLCMediaPlayer reproductorPanel = new VLCMediaPlayer();
        reproductorPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
        this.add(reproductorPanel);
    }
}
