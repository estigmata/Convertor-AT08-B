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
import javax.swing.JPanel;
import java.awt.Dimension;

/**
 * Class for the result panel.
 */
public class ResultTablePanel extends JPanel {
    private FilesPanelContainer filesPanel;
    private Information informationPanel;

    /**
     * Constructor.
     */
    ResultTablePanel() {
        filesPanel = new FilesPanelContainer();
        informationPanel = new Information();
        AbstractLogger log = AbstractLogger.getInstance();
        log.setLogger(TabPane.class.getName());
        log.info();
        initComponents();
    }

    /**
     * Initialization of components.
     */
    private void initComponents() {
        final int widthInfo = 200;
        final int heightInfo = 200;

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.add(filesPanel);

        informationPanel.setPreferredSize(new Dimension(widthInfo, heightInfo));
        informationPanel.showInformation();
        this.add(informationPanel);
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
