/*
 * @AudioFinderPanel.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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
 * Class finder for audio tab, this will include the advanced search.
 *
 * @author Rodrigo Menacho
 * @version 1.0
 */
public class AudioFinderPanel extends FinderPanel {
    /**
     * Constructor for Finder panel.
     */
    public AudioFinderPanel() {
        super();
        extensionBox = new JComboBox<>(new String[]{"mp3", "midi", "m4a"});
    }
}
