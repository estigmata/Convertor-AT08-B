package org.fundacionjala.convertor.view;

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
        showMessageDialog(null,
                message,
                "Error",
                JOptionPane.WARNING_MESSAGE);
    }
}
