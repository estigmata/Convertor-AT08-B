package org.fundacionjala.convertor.view;

import org.fundacionjala.convertor.view.explorer.Explorer;
import org.fundacionjala.convertor.view.finder.FinderPanel;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

/**
 * @author Abel Gustavo Mallcu Chiri.
 * Class of the upper panel who contais 3 panels.
 */
public class UpperPanel extends JPanel {
    private FinderPanel searchPanel;
    private MediaPlayerPanel mediaPlayer;

    /**
     * Constructor for the initialization of the components.
     */
    public UpperPanel() {
        initComponents();
    }

    /**
     * Initialization of the .
     */
    private void initComponents() {
        final int color = 64;
        final int height = 250;
        final int width1 = 200;
        final int width2 = 300;
        final int width3 = 300;

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        Explorer explorer = new Explorer();
        explorer.setBackground(Color.white);
        explorer.setPreferredSize(new Dimension(width1, height));
        this.add(explorer);

        searchPanel = new FinderPanel();
        searchPanel.setPreferredSize(new Dimension(width2, height));
        this.add(searchPanel);

        mediaPlayer = new MediaPlayerPanel();
        mediaPlayer.setPreferredSize(new Dimension(width3, height));
        mediaPlayer.setBackground(new Color(color, color, color));
        this.add(mediaPlayer);
    }

    /**
     * Method to obtain the finderPanel object.
     *
     * @return search panel.
     */
    public FinderPanel getSearchPanel() {
        return searchPanel;
    }
}
