package org.fundacionjala.convertor.view;

import org.fundacionjala.convertor.utils.VLCMediaPlayer;
import org.fundacionjala.convertor.view.finder.FinderPanel;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;


/**
 * Class of the upper panel who contais 3 panels.
 */
public class UpperPanel extends JPanel {
    private FinderPanel searchPanel;
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
        searchPanel = new FinderPanel();
        searchPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(searchPanel);

//        Panel for the Reproductor Panel
        VLCMediaPlayer reproductorPanel = new VLCMediaPlayer();
        reproductorPanel.setPreferredSize(new Dimension(500,300));
        reproductorPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
        this.add(reproductorPanel);
    }

    public FinderPanel getSearchPanel() {
        return searchPanel;
    }
}
