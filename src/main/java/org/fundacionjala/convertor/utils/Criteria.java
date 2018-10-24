
/*
 * @Criteria.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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
 * This class defines a search criterion object.
 *
 * @author Abel Gustavo Mallcu Chiri.
 * @version 1.0.
 */
public class Criteria {
    private String fileName;
    private String filePath;
    private long fileSize;
    private String fileExtention;

    /**
     * This method return the value of file Extention atributte.
     *
     * @return value of return.
     */
    public String getFileExtention() {
        return fileExtention;
    }

    /**
     * This method add the value of fileExtention atributte.
     *
     * @param fileExtention value of input.
     */
    public void setFileExtention(final String fileExtention) {
        this.fileExtention = fileExtention;
    }

    /**
     * This method return the value of fileName Atributte.
     *
     * @return value of return.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * This method add the value of fileName atributte.
     *
     * @param fileName value of input.
     */
    public void setFileName(final String fileName) {
        this.fileName = fileName;
    }

    /**
     * This method return the value of filePath atributte.
     *
     * @return value of return.
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * This method add the value of filePath atributte.
     *
     * @param filePath value of input.
     */
    public void setFilePath(final String filePath) {
        this.filePath = filePath;
    }

    /**
     * This method return the value of fileSize atributte.
     *
     * @return value of return.
     */
    public long getFileSize() {
        return fileSize;
    }

    /**
     * This method add the value of fileSize atributte.
     *
     * @param fileSize value of input.
     */
    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }


}
