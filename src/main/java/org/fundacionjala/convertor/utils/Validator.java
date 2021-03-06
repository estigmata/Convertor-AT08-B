/*
 * @IsString.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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


import org.apache.tika.Tika;

import java.io.File;
import java.nio.file.Path;

/**
 * Validator.
 *
 * @author Roger alvarez.
 */
public class Validator {
    private static AbstractLogger log = AbstractLogger.getInstance();
    /**
     * Method that checks if an object is a String.
     *
     * @param obj is a Object.
     * @return Value of return of String Type.     *
     */
    public boolean isString(final Object obj) {
        return obj.equals(obj.toString());
    }

    /**
     * Method that checks if an object is a String.
     *
     * @param str is a file name String.
     * @return Value of return of String Type.     *
     */
    public boolean isInt(final String str) {
        log.setLogger(Validator.class.getName());
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {
            log.error(nfe);
            return false;
        }
    }

    /**
     * Method that checks if an String is a path valid.
     *
     * @param path is a path in String.
     * @return Value of return of String Type.
     */
    public boolean isPath(final String path) {
        File file = new File(path);
        return file.exists();
    }

    /**
     * This method ask if the path is video file.
     *
     * @param x input path.
     * @return if is video.
     */
    public boolean isVideo(final Path x) {
        String type = new Tika().detect(x.toFile().getAbsolutePath());
        return type.contains("video");
    }

    /**
     * This method ask if the path is video file.
     *
     * @param x input path.
     * @return if is video.
     */
    public boolean isAudio(final Path x) {
        String type = new Tika().detect(x.toFile().getAbsolutePath());
        return type.contains("audio");
    }
}
