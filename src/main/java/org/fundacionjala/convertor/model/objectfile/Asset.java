/*
 * @Asset.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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

package org.fundacionjala.convertor.model.objectfile;

/**
 * Class for create a Object who have all the information of the file.
 *
 * @author Rodrigo Menacho
 * @version 1.0
 */
public class Asset {

    private String fileName;
    private String path;
    private long fileSize;
    private String extension;

    /**
     * Getter of the File name.
     *
     * @return the String.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Getter of the Path.
     *
     * @return the whole path.
     */
    public String getPath() {
        return path;
    }

    /**
     * Getter of the Size.
     *
     * @return the long integer in bytes.
     */
    public long getFileSize() {
        return fileSize;
    }

    /**
     * Setter of the file name.
     *
     * @param fileName Receives the String of the filename.
     */
    public void setFileName(final String fileName) {
        this.fileName = fileName;
    }

    /**
     * Setter of the path.
     *
     * @param path Receive the String path.
     */
    public void setPath(final String path) {
        this.path = path;
    }

    /**
     * Setter of the file size.
     *
     * @param fileSize Receive the Long number of the size.
     */
    public void setFileSize(final long fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * Getter of the extension.
     *
     * @return the String extension.
     */
    public String getExtension() {
        return extension;
    }

    /**
     * Setter of the Extension.
     *
     * @param extension Input string.
     */
    public void setExtension(final String extension) {
        this.extension = extension;
    }
}
