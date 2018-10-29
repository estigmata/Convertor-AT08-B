/*
 * @ResultTable.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Abstract Class for the Table of results.
 */
public class ResultTable extends JTable {
    private DefaultTableModel defaultTableModel;

    /**
     * Constructor for the table.
     */
    public ResultTable(Object[] tags) {
        AbstractLogger log = AbstractLogger.getInstance();
        log.setLogger(ResultTable.class.getName());
        defaultTableModel = new DefaultTableModel();
        //Object[] columns = {"Path", "File Name", "Extension", "Size [MB]"};
        Object[] columns = tags;
        defaultTableModel.setColumnIdentifiers(columns);
        this.setModel(defaultTableModel);
        log.info();
    }

    /**
     * Setter for the table content.
     *
     * @param defaultTableModel input.
     */
    public void setDefaultTableModel(final DefaultTableModel defaultTableModel) {
        this.defaultTableModel = defaultTableModel;
    }

    /**
     * Getter for the table content.
     *
     * @return the object.
     */
    public DefaultTableModel getDefaultTableModel() {
        return defaultTableModel;
    }
}
