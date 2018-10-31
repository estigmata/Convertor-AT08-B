/*
 * @VideoFileAsset.java Copyright (c) 2018 Fundacion Jala. All rights reserved.
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

import net.bramp.ffmpeg.probe.FFmpegStream;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Class Video file asset who extends of asset
 *
 * @author Rodrigo Menacho
 * @version 1.0
 */
public class VideoFileAsset extends Asset {
    private String frameRate;
    private String aspectRatio;
    private String resolution;
    private String videoCodec;

    /**
     * Getter  of the Frame rate of the current file.
     *
     * @return String form.
     */
    public String getFrameRate() {
        return frameRate;
    }

    /**
     * Getter of the aspect ratio of the current file.
     *
     * @return String x:y
     */
    public String getAspectRatio() {
        return aspectRatio;
    }

    /**
     * Getter of the resolution of the video.
     *
     * @return String in this form AAAAxBBBB
     */
    public String getResolution() {
        return resolution;
    }

    /**
     * Getter of the video codec.
     *
     * @return String codec
     */
    public String getVideoCodec() {
        return videoCodec;
    }
}
