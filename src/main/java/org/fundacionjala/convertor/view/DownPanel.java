/*
 * @DownPanel.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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

import javax.swing.*;
import java.awt.*;

public class DownPanel extends JPanel {
    public DownPanel() {
        initComponents();

    }

    private void initComponents(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //Panel for the Search table.
        this.add(new JLabel("Files:"));
        Object[] columns = {"Path", "File Name", "Extension", "Size [MB]"};
        ResultTablePanel resultTable = new ResultTablePanel(columns);
        resultTable.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //resultTable.setBackground(Color.yellow);
        this.add(resultTable);

        //Panel for the converted file.
        this.add(new JLabel("Converted Files:"));
        Object[] columns1 = {"Path", "File Name", "Extension", "Size [MB]"};
        ResultTablePanel convertedTable = new ResultTablePanel(columns1);
        resultTable.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        resultTable.setBackground(Color.yellow);
        this.add(convertedTable);


    }
}
