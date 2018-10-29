package org.fundacionjala.convertor.controller;

/**
 * Convertor.
 *
 * @author Roger alvarez.
 */
public final class Launcher {
    /**
     * Constructor not called.
     */
    private Launcher() {
    }

    /**
     * Main method.
     *
     * @param args type array of String.
     */
    public static void main(final String[] args) {

        ConvertorController controller = new ConvertorController();
        controller.actionConverter();
    }
}
