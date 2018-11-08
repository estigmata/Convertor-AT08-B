/*
 * @ResultTablePanel.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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

import org.fundacionjala.convertor.utils.AbstractLogger;
import org.fundacionjala.convertor.view.dynamicpanel.FilesPanelContainer;
import org.fundacionjala.convertor.view.dynamicpanel.Information;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

/**
 * Class for the result panel.
 */
public class ResultTablePanel extends JPanel {
    private FilesPanelContainer filesPanel;

    /**
     * Constructor.
     */
    ResultTablePanel() {
        filesPanel = new FilesPanelContainer();
        AbstractLogger log = AbstractLogger.getInstance();
        log.setLogger(TabPane.class.getName());
        log.info();
        initComponents();
    }

    /**
     * Initialization of components.
     */
    private void initComponents() {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        //Panel for the Search table.
        this.add(filesPanel);
        this.add(new Information());
    }

    /**
     * Getter of the Files Panel.
     *
     * @return the Files panel object.
     */
    public FilesPanelContainer getFilesPanel() {
        return filesPanel;
    }
}
