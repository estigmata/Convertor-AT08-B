
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


import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;


/**
 * Class Viewer.
 *
 * @author Abel Gustavo Mallcu Chiri.
 * @version 1.0
 */
public class TitlePanel extends JPanel {

    private JLabel logo;
    private JPanel container;

    /**
     * Constructor for the initialization of the components.
     */
    public TitlePanel() {

        final int width = 800;
        final int heigth = 25;

        this.setBackground(Color.WHITE);
        this.setLayout(new GridBagLayout());

        container = new JPanel();
        container.setSize(new Dimension(width, heigth));
        container.setBackground(Color.white);
        logo = new JLabel();
        logo.setIcon(new javax.swing.ImageIcon("Image\\mono_logo.PNG"));

        initComponents();

    }

    /**
     * Initialization and add of the components.
     */
    private void initComponents() {
        this.add(logo);
        this.add(container);
    }

}
