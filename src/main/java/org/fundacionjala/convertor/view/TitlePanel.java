
/*
 * @TitlePanel.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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

package org.fundacionjala.convertor.view;


import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class Viewer.
 *
 * @author Abel Gustavo Mallcu Chiri.
 * @version 1.0
 */
public class TitlePanel extends JPanel {
    private JLabel title;

    /**
     * Constructor for the initialization of the components.
     */
    public TitlePanel() {
        title = new JLabel();
        title.setIcon(new javax.swing.ImageIcon("Image\\logo.PNG"));
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