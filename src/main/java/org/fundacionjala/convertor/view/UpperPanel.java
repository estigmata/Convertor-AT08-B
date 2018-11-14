package org.fundacionjala.convertor.view;
import org.fundacionjala.convertor.view.explorer.Explorer;
import org.fundacionjala.convertor.view.finder.FinderPanel;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;


/**
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
        final int width = 500;
        final int heigth = 200;
        final int width2 = 460;
        final int heigth2 = 240;
        final int color = 64;

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        Explorer explorer = new Explorer();
        explorer.setBackground(Color.white);
        explorer.setPreferredSize(new Dimension(250, 300));
        this.add(explorer);

        searchPanel = new FinderPanel();
        searchPanel.setPreferredSize(new Dimension(350, 300));
        this.add(searchPanel);

        mediaPlayer = new MediaPlayerPanel();
        mediaPlayer.setPreferredSize(new Dimension(500, 300));
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
