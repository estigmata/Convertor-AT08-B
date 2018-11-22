/*
 * @FilesPanelContainer.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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

package org.fundacionjala.convertor.view.dynamicpanel;

import org.fundacionjala.convertor.model.objectfile.Asset;
import org.fundacionjala.convertor.utils.Style;


import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.util.ArrayList;

/**
 * Class Files Panel in order to show files detail list.
 *
 * @author Nestor Otondo [nestor.otondo@fundacion-jala.org]
 * @author Abel Gustavo Mallcu Chiri.
 * @version 1.0
 */
public class FilesPanelContainer extends JPanel {

    private JPanel filesContainer;
    private Style style;

    /**
     * Constructor Files Panel class.
     */
    public FilesPanelContainer() {
        style = new Style();
        final int rows = 9999;
        final Font font = new Font("Tahoma", 0, 11);
        final Color orangeColor = new Color(255, 51, 0);

        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.
                        createLineBorder(orangeColor), "Files",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                font, orangeColor));

        setLayout(new BorderLayout());

        this.setBackground(Color.white);
        filesContainer = new JPanel(new GridLayout(rows, 1));
        filesContainer.setBackground(Color.WHITE);

        add(new JScrollPane(filesContainer));

    }

    /**
     * Display files method to build panels dynamically.
     *
     * @param files input array
     */
    public void displayFiles(final ArrayList<Asset> files) {
        GridBagConstraints gbConstraints = new GridBagConstraints();
        gbConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        for (Asset file : files) {
            Files itemFile = new Files(file);
            itemFile.setLayout(new BoxLayout(itemFile, BoxLayout.Y_AXIS));
            JLabel labelAux = new JLabel();

            labelAux.setText(file.getFileName().concat(".").concat(file.getExtension()));
            labelAux.setFont(style.getFont());

            itemFile.add(labelAux);
            itemFile.setBorder(new MatteBorder(1, 1, 1, 1, Color.white));
            filesContainer.add(itemFile, gbConstraints, 0);
        }
        validate();
        repaint();
    }

    /**
     * Cleaner method of the dynamic panel.
     */
    public void cleanPanel() {
        filesContainer.removeAll();
    }
}
