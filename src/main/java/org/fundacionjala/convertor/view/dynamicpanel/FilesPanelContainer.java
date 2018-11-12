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

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

/**
 * Class Files Panel in order to show files detail list.
 *
 * @author Nestor Otondo [nestor.otondo@fundacion-jala.org]
 * @version 1.0
 */
public class FilesPanelContainer extends JPanel {
    private JPanel filesContainer;

    /**
     * Constructor Files Panel class.
     */
    public FilesPanelContainer() {
        setBorder(BorderFactory.createTitledBorder("Files"));
        setLayout(new BorderLayout());
        filesContainer = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        final int width = 620;
        final int height = 350;
        setPreferredSize(new Dimension(width, height));
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
        gbConstraints.weightx = 1;
        gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        for (Asset file : files) {
            Files itemFile = new Files(file);
            itemFile.setLayout(new BoxLayout(itemFile, BoxLayout.Y_AXIS));
            itemFile.add(new JLabel(file.getFileName().concat(".").concat(file.getExtension())));
            itemFile.setBorder(new MatteBorder(1, 1, 1, 1, Color.GRAY));
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
