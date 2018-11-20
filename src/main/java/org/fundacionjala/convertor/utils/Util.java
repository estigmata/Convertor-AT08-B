
/*
 * @Util.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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

package org.fundacionjala.convertor.utils;

/**
 * this class contain utils for used in Model and controller.
 *
 * @author Abel Gustavo Mallcu Chiri.
 * @version 1.0.
 */
public class Util {
    private static final int ONE_1 = 1;

    /**
     * This method extract only the name of the File Name without the extension.
     *
     * @param path input String of the FileName.
     * @return the String of the File Name.
     */
    public String getStringName(final String path) {
        String[] aux = path.split("\\.");
        return aux.length == 1 ? "" : aux[0];
    }

    /**
     * Method to obtain the extension of a file.
     *
     * @param fileName is a file name.
     * @return Value of return of String Type.
     */
    public String getExtension(final String fileName) {
        String[] aux = fileName.split("\\.");
        return aux.length == 1 ? "" : aux[1];
    }

    /**
     * This method return the With of resolution.
     *
     * @param resolution parameter f input.
     * @return value of return.
     */

    public int getWith(final String resolution) {
        final int i = resolution.indexOf('*');
        return Integer.parseInt(resolution.substring(0, i));
    }

    /**
     * This method return the height of resolution.
     *
     * @param resolution parameter f input.
     * @return value of return.
     */
    public int getHeight(final String resolution) {
        final int length = resolution.length();
        final int i = resolution.indexOf('*');
        return Integer.parseInt(resolution.substring(i + ONE_1, length));
    }
}
