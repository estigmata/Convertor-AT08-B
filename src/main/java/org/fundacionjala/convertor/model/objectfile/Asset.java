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


import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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
    FFprobe ffprobe = new FFprobe("\\src\\thirdparty\\ffmpeg\\bin\\ffprobe.exe");
    FFmpegProbeResult probeResult;

    /**
     * Constructor for the files to be created, this only have the basic elements.
     *
     * @param path input from the Stream of paths of the walk function.
     */
    public Asset(Path path) throws IOException {
        probeResult = ffprobe.probe(path.getRoot().toString());
        fileName = String.valueOf(path.getFileName());
        this.path = String.valueOf(path.getRoot());
        fileSize = Files.size(path);
    }

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
}
