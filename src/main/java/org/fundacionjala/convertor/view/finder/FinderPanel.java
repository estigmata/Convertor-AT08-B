/*
 * @FinderPanel.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * Please contact Fundacion Jala, 2643 Av Melchor Perez de Olguin, Colquiri
 * Sud, Cochabamba, Bolivia. www.fundacion-jala.org if you need additional
 * information or have any questions.
 */
package org.fundacionjala.convertor.view.finder;


import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Class FinderPanel.
 *
 * @author Rodrigo Menacho
 * @version 1.0
 */
public class FinderPanel extends JPanel {


    private BasicSearchPanel basicSearchPanel;
    private AudioSearchPanel audioSearchPanel;
    private VideoSearchPanel videoSearchPanel;

    /**
     * Constructor.
     */
    public FinderPanel() {
        TitledBorder title = BorderFactory.createTitledBorder("Search");
        this.setBorder(title);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        basicSearchPanel = new BasicSearchPanel();
        this.add(basicSearchPanel);


        audioSearchPanel = new AudioSearchPanel();
        this.add(audioSearchPanel);

        videoSearchPanel = new VideoSearchPanel();
        this.add(videoSearchPanel);


        initComponents();
    }

    /**
     * Initialization of Components.
     */
    public void initComponents() {

    }

    /**
     * @return .
     */
    public BasicSearchPanel getBasicSearchPanel() {
        return basicSearchPanel;
    }

    /**
     * @param basicSearchPanel .
     */
    public void setBasicSearchPanel(final BasicSearchPanel basicSearchPanel) {
        this.basicSearchPanel = basicSearchPanel;
    }

    /**
     * @return .
     */
    public AudioSearchPanel getAudioSearchPanel() {
        return audioSearchPanel;
    }

    /**
     * @param audioSearchPanel .
     */
    public void setAudioSearchPanel(final AudioSearchPanel audioSearchPanel) {
        this.audioSearchPanel = audioSearchPanel;
    }

    /**
     * @return .
     */
    public VideoSearchPanel getVideoSearchPanel() {
        return videoSearchPanel;
    }

    /**
     * @param videoSearchPanel .
     */
    public void setVideoSearchPanel(final VideoSearchPanel videoSearchPanel) {
        this.videoSearchPanel = videoSearchPanel;
    }


}
