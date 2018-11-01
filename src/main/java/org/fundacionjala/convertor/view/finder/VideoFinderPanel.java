/*
 * @VideoFinderPanel.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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


import javax.swing.JComboBox;

/**
 * Class for the Video Finder Panel, this will have the special advanced method for Videos.
 *
 * @author Rodrigo Menacho
 * @version 1.0
 */
public class VideoFinderPanel extends FinderPanel {
    /**
     * Initial Constructor.
     */
    public VideoFinderPanel() {
        super();
        multimediaBox = new JComboBox<>(new String[]{"mp4", "avi", "flv"});
    }
}
