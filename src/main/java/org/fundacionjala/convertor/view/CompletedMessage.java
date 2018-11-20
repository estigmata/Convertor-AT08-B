/*
 * @CompletedMessage.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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

import javax.swing.JOptionPane;

import static javax.swing.JOptionPane.showMessageDialog;

/**
 * Class of the message error.
 *
 * @author Rodrigo Menacho.
 */
public class CompletedMessage {
    /**
     * Constructor for the conversion completed message.
     *
     * @param message input
     */
    public CompletedMessage(final String message) {
        AbstractLogger log = AbstractLogger.getInstance();
        log.setLogger(ErrorMessage.class.getName());
        showMessageDialog(null,
                message,
                "Finished",
                JOptionPane.INFORMATION_MESSAGE);
        log.info("");
    }
}
