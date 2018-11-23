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

import org.fundacionjala.convertor.view.Converter.ConverterPanel;
import org.fundacionjala.convertor.view.dynamicpanel.ResultTablePanel;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.Dimension;

/**
 * @author Abel Gustavo Mallcu Chiri.
 */
public class DownPanel extends JPanel {

    private ResultTablePanel resultTablePanel;
    private ConverterPanel converterPanel;

    /**
     * Constructor.
     */
    public DownPanel() {

        resultTablePanel = new ResultTablePanel();
        converterPanel = new ConverterPanel();

        initComponents();
    }

    /**
     *
     */
    private void initComponents() {


        final int height = 320;
        final int width1 = 450;
        final int width2 = 250;

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        resultTablePanel.setPreferredSize(new Dimension(width1, height));
        this.add(resultTablePanel);

        converterPanel.setPreferredSize(new Dimension(width2, height));
        this.add(converterPanel);
    }

    /**
     * Method to obtain result table panel.
     *
     * @return the Result Table panel.
     */
    public ResultTablePanel getResultTablePanel() {
        return resultTablePanel;
    }

    /**
     * @return the Result Convert panel.
     */

    public ConverterPanel getConverterPanel() {
        return converterPanel;
    }
}
