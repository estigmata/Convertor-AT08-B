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

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Class for the result panel.
 */
public class ResultTablePanel extends JPanel {
    private ResultTable resultTable;
    private JScrollPane resultScrollTable;

    /**
     * Constructor.
     */
    ResultTablePanel() {
        Object[] columns = {"Path", "File Name", "Extension", "Size [MB]"};
        resultTable = new ResultTable(columns);
        AbstractLogger log = AbstractLogger.getInstance();
        log.setLogger(TabPane.class.getName());
        log.info();
        setVisible(true);
        initComponents();
    }

    /**
     * Initialization of components.
     */
    void initComponents() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //Panel for the Search table.
        this.add(new JLabel("Files:"));
        this.add(new JScrollPane(resultTable));
    }

    /**
     * Getter for the result table.
     *
     * @return the Result table.
     */
    public ResultTable getResultTable() {
        return resultTable;
    }

}
