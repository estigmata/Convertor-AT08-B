package org.fundacionjala.convertor.view;

import org.fundacionjala.convertor.utils.AbstractLogger;

import javax.swing.JOptionPane;

/**
 * Class of the message error.
 */
public class ErrorMessage extends JOptionPane {
    /**
     * Constructor for the error message.
     *
     * @param message input
     */
    public ErrorMessage(final String message) {
        AbstractLogger log = AbstractLogger.getInstance();
        log.setLogger(ErrorMessage.class.getName());
        showMessageDialog(null,
                message,
                "Error",
                JOptionPane.WARNING_MESSAGE);
        log.info();
    }
}
