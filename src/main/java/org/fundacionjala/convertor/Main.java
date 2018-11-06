/**
 * @(#)Main.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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

package org.fundacionjala.convertor;

import org.fundacionjala.convertor.controller.SearchController;
import org.fundacionjala.convertor.utils.AbstractLogger;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;

/**
 *
 * Class Main.
 *
 * @author Nestor Otondo [nestor.otondo@fundacion-jala.org]
 * @version 1.0
 *
 */
public final class Main {
    private static AbstractLogger log;

    /**
     * Constructor not called.
     */
    private Main() {
    }

    /**
     * Main method.
     * @param args type array of String.
     */
    public static void main(final String[] args) {
        new NativeDiscovery().discover();
        log = AbstractLogger.getInstance();
        SearchController controller = new SearchController();
        controller.actionSearch();
        log.setLogger(SearchController.class.getName());
        log.info();
    }

}
