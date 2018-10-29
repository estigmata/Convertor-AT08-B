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

import javax.swing.*;

public class ResultTablePanel extends JPanel {
    private ResultTable resultTable;
    private JScrollPane resultScrollTable;

    /**
     * Constructor.
     */
    ResultTablePanel(Object[] tag) {
        resultTable= new ResultTable(tag);
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
        resultScrollTable= new JScrollPane(resultTable);
        this.add(resultScrollTable);
        //this.add(resultTable);
    }

    public ResultTable getResultTable() {
        return resultTable;
    }

}
