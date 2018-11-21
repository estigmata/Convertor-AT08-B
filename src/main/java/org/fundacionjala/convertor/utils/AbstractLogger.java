/**
 * @(#)AbstractLogger.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * <p>
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 * <p>
 * Please contact Fundacion Jala, 2643 Av Melchor Perez de Olguin, Colquiri
 * Sud, Cochabamba, Bolivia. www.fundacion-jala.org if you need additional
 * information or have any questions.
 */

package org.fundacionjala.convertor.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class AbstractLogger.
 *
 * @author Nestor Otondo [nestor.otondo@fundacion-jala.org]
 * @version 1.0
 */
public final class AbstractLogger {
    private static AbstractLogger instance;
    private Logger logger;

    /**
     * Private constructor in order to implement Singleton Pattern.
     */
    private AbstractLogger() {
    }

    /**
     * Method to get an Instance.
     *
     * @return an instance of Abstract Logger class.
     */
    public static AbstractLogger getInstance() {
        if (instance == null) {
            instance = new AbstractLogger();
        }

        return instance;
    }

    /**
     * Set logger to trace a specific class.
     *
     * @param className type String.
     */
    public void setLogger(final String className) {
        logger = LogManager.getLogger(className);
    }

    /**
     * Method to append info.
     *
     * @param message input String message.
     */
    public void info(final String message) {
        logger.info(message);
    }

    /**
     * Method to append error.
     *
     * @param exception type Exception.
     */
    public void error(final Exception exception) {
        logger.error(exception.getMessage(), exception);
    }

    /**
     * Method to append debug message.
     *
     * @param message type String.
     */
    public void debug(final String message) {
        logger.debug(message);
    }

    /**
     * Method to append trace with message and object.
     *
     * @param message type String.
     * @param object type Object.
     */
    public void trace(final String message, final Object object) {
        logger.trace(message, object);
    }
}
