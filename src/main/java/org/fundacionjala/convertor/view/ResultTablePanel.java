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

import org.fundacionjala.convertor.model.objectfile.Asset;
import org.fundacionjala.convertor.utils.AbstractLogger;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 * Class for the result panel.
 */
public class ResultTablePanel extends JPanel {
  private FilesPanel resultTable;

  /**
   * Constructor.
   */
  ResultTablePanel() {
    resultTable = new FilesPanel();
    AbstractLogger log = AbstractLogger.getInstance();
    log.setLogger(TabPane.class.getName());
    log.info();
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
    resultTable.displayFiles();
  }

  /**
   * Getter for the result table.
   *
   * @return the Result table.
   */
    /*public DefaultTableModel getResultTable() {
        return resultTable.getDefaultTableModel();
    }*/
}
