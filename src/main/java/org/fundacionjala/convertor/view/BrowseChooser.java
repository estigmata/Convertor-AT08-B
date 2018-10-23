/*
 * @testchooser.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is the Browse file class.
 *
 * @author Rodrigo Menacho
 * @version 1.0
 */
public class BrowseChooser extends JPanel implements ActionListener {
    private JTextField path;

    /**
     * Constructor for the Browser, the panel have the button with their Action Listener.
     */
    public BrowseChooser() {
        AbstractLogger log = AbstractLogger.getInstance();
        log.setLogger(BrowseChooser.class.getName());
        JButton browse = new JButton("Browse...");
        browse.addActionListener(this);
        path = new JTextField();
        add(browse);
        log.info();
    }

    /**
     * Setter for update the JTextField path.
     * @param path Input of the FinderPanel current JTextField.
     */
    public void setPath(final JTextField path) {
        this.path = path;
    }

    /**
     * Action event for update the Path.
     * @param e the current action event.
     */
    public void actionPerformed(final ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Search Files");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false); // disable the "All files" option.
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            path.setText(String.valueOf(chooser.getSelectedFile()));
        }
    }

}
